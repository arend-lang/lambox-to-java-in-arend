#!/usr/bin/env bash
# run-lean-benchmark-suite.sh [lean-to-lambdabox-directory]
#
# Closes every benchmark from benchmarks/TESTS over a small input, extracts
# each with lean-to-lambdabox, then delegates execution to run-ast-suite.sh.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/config.sh"

lean_root=${1:-$HOME/lean-to-lambdabox}
tests="$lean_root/benchmarks/TESTS"
input=${LEAN_BENCH_INPUT:-10}
suite_dir="$WORK_DIR/suites/lean-benchmarks"
ast_dir="$suite_dir/ast"
source="$suite_dir/BenchmarkSuite.lean"

[ -f "$tests" ] || die "benchmark manifest not found: $tests"
case $input in *[!0-9]*|'') die "LEAN_BENCH_INPUT must be a natural number" ;; esac
require_tool "$PYTHON" "set PYTHON to a Python 3 interpreter"
require_tool "$HOME/.elan/bin/lake" "install Lean's lake launcher"
mkdir -p "$ast_dir"

"$PYTHON" - "$tests" "$source" "$ast_dir" "$input" <<'PY'
import pathlib
import sys

manifest, destination, ast_dir, input_value = sys.argv[1:]
lines = ["import FromLeanCommon", "import LeanToLambdaBox", ""]
for stale in pathlib.Path(ast_dir).glob("*.ast"):
    stale.unlink()
for raw in pathlib.Path(manifest).read_text(encoding="utf-8").splitlines():
    raw = raw.strip()
    if not raw or raw.startswith("#"):
        continue
    name, runner, *_ = raw.split(":")
    argument = "()" if runner in ("runonce", "repeat") else input_value
    probe = "suite_" + name
    output = pathlib.Path(ast_dir, name + ".ast").resolve()
    lines.extend([
        f"def {probe} := {name} {argument}",
        f'#erase {probe} to "{output}"',
        "",
    ])
pathlib.Path(destination).write_text("\n".join(lines), encoding="utf-8")
PY

info "extracting lean-to-lambdabox benchmarks with input $input"
(
  cd "$lean_root/benchmarks"
  "$HOME/.elan/bin/lake" build FromLeanCommon
)
(
  cd "$lean_root"
  LEAN_PATH="$lean_root/benchmarks/.lake/build/lib/lean${LEAN_PATH:+:$LEAN_PATH}" \
    "$HOME/.elan/bin/lake" env lean "$source"
)

"$here/run-ast-suite.sh" lean-benchmarks "$ast_dir"
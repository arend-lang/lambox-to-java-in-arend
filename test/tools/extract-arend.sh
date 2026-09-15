#!/usr/bin/env bash
# extract-arend.sh <MODULE:DEF> [outfile]
#
# Typechecks a single definition of the Arend project and prints what that
# definition printed (the ExamplePrint.ard definitions are `putStrLn <text>`,
# so typechecking one of them emits the generated artifact).
#
# A target module of `ExamplePrint` lives in the separate lambox-to-java-examples
# project (see AREND_EXAMPLES_PROJECT in lib.sh), which depends on lambox-to-java;
# every other target (chiefly `Imported.<Module>`, written by stages/java.sh) is
# typechecked in lambox-to-java itself.
#
# The CLI is narrowed to one definition and runs WITHOUT `--serialize`, and the
# project's binary cache dir is cleared first, so a run always typechecks the
# current sources. That is a correctness decision that costs nothing, measured on
# `ExamplePrint:peanoJava`: 38.1 s with a warm .arc cache and `--serialize`,
# 37.2 s warm without it, 33.5-39.6 s with no .arc at all -- all within noise,
# because the time is JVM startup plus loading arend-lib from ~/.arend/libs,
# which this cache does not cover. What the cache did buy was a class of silent
# bug: a stale .arc of a dependency makes the CLI generate code from sources that
# are no longer there (it has already produced two wrong conclusions), and a
# stale .arc of the PRINT module suppresses the `putStrLn` we harvest outright.
#
# The project's `bin` dir is gitignored build output, so clearing it is safe;
# the arend-lib cache in ~/.arend is never touched.
#
# The printed text is delimited by the CLI's
#   --- Typechecking <DEF> ---
#   ...
#   --- Done (NNms) ---
# lines; everything before (library loading warnings) is dropped.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

[ $# -ge 1 ] || die "usage: extract-arend.sh <MODULE:DEF> [outfile]"
target=$1
out=${2-}

case $target in
  ExamplePrint:*) project="$AREND_EXAMPLES_PROJECT"; extra_l=(-L "$ROOT" -L "$AREND_LIBDIR") ;;
  *)              project="$AREND_PROJECT";          extra_l=() ;;
esac

require_tool "$JAVA" "set JAVA to a JDK's java"
if [ ! -f "$AREND_JAR" ]; then
  # An absent jar is a missing TOOLCHAIN, like an absent `java`: run.py records
  # skip-no-tool.
  warn "Arend CLI jar not found: $AREND_JAR (a development build is required)"
  exit "$MISSING_TOOL_EXIT"
fi
[ -f "$project/arend.yaml" ] || die "no arend.yaml in $project"

mkdir -p "$WORK_DIR"
log=$(mktemp "$WORK_DIR/extract-XXXXXX.log")
trap 'rm -f "$log"' EXIT

# No cache may satisfy any module of this run: a stale one of a DEPENDENCY hides
# a source change, and a stale one of the target's own module skips the
# `putStrLn` side effect we harvest. When the target lives in the examples
# project, lambox-to-java's cache is a dependency of it too, so both are cleared.
rm -rf "$project/bin"
[ "$project" = "$AREND_PROJECT" ] || rm -rf "$AREND_PROJECT/bin"

start=$(date +%s%N)
# The exit status is not a reliable success signal: the CLI also returns 1 when
# it merely failed to load some unrelated binary cache. The `--- Done ---`
# marker and the absence of [ERROR] lines are.
info "+ (cd $project && $JAVA $JAVA_STACK -jar $AREND_JAR ${extra_l[*]} arend.yaml $target)"
(cd "$project" && "$JAVA" "$JAVA_STACK" -jar "$AREND_JAR" "${extra_l[@]}" arend.yaml "$target") >"$log" 2>&1 || true
info "extract $target took $(( ($(date +%s%N) - start) / 1000000 ))ms"

if grep -q '^\[ERROR\]' "$log"; then
  cat "$log" >&2
  die "Arend reported errors on $target"
fi

# `[WARN]`/`[INFO]` lines can land INSIDE the delimiters -- the daemon reports
# `[WARN] Slow typecheck (12.5s, threshold 5000ms)` while typechecking, which
# ended up as the last line of six generated Prog.java files and made every one
# of them fail to compile. Generated Java never starts a line with `[`, so
# dropping them is safe with or without the daemon.
text=$(sed -n '/^--- Typechecking /,/^--- Done (/p' "$log" | sed '1d;$d' | grep -vE '^\[(WARN|INFO)\]' || true)
[ -n "$text" ] || { cat "$log" >&2; die "no printed output found for $target"; }

if [ -n "$out" ]; then
  mkdir -p "$(dirname "$out")"
  printf '%s\n' "$text" >"$out"
  info "wrote $out"
else
  printf '%s\n' "$text"
fi

#!/usr/bin/env bash
# Shared by every stage script (stages/*.sh) and by the manual tools/ scripts.
# Sourced, never executed on its own. Tool paths are hard-coded for this
# machine -- edit them below if they move; there is deliberately no per-tool
# environment-variable override any more.

TEST_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$TEST_DIR/.." && pwd)"

info() { printf '[test] %s\n' "$*" >&2; }
warn() { printf '[test] WARNING: %s\n' "$*" >&2; }
die()  { printf '[test] ERROR: %s\n' "$*" >&2; exit 1; }

# --- Layout -------------------------------------------------------------
WORK_DIR="$TEST_DIR/work"
TOOLS_DIR="$TEST_DIR/tools"
CORPORA_DIR="$TEST_DIR/corpora"
RUNTIME_DIR="$TEST_DIR/runtime"
STAGES_DIR="$TEST_DIR/stages"

# --- Arend ---------------------------------------------------------------
# A *development* build of Arend is required: the library relies on the new
# String implementation, not in a release yet. arend.yaml declares
# langVersion: 1.12, so the jar must be a 1.12 build.
AREND_JAR="$HOME/arend-lang-bibin/cli/build/libs/cli-1.12.0-full.jar"
# The ONE environment override in this file, and not an exception to the rule
# above: it is not a tool path made configurable for convenience, it is what
# lets `run.py --jobs N` give each worker a PRIVATE copy of the project.
# Concurrency needs it because a java `gen` is not read-only with respect to the
# project -- `tools/import-ast.sh` writes `src/Imported/<Module>.ard` and
# `tools/extract-arend.sh` does `rm -rf "$project/bin"`, so two workers sharing
# one project would clear each other's cache mid-run. Unset (the normal case)
# means the real project, and serial runs behave exactly as before.
AREND_PROJECT="${AREND_PROJECT:-$ROOT/lambox-to-java}"
# The three hand-written example programs (Example*.ard, ExamplePrint.ard)
# live in their own Arend project so they don't clutter the compiler's
# sources; it depends on lambox-to-java, resolved via two -L search roots
# (the repo root, for lambox-to-java; the default library root, for
# arend-lib -- -L does not add to the default root, it replaces it, so both
# are needed).
# --- Arend CLI daemon (opt-in) -------------------------------------------
# AREND_DAEMON=1 routes every Arend invocation to a long-lived daemon holding a
# warm library, which is what the ~18 s per-invocation cost buys back (see
# tools/extract-arend.sh for where that cost actually goes). Start one with
# `tools/daemon.sh start`; everything then works with or without it.
#
# Requires a CLI that HAS a daemon: it is not in 1.12 as released. Three things
# the daemon changes, each handled where it bites:
#
#   * the library positional must be omitted   -> tools/extract-arend.sh
#   * `bin` must not be cleared under it       -> tools/extract-arend.sh
#   * a definition it thinks is unchanged is not re-typechecked, so the
#     `putStrLn` this harness harvests never runs -> the `--stamp` footer in
#     tools/ast-to-arend, and stamped definition names in golden.py
AREND_DAEMON="${AREND_DAEMON:-0}"

AREND_EXAMPLES_PROJECT="$ROOT/lambox-to-java-examples"
AREND_LIBDIR="$HOME/.arend/libs"
JAVA="$HOME/.jdks/openjdk-26.0.1/bin/java"
JAVAC="${JAVA}c"
JAVA_STACK=-Xss1g            # typechecking a whole generated program needs a big stack
# λ□ `fix` compiles to ordinary, usually non-tail Java recursion, so a
# source-level loop is a call chain as deep as its iteration count; the JVM's
# default ~1 MB thread stack overflows on inputs several benchmarks consider
# small.
JAVA_RUN_STACK=-Xss512m
# `-XX:-DontCompileHugeMethods` lifts HotSpot's refusal to JIT a method over
# 8000 bytecodes: a single machine-generated method (say a Lean match with ten
# alternatives) is naturally that big, and missing the JIT is a cliff, not a
# slope (measured 24 s vs 6 s on lean-deriv).
JAVA_RUN_FLAGS=-XX:-DontCompileHugeMethods
# The hand-written Java that ships with generated code: Rt.java (Fn, Data, BOX,
# PRIM_*) and Main.java.in, the entry-point template. Both are compiled next to
# the generated class by stages/java.sh build -- the extractor emits no `main`.
JAVA_RUNTIME_DIR="$AREND_PROJECT/runtime"

# --- Importing external λ□ programs --------------------------------------
# .ast files from Rocq/Lean/Agda are normalized with Peregrine's `ast box`,
# then turned into Arend source by tools/ast-to-arend (a harness tool, not
# part of the compiler; its output is validated by the Arend typechecker).
PYTHON=python3
AST_TO_AREND="$TOOLS_DIR/ast-to-arend"

# --- Peregrine / CertiRocq (the OCaml and C reference backends) ----------
PEREGRINE="$HOME/peregrine-tool/_build/install/default/bin/peregrine"
PEREGRINE_BOX_FLAGS=   # optional middle-end passes for `ast box`; see README.md
CERTIROCQ_RT="$HOME/.opam/peregrine/lib/coq/user-contrib/CertiRocq/Plugin/runtime"
# malfunction lives in the opam switch peregrine was built in and is usually
# not on PATH.
OPAM_SWITCH_BIN="$HOME/.opam/peregrine/bin"
case ":$PATH:" in
  *":$OPAM_SWITCH_BIN:"*) ;;
  *) PATH="$OPAM_SWITCH_BIN:$PATH" ;;
esac
GCC=gcc
OCAMLOPT=ocamlopt
MALFUNCTION=malfunction

# Stack limit (`ulimit -s`) for running a natively compiled program, for the
# same reason as $JAVA_RUN_STACK: lean-const-fold dies with Stack_overflow at
# this machine's default 8 MB.
NATIVE_RUN_STACK=unlimited

# --- Exit codes: the stage scripts' contract with run.py -----------------
MISSING_TOOL_EXIT=3      # a toolchain is absent           -> skip-no-tool
STAGE_EXIT_UNSUPPORTED=4 # this backend can't run this program -> skip-unsupported

# require_tool <name-or-path> [hint] -- exit with a clear message instead of
# failing cryptically deep in a build.
require_tool() {
  local tool=$1 hint=${2-}
  case $tool in
    */*) [ -x "$tool" ] && return 0 ;;
    *)   command -v "$tool" >/dev/null 2>&1 && return 0 ;;
  esac
  warn "tool not found: $tool${hint:+ ($hint)}"
  exit "$MISSING_TOOL_EXIT"
}

# unsupported <reason> -- for a combination that is declared but impossible,
# e.g. the C backend of a program whose runtime bundle ships no C driver.
unsupported() { warn "unsupported: $*"; exit "$STAGE_EXIT_UNSUPPORTED"; }

# abs_dir <path> -- create the directory and print its ABSOLUTE path. Not
# cosmetic: `peregrine c` writes the #include of its own generated header as
# the -o path verbatim, so a relative outdir only compiles from the one
# directory the generator happened to run in.
abs_dir() { mkdir -p "$1" && (cd "$1" && pwd); }

# run_cmd <cmd> [args...] -- print, then execute.
run_cmd() { info "+ $*"; "$@"; }

# run_cmd_in <dir> <cmd> [args...] -- the same, for commands that must run
# inside the work directory because ocamlopt/malfunction derive module names
# from file names and drop their artifacts next to the sources.
run_cmd_in() {
  local dir=$1
  shift
  info "+ (cd $dir && $*)"
  (cd "$dir" && "$@")
}

# run_cmd_capture <outfile> <cmd> [args...] -- run with stdout AND stderr
# collected into <outfile> (a crash message is part of what the run
# produced), echo that file, and propagate the exit status. Used by the run
# stages: the program's output must be the ONLY thing in <outfile>, because
# run.py reads it as the run's value.
run_cmd_capture() {
  local outfile=$1
  shift
  info "+ $*"
  local status=0
  "$@" >"$outfile" 2>&1 || status=$?
  cat "$outfile"
  return "$status"
}

# load_runtime <bundle> -- source a runtime bundle's vars.sh (assignments
# only) and set RUNTIME_BUNDLE_DIR, against which its bare file names resolve.
load_runtime() {
  RUNTIME_BUNDLE_DIR="$RUNTIME_DIR/$1"
  [ -f "$RUNTIME_BUNDLE_DIR/vars.sh" ] || die "unknown runtime bundle '$1' (no $RUNTIME_BUNDLE_DIR/vars.sh)"
  . "$RUNTIME_BUNDLE_DIR/vars.sh"
}

# copy_unit <name> <outdir> -- a bundle file name, or an absolute path, into
# the work dir; only the basename matters afterwards.
copy_unit() {
  case $1 in
    /*) run_cmd cp "$1" "$2/" ;;
    *)  run_cmd cp "$RUNTIME_BUNDLE_DIR/$1" "$2/" ;;
  esac
}

#!/usr/bin/env bash
# Single source of truth for tool locations. Every path is overridable by an
# environment variable of the same name, e.g.
#   AREND_JAR=/other/cli-full.jar test/run-case.sh peano
#
# Sourced by every script; never executed on its own.

TEST_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT="$(cd "$TEST_DIR/.." && pwd)"

. "$TEST_DIR/lib/log.sh"

# --- Arend ------------------------------------------------------------------
# A *development* build of Arend is required: the library relies on the new
# String implementation, which is not in a release yet (expected in 1.13).
: "${AREND_JAR:=$HOME/arend-lang-bibin/cli/build/libs/cli-1.11.0-full.jar}"
: "${AREND_PROJECT:=$ROOT/lambox-to-java}"
: "${JAVA:=$HOME/.jdks/openjdk-26.0.1/bin/java}"
: "${JAVAC:=${JAVA}c}"
# Evaluating a whole generated program during typechecking needs a big stack.
: "${JAVA_STACK:=-Xss1g}"
# The fixed Java runtime (`Rt.java`: Fn, Data, BOX, PRIM_*) is hand-written, not
# generated; it is compiled next to every generated `Prog.java`.
: "${JAVA_RUNTIME_DIR:=$AREND_PROJECT/runtime}"
# Representation of λ□ primitive ints in the generated Java (the `JavaTarget`
# record in ToJava.ard): `bigint` = java.math.BigInteger (unbounded, no wraparound),
# `long` = Java's built-in 64-bit integer (faster, wraps at 2^64). It selects
# the print-definition variant a case asks for, so
#   JAVA_INT=long test/run-case.sh matmul java
# builds the same program with `Long` arithmetic instead.
: "${JAVA_INT:=bigint}"
case $JAVA_INT in
  bigint) JAVA_DEF_SUFFIX="" ;;
  long)   JAVA_DEF_SUFFIX="Long" ;;
  *)      die "JAVA_INT must be 'bigint' or 'long', got: $JAVA_INT" ;;
esac

# --- Importing external λ□ programs -----------------------------------------
# `.ast` files coming from Rocq/Lean/Agda are turned into Arend source by
# test/tools/ast-to-arend (a harness tool, not part of the compiler -- its
# output is validated by the Arend typechecker). The interface is deliberately
# language-agnostic (a program reading an `.ast` and writing Arend to stdout),
# so the implementation can be replaced without touching any case.
: "${PYTHON:=python3}"
: "${AST_TO_AREND:=$TEST_DIR/tools/ast-to-arend}"

# --- Peregrine / CertiRocq (C and OCaml backends) ---------------------------
: "${PEREGRINE:=$HOME/peregrine-tool/_build/install/default/bin/peregrine}"
: "${CERTIROCQ_RT:=$HOME/.opam/peregrine/lib/coq/user-contrib/CertiRocq/Plugin/runtime}"
# `malfunction` lives in the opam switch peregrine was built in and is usually
# not on PATH; prepend that switch's bin dir instead of requiring `opam env`.
: "${OPAM_SWITCH_BIN:=$HOME/.opam/peregrine/bin}"
if [ -d "$OPAM_SWITCH_BIN" ]; then
  case ":$PATH:" in
    *":$OPAM_SWITCH_BIN:"*) ;;
    *) PATH="$OPAM_SWITCH_BIN:$PATH"; export PATH ;;
  esac
fi
: "${GCC:=gcc}"
: "${OCAMLOPT:=ocamlopt}"
: "${MALFUNCTION:=malfunction}"

# --- Layout -----------------------------------------------------------------
: "${WORK_DIR:=$TEST_DIR/work}"
: "${CASES_DIR:=$TEST_DIR/cases}"
: "${TIMINGS_TSV:=$WORK_DIR/timings.tsv}"

# require_tool <name-or-path> [hint]
# Dies with a clear message instead of failing cryptically deep in a build.
require_tool() {
  local tool=$1 hint=${2-}
  case $tool in
    */*) [ -x "$tool" ] && return 0 ;;
    *)   command -v "$tool" >/dev/null 2>&1 && return 0 ;;
  esac
  die "tool not found: $tool${hint:+ ($hint)}"
}

# Producers are commands declared by a case, e.g.
#   JAVA_PRODUCER="extract-arend ExamplePrint:peanoJava"
#   AST_PRODUCER="cat $CASE_DIR/prog.ast"        # a future deserializer fits here
# They write the artifact to stdout; `produce` redirects it to a file. This is
# why the backends need no knowledge of where an artifact comes from.
extract-arend() { "$TEST_DIR/extract-arend.sh" "$@"; }
# `import-ast <file.ast> <Module>` writes Imported.<Module> and prints nothing,
# so it chains in front of an extract-arend producer:
#   JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast Mutual && extract-arend Imported.Mutual:progJava"
import-ast() { "$TEST_DIR/import-ast.sh" "$@"; }

# produce <producer-command> <outfile>
produce() {
  local producer=$1 out=$2
  [ -n "$producer" ] || die "no producer declared for $out"
  mkdir -p "$(dirname "$out")"
  eval "$producer" >"$out"
}

# work_dir <case> <backend> -- create and echo the scratch dir for one run.
work_dir() {
  local dir="$WORK_DIR/$1/$2"
  mkdir -p "$dir"
  printf '%s\n' "$dir"
}

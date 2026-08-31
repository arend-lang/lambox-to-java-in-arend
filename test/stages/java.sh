#!/usr/bin/env bash
# The three stages of the java backend, one script:
#
#   stages/java.sh gen   <prog.ast> <outdir> [Module]
#   stages/java.sh build <outdir>
#   stages/java.sh run   <outdir>
#
# gen turns a λ□ s-expression file into <outdir>/Prog.java. Arend has no file
# IO, so two steps: tools/import-ast.sh boxes the program with `peregrine ast
# box` and writes it as Arend source ($AREND_PROJECT/src/Imported/<Module>.ard,
# generated, gitignored), then tools/extract-arend.sh typechecks
# Imported.<Module>:progJava, whose body is a `putStrLn`, and captures what it
# printed. <Module> defaults to the CamelCase of the program directory name,
# which is what run.py passes as well: deriving it from the program id is what
# keeps two programs from overwriting each other's Imported module.
#
# build compiles Prog.java together with TWO hand-written files copied in next
# to it: the runtime Rt.java (Fn, Data, BOX, PRIM_*), and Main.java -- the entry
# point, instantiated from runtime/Main.java.in by substituting the generated
# class name. The extractor emits no `main`: a generated class is a library
# exposing `public static Object body()`, so running it is the caller's job, and
# here the caller is this script. See runtime/Main.java.in.
#
# run runs the compiled program; its output goes to stdout and, verbatim, to
# <outdir>/output.txt so the backends can be compared. $JAVA_RUN_STACK and
# $JAVA_RUN_FLAGS are about the GENERATED code, not taste -- see lib.sh.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

stage=${1:?usage: java.sh <gen|build|run> ...}
shift

case $stage in

gen)
  ast=${1:?usage: java.sh gen <prog.ast> <outdir> [Module]}
  outdir=$(abs_dir "${2:?usage: java.sh gen <prog.ast> <outdir> [Module]}")
  module=${3-}
  [ -f "$ast" ] || die "no such .ast file: $ast"
  if [ -z "$module" ]; then
    progdir=$(cd "$(dirname "$ast")" && pwd)
    # lean-const-fold -> LeanConstFold
    module=$(printf '%s\n' "${progdir##*/}" |
      awk -F'[-_]' '{for (i = 1; i <= NF; i++) printf "%s%s", toupper(substr($i, 1, 1)), substr($i, 2)}')
  fi
  require_tool "$JAVA" "set JAVA to a JDK's java"
  require_tool "$PEREGRINE" "set PEREGRINE to the peregrine executable"
  require_tool "$PYTHON" "set PYTHON to a Python 3 interpreter"
  run_cmd "$TOOLS_DIR/import-ast.sh" "$ast" "$module"
  run_cmd "$TOOLS_DIR/extract-arend.sh" "Imported.$module:progJava" "$outdir/Prog.java"
  ;;

build)
  outdir=$(abs_dir "${1:?usage: java.sh build <outdir>}")
  [ -f "$outdir/Prog.java" ] || die "no generated Prog.java in $outdir (run gen first)"
  require_tool "$JAVAC" "set JAVAC (or JAVA) to a JDK"
  run_cmd cp "$JAVA_RUNTIME_DIR/Rt.java" "$outdir/Rt.java"
  # The entry point, with the generated class name substituted in. `Prog` is
  # what stages/java.sh's gen asks the generator for (compileProgram's `name`
  # argument), so the two have to agree; they agree here.
  sed 's/@PROG@/Prog/g' "$JAVA_RUNTIME_DIR/Main.java.in" >"$outdir/Main.java" ||
    die "could not instantiate Main.java from $JAVA_RUNTIME_DIR/Main.java.in"
  info "+ sed s/@PROG@/Prog/g Main.java.in > $outdir/Main.java"
  run_cmd "$JAVAC" -d "$outdir" "$outdir/Rt.java" "$outdir/Prog.java" "$outdir/Main.java"
  ;;

run)
  outdir=$(abs_dir "${1:?usage: java.sh run <outdir>}")
  [ -f "$outdir/Main.class" ] || die "nothing compiled in $outdir (run build first)"
  require_tool "$JAVA" "set JAVA to a JDK's java"
  # `Main`, not `Prog`: the generated class has no entry point (see the header).
  # shellcheck disable=SC2086
  run_cmd_capture "$outdir/output.txt" \
    "$JAVA" "$JAVA_RUN_STACK" $JAVA_RUN_FLAGS -cp "$outdir" Main
  ;;

*) die "unknown stage: $stage (gen|build|run)" ;;
esac

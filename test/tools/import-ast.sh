#!/usr/bin/env bash
# import-ast.sh <ast-file> <Module> [--mode=builder|literal]
#
# Normalizes an external Peregrine λ□ `.ast` file to constructor-block form,
# then turns it into an Arend module so that a program produced by Rocq/Lean/
# Agda can be fed to our compiler (Arend has no file IO: a λ□ program must
# reach the typechecker as Arend source).
#
# The module is written to $AREND_PROJECT/src/Imported/<Module>.ard and is
# GENERATED -- gitignored, overwritten on every run. It defines `progDecls`,
# `progTerm`, `program` and the printing entry points `progJava` /
# `progJavaBigInteger`, so afterwards
#
#   tools/extract-arend.sh Imported.<Module>:progJava
#
# prints the generated Java exactly as it does for the hand-written examples.
#
# Nothing is written to stdout: this is the first half of the java backend's
# generation stage, see stages/java.sh.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

[ $# -ge 2 ] || die "usage: import-ast.sh <ast-file> <Module> [--mode=...]"
ast=$1
module=$2
shift 2

[ -f "$ast" ] || die "no such .ast file: $ast"
require_tool "$PEREGRINE" "set PEREGRINE to the peregrine executable"
require_tool "$PYTHON" "set PYTHON to a Python 3 interpreter"
[ -x "$AST_TO_AREND" ] || die "importer not executable: $AST_TO_AREND"

dir="$AREND_PROJECT/src/Imported"
mkdir -p "$dir"
out="$dir/$module.ard"
boxed=$(mktemp --suffix=.boxed.ast)
trap 'rm -f "$boxed"' EXIT

# External `.ast` files use curried constructor applications. `ast box` runs
# MetaRocq's verified constructors-as-blocks pass, producing the saturated
# representation required by LambdaBox.ard and ToJava.ard. Python then only
# translates and validates that representation; it performs no normalization.
#
# $PEREGRINE_BOX_FLAGS (unquoted on purpose) additionally enables Peregrine's
# optional middle-end passes, so a case can be measured with and without them
# without touching this script; see lib.sh.
# `ast box` prints its progress AND its parse errors on stdout; they go to stderr
# here, so that this script writes nothing to stdout (it is one half of a
# generation stage) while a rejected file still says WHY it was rejected -- that
# message is all run.py has to show for a gen-fail.
# shellcheck disable=SC2086
"$PEREGRINE" ast box "$ast" $PEREGRINE_BOX_FLAGS -o "$boxed" >&2

# On unsupported or non-block-form input the importer exits non-zero with a
# message on stderr; `set -e` then stops the whole stage, which is what we want.
"$PYTHON" "$AST_TO_AREND" "$@" -o "$out" "$boxed"
info "boxed and imported $ast -> Imported.$module ($(wc -l <"$out") lines)"

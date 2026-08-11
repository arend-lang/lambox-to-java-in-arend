#!/usr/bin/env bash
# import-ast.sh <ast-file> <Module> [--mode=builder|literal]
#
# Turns an external Peregrine λ□ `.ast` file into an Arend module of the
# project, so that a program produced by Rocq/Lean/Agda can be fed to our
# compiler (Arend has no file IO: a λ□ program must reach the typechecker as
# Arend source).
#
# The module is written to $AREND_PROJECT/src/Imported/<Module>.ard and is
# GENERATED -- gitignored, overwritten on every run. It defines `progDecls`,
# `progTerm`, `program` and the printing entry points `progJava` /
# `progJavaLong`, so afterwards
#
#   extract-arend Imported.<Module>:progJava
#
# prints the generated Java exactly as it does for the hand-written examples.
#
# Nothing is written to stdout: this is meant to be chained in front of an
# extract-arend producer inside a case's JAVA_PRODUCER.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/config.sh"

[ $# -ge 2 ] || die "usage: import-ast.sh <ast-file> <Module> [--mode=...]"
ast=$1
module=$2
shift 2

[ -f "$ast" ] || die "no such .ast file: $ast"
require_tool "$PYTHON" "set PYTHON to a Python 3 interpreter"
[ -x "$AST_TO_AREND" ] || die "importer not executable: $AST_TO_AREND (set AST_TO_AREND)"

dir="$AREND_PROJECT/src/Imported"
mkdir -p "$dir"
out="$dir/$module.ard"

# On an unsupported construct the importer exits non-zero with a message on
# stderr; `set -e` then stops the whole case, which is what we want -- a
# half-written module would fail much less clearly during typechecking.
"$PYTHON" "$AST_TO_AREND" "$@" -o "$out" "$ast"
info "imported $ast -> Imported.$module ($(wc -l <"$out") lines)"

#!/usr/bin/env bash
# Shared declarations for an axiom-free ("Peano") Lean case: a checked-in
# prog.ast erased with `config { nat := .peano, extern := .preferLogical }`, whose
# result is a Lean `Bool`. Sourced from a case.sh after it has set ARENDMOD:
#
#   ARENDMOD=LeanConstFoldPeano
#   . "$LEAN_PEANO_DRIVERS/peano-case.sh"
#
# All four backends read the SAME file (that is the point -- see README.md), so
# this fragment declares them all, along with the two tiny drivers and the
# non-empty-but-empty attribute file each of Peregrine's backends insists on.
BACKENDS="java c ocaml eval"

AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast $ARENDMOD && extract-arend Imported.$ARENDMOD:progJava$JAVA_DEF_SUFFIX"
ATTR_C_PRODUCER="cat $LEAN_PEANO_DRIVERS/empty.attr"
ATTR_OCAML_PRODUCER="cat $LEAN_PEANO_DRIVERS/empty.attr"

C_DRIVER="$LEAN_PEANO_DRIVERS/main.c"
OCAML_DRIVER="$LEAN_PEANO_DRIVERS/bench_main.ml"
OCAML_MODULE=bench
OCAML_EXTRA="$LEAN_PEANO_DRIVERS/bench.mli"

# Every compiled backend prints the Bool's constructor ordinal; `eval` prints
# `constr Bool.true`, which is why check-case.sh does not diff `eval`.
EXPECTED=1

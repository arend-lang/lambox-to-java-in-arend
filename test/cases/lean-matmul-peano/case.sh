#!/usr/bin/env bash
# 20x20 all-ones matrix multiplication and summation over UNARY (Peano) natural
# numbers, written in Lean and extracted by lean-to-lambdabox with
#
#   config { nat := .peano, extern := .preferLogical }
#
# i.e. Lean's `Nat` stays an inductive type and `Nat.add`/`mul`/`beq` are erased
# from their logical definitions instead of being left as @[extern] axioms.
#
# This case exists to include Peregrine's own EVALUATOR in the comparison. The
# prim-int `matmul` program cannot be evaluated: `--attributes` remaps an axiom
# onto a native C/OCaml symbol, which the evaluator has no implementation for
# (`Eprim: prim not found`). An axiom-free program needs no attributes at all,
# so all four backends -- and only for such a program, the evaluator too -- run
# the very same file.
#
# The result is a `Bool` (`Nat.beq sum (size*size*size)`) rather than the sum
# itself, on purpose: a unary 8000 is a 8000-deep term, and every backend here
# renders a value with per-level indentation, so printing it would cost more
# than computing it and the measurement would be about the printer. As a Bool,
# `main.c`'s `>> 1` and the OCaml driver both print the constructor's ordinal
# among the nullary constructors of `false | true`, i.e. the expected 1; our Java
# prints the same tag, and the evaluator prints `constr Bool.true`.
#
# Regenerate prog.ast (the file is otherwise unmodified):
#   cp prog.lean $HOME/lean-to-lambdabox/MatMulPeano.lean
#   cd $HOME/lean-to-lambdabox && $HOME/.elan/bin/lake env lean MatMulPeano.lean
#   cp prog.ast <this directory>/prog.ast
# Change `def size` in prog.lean to scale it. Note the evaluator's ceiling:
# size 10/20/30 evaluate in ~1.5/5.8/27 s and up to ~1.2 GB, and its --fuel is a
# unary number allocated up front (see EVAL_FUEL in config.sh).

BACKENDS="java c ocaml eval"

AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast LeanMatmulPeano && extract-arend Imported.LeanMatmulPeano:progJava$JAVA_DEF_SUFFIX"
# No axioms, so the attribute files are empty -- but Peregrine's C and OCaml
# backends still want the flag, and the harness a producer.
ATTR_C_PRODUCER="cat $CASE_DIR/prog.attr"
ATTR_OCAML_PRODUCER="cat $CASE_DIR/prog.attr"
C_DRIVER=main.c
OCAML_DRIVER=peanomm_main.ml
OCAML_MODULE=peanomm
OCAML_EXTRA="peanomm.mli"
# The evaluator needs enough fuel; at size 20 this is comfortably above what the
# program uses, and unused fuel only costs the allocation (~0.4 s per 1e7).
: "${EVAL_FUEL:=30000000}"
NOTE="expected: 1 (Bool.true: the 20x20 unary sum equals 20^3); eval prints 'constr Bool.true'"

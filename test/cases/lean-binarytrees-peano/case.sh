#!/usr/bin/env bash
# The upstream `binarytrees` benchmark (see ../lean-binarytrees/) erased WITHOUT
# axioms: `config { nat := .peano, extern := .preferLogical }`. See
# ../../lean-peano-drivers/README.md for why an axiom-free variant exists at all --
# it is the only way `peregrine c` and `peregrine eval` will touch a Lean program.
#
# Input 8 (not 12): the tree count grows exponentially and the naturals are unary.
# The result is `Nat.beq (binarytrees 8) 26128`, 26128 being Lean's own answer
# (confirmed with its native compiler), written as `163*160+48` in prog.lean.
#
# This is the corpus' only allocation-dominated program that all four backends run,
# so it is the fairest place to compare `Rt.Data` (one JVM object per node) against
# CertiRocq's GC and OCaml's minor heap.
ARENDMOD=LeanBinaryTreesPeano
. "$LEAN_PEANO_DRIVERS/peano-case.sh"

: "${EVAL_FUEL:=30000000}"
NOTE="expected: $EXPECTED (Bool.true: binarytrees 8 = 26128); eval prints 'constr Bool.true'"

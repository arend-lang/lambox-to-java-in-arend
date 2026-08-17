#!/usr/bin/env bash
# The upstream `const_fold` benchmark (see ../lean-const-fold/) erased WITHOUT
# axioms: `config { nat := .peano, extern := .preferLogical }`, i.e. unary
# naturals and Lean's arithmetic taken from its logical definitions.
#
# Why the same benchmark twice: the axiom version compares OUR realizations of
# Lean's primitives against Lean's own OCaml ones, but `peregrine c` and
# `peregrine eval` reject it. This version has no axioms, so all four backends
# compile the identical λ□ file -- the only configuration in which the C backend
# and the evaluator ever see a Lean program. See ../../lean-peano-drivers/README.md.
#
# Input 10 (not 20): unary arithmetic, so everything is smaller here. The result is
# `Nat.beq (const_fold 10) 4772`, and 4772 is Lean's own answer (confirmed with its
# native compiler), written as `68*70+12` in prog.lean for the reason documented
# there.
ARENDMOD=LeanConstFoldPeano
. "$LEAN_PEANO_DRIVERS/peano-case.sh"

# const_fold 10 in unary needs more steps than the default fuel.
: "${EVAL_FUEL:=30000000}"
NOTE="expected: $EXPECTED (Bool.true: const_fold 10 = 4772); eval prints 'constr Bool.true'"

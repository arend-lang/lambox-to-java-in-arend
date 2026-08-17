#!/usr/bin/env bash
# 130x130 all-ones matrix multiplication and result summation, written in Lean
# and extracted by lean-to-lambdabox. The checked-in prog.lean is the source;
# prog.ast is its generated, otherwise unmodified λ□ output.
#
# Nat is Lean's, i.e. the four arithmetic primitives survive erasure as λ□
# axioms (.Nat.add/.sub/.beq/.mul) -- so this case runs on the same shared
# realizations as the other Lean cases (Zarith, ../../lean-ocaml-runtime/) and
# the two backends realize those axioms independently. No C backend: `peregrine
# c` rejects a program with axioms outright ("use Extract Constant to realize
# them in C"), and no upstream C realizations exist.
ARENDMOD=LeanMatmul
. "$LEAN_OCAML_RT/lean-case.sh"

EXPECTED=2197000
NOTE="expected: $EXPECTED (= 130^3), independently extracted from Lean"

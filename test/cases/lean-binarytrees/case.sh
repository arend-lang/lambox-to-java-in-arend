#!/usr/bin/env bash
# `binarytrees` (the Computer Language Benchmarks Game program) from Lean 4's own
# code-generator benchmarks, as shipped by lean-to-lambdabox
# (benchmarks/FromLeanCommon/binarytrees.lean, revision 58701f8). NOT our
# program: the .lean is a verbatim copy and prog.ast is its unmodified λ□ output.
#
# What it exercises that no other case does: allocation. It builds a "stretch"
# tree, keeps a long-lived tree alive, then builds and drops many bottom-up trees
# — deliberately designed to stress a garbage collector rather than arithmetic.
# For us that means it measures `Rt.Data` (one object per node) against OCaml's
# 3-word blocks, which is exactly the structural difference profiling identified
# as the residual gap to the OCaml backend.
#
# Input 12 instead of upstream's 17: the tree count grows exponentially, and 17
# costs minutes per backend.
ARENDMOD=LeanBinaryTrees
. "$LEAN_OCAML_RT/lean-case.sh"

EXPECTED=679974
NOTE="expected: $EXPECTED (upstream binarytrees at n=12, confirmed with Lean's native compiler)"

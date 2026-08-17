#!/usr/bin/env bash
# `rbmap_mono` from Lean 4's own code-generator benchmarks, as shipped by
# lean-to-lambdabox (benchmarks/FromLeanCommon/rbmap_mono.lean, revision
# 58701f8): inserts n keys into a red-black map carrying its own well-formedness
# proof, then folds over it counting the `true` values. NOT our program: the .lean
# is a verbatim copy and prog.ast is its unmodified λ□ output.
#
# Why it is worth having: it is the corpus' only balanced-tree workload, i.e. deep
# pattern matching over a 5-constructor inductive with rebalancing — many small
# `Rt.Data` nodes, short-lived, plus the erased proof component (the map is a
# subtype `⟨tree, wellFormed⟩`, so this also exercises how □ arguments survive
# erasure).
#
# Input 20000 instead of upstream's 1000000: 1e6 insertions is minutes per
# backend, and the shape of the work does not change with n.
ARENDMOD=LeanRbmapMono
. "$LEAN_OCAML_RT/lean-case.sh"

EXPECTED=2000
NOTE="expected: $EXPECTED (= #{k < 20000 | k % 10 == 0}; upstream rbmap_mono at n=20000)"

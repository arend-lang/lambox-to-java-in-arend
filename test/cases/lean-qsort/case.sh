#!/usr/bin/env bash
# `qsort` from Lean 4's own code-generator benchmarks, as shipped by
# lean-to-lambdabox (benchmarks/FromLeanCommon/qsort.lean, revision 58701f8): for
# each i < n it fills an array with a bad LCG, sorts it in place with Lean's
# `Array.qsort`, and checks the result is sorted. NOT our program: the .lean is a
# verbatim copy and prog.ast is its unmodified λ□ output.
#
# Why it is worth having: it is the first case in the corpus that uses Lean's
# ARRAY primitives (`Array.get!Internal`, `Array.set!`, `Array.push`, `Array.size`
# ...), i.e. the part of `javaAxioms` that no other case ever touched. Our Java
# realizes them persistently in `Rt`, upstream's OCaml uses J.-C. Filliâtre's
# persistent arrays (`LeanArray.ml`) — two independent implementations of the same
# axioms, on a program that permutes an array 200 times.
#
# Caveat on the oracle: the program returns the NUMBER OF UNSORTED RESULTS, so the
# expected value is 0. That is a weak check (a backend that broke the comparison
# could still report 0), so treat this case primarily as an axiom-coverage and
# performance case, and `lean-const-fold`/`lean-deriv`/`lean-binarytrees` as the
# value-carrying ones.
#
# Input 200 instead of upstream's 1000: cost is quadratic in n here.
ARENDMOD=LeanQsort
. "$LEAN_OCAML_RT/lean-case.sh"

EXPECTED=0
NOTE="expected: $EXPECTED (= number of arrays that came back unsorted; upstream qsort at n=200)"

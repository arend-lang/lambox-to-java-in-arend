#!/usr/bin/env bash
# Runtime bundle `lean`: everything a lean-to-lambdabox benchmark whose Lean
# primitives survived erasure as λ□ AXIOMS needs on the OCaml side.
#
# Assignments only -- no logic, no producers. A stage script sources this file
# and resolves every file name below against this directory.
#
# Why the axioms need no attribute entry: Peregrine compiles an unrealized axiom
# to `(global $Axioms $def__Nat_add)`, i.e. it expects a module named `Axioms`.
# That is the whole contract (see README.md); the program's prog.attr is the
# empty attributes file.
#
# The realizations are lean-to-lambdabox's OWN OCaml code, copied verbatim, so
# the two backends of such a program implement the same axioms independently:
# ours in ToJava.ard's `javaAxioms` -> runtime/Rt.java, theirs in
# nat.ml/int.ml/eq.ml/decidable.ml/LeanArray.ml.

# The generated module is named `bench`; bench_main.ml refers to `Bench.main`
# and bench.mli is its interface, so the three must agree.
OCAML_MODULE=bench
OCAML_DRIVER=bench_main.ml

# Dependency order matters: `axioms.ml` is the module Peregrine's output refers
# to and only re-exports the rest. `bench.mli` is last because it types the
# generated module (`malfunction cmx` emits no .cmi of its own); it is the single
# file that the six axiom benchmarks used to check in six byte-identical copies
# of, all of them `val main: Z.t` -- every one of them returns a Lean `Nat`,
# which is why one driver serves them all.
OCAML_EXTRA="decidable.mli decidable.ml
             eq.mli eq.ml
             nat.mli nat.ml
             int.mli int.ml
             LeanArray.mli LeanArray.ml
             axioms.mli axioms.ml
             bench.mli"

# nat.ml/int.ml represent a Lean `Nat` as a Zarith integer, so the compiler must
# be ocamlfind's wrapper and the link step must pull the package in.
OCAMLOPT="ocamlfind ocamlopt"
OCAML_FLAGS="-package zarith"
OCAML_LINK_FLAGS="-linkpkg"

# No C driver: `peregrine c` rejects a program with axioms outright ("Axioms
# found, use Extract Constant to realize them in C") and no C realizations of
# Lean's primitives exist upstream -- they would have to allocate (`Decidable`)
# through the CertiRocq GC. That is a real gap, not an oversight; the `peano`
# bundle is the axiom-free way around it.
C_DRIVER=

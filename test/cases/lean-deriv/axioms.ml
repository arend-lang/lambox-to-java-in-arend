(* The module Peregrine's OCaml backend expects an unrealized axiom to come
   from: `.Nat.add` is compiled to `(global $Axioms $def__Nat_add)`, so no
   `--attributes` entry is involved at all -- the name is a convention.

   Nat/Int/Eq/Decidable are lean-to-lambdabox's own realizations, copied
   verbatim (see nat.ml). Upstream's axioms.ml also `include LeanArray`; this
   program uses no Lean `Array`, and leaving it out keeps the case free of the
   extra dependency. *)
include Int
include Nat
include Eq

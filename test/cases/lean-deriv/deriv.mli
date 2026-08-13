(* Hand-written interface for the Malfunction-generated `deriv.mlf`
   (`malfunction cmx` produces no .cmi of its own, Malfunction being untyped).
   The erased term is a closed Lean `Nat`, and the realizations in nat.ml treat
   a Nat as a Zarith integer -- which is compatible with Malfunction's unboxed
   representation of a λ□ primitive int, since Zarith represents a small number
   as a plain OCaml int. *)
val main : Z.t

(* Hand-written interface for the Malfunction-generated `peanomm.mlf`
   (`malfunction cmx` produces no .cmi of its own, Malfunction being untyped).
   The program's result is a Lean `Bool`, and Malfunction represents a NULLARY
   constructor as a plain unboxed int -- its ordinal among the nullary
   constructors -- so `int` is the right type here, and `false | true` means the
   expected value is 1. *)
val main : int

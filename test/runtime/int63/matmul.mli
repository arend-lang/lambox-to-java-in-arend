(* Hand-written interface for the Malfunction-generated `matmul.mlf` module,
 * needed because `malfunction cmx` itself produces no .cmi (Malfunction is
 * untyped) -- compile this BEFORE `malfunction cmx matmul.mlf` so the .cmi
 * exists for matmul_main.ml to type-check against. Result is a primInt,
 * which Malfunction represents as plain unboxed OCaml int (see Compile.v). *)
val main : int

(* tPrim primInt literals/results compile to plain unboxed OCaml int under
 * Malfunction (Compile.v: tPrim ... => Mnum (numconst_Int i)), so no
 * decoding is needed here (unlike the C backend's 2n+1 encoding). *)
let () = Printf.printf "%d\n" Matmul.main

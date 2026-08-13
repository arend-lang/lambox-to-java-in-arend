(* Prints the returned Lean Nat, as upstream's natio.ml.template does.
   Expected: 40230090. *)
let () = print_endline (Z.to_string Deriv.main)

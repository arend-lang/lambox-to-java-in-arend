(* Linked against Malfunction-compiled code via `(global $Prim_int63 $fn)`,
 * so the ABI is whatever the runtime representation of the argument/return
 * values is under the EAst-to-Malfunction translation (Compile.v), NOT
 * ordinary OCaml calling-convention typing:
 *  - tPrim primInt literals/results compile to plain unboxed OCaml `int`
 *    (tPrim ... => Mnum (numconst_Int i)) -- so add/mul/sub, taking and
 *    returning plain `int`, need no special encoding.
 *  - inductive constructors are compiled MIXED, same as native OCaml
 *    variants: nullary constructors become a plain unboxed int equal to
 *    their ordinal AMONG NULLARY CONSTRUCTORS ONLY (confirmed by inspecting
 *    the generated .mlf: `(switch $discr ((0 0) ...) ((1 1) ...))`, an
 *    integer-range switch, for a `case` on BoolBlock/ListBlock's nil), while
 *    non-nullary constructors (List's `cons`) become `(block (tag k) ...)`
 *    with `k` the ordinal among NON-nullary constructors only. So eqb must
 *    return a plain int equal to BoolBlock's declared nullary ordinal
 *    (false=0, true=1; see ExampleMatMul.ard's `decls`), NOT an allocated
 *    block, NOT Rocq's own `bool` encoding (true=0,false=1 there).
 *)

let add (a : int) (b : int) : int = a + b
let mul (a : int) (b : int) : int = a * b
let sub (a : int) (b : int) : int = a - b

let eqb (a : int) (b : int) : int = if a = b then 1 else 0

# OCaml realizations for Lean's primitives (not ours)

Every file here except this README is a **verbatim copy** from
`lean-to-lambdabox`, revision `58701f8`, directory `benchmarks/via_malfunction`:

| file | upstream name |
|---|---|
| `decidable.mli`, `decidable.ml` | same |
| `eq.mli`, `eq.ml` | same |
| `nat.mli`, `nat.ml` | same |
| `int.mli`, `int.ml` | same |
| `axioms.mli`, `axioms.ml` | same |
| `LeanArray.mli` | same |
| `LeanArray.ml` | `JCFArray.ml` (persistent arrays, Baker's trick, © J.-C. Filliâtre, LGPL-2.1-with-linking-exception) |

They exist because `lean-to-lambdabox` erases Lean's `@[extern]` primitives
(`Nat.add`, `Nat.decEq`, `Array.push`, `Eq.rec`, …) to **axioms**, i.e. λ□
constants with no body, and Peregrine's OCaml backend compiles an unrealized
axiom to `(global $Axioms $def__Nat_add)`. So the *module name* `Axioms` and the
`def__*` names are the whole contract: linking a module `Axioms` that defines
them is how the program becomes runnable. `axioms.ml` is just
`include Int/Nat/Eq/LeanArray`.

Upstream's `Makefile` selects between plain and `-inline`/`-pruned` variants of
these modules; we take the plain ones (`INLINE_AXIOMS=0`, `PRUNE_CONSTRUCTORS=0`
in upstream terms), which is what the erasure config we use expects — we do not
pass `remove_irrel_constr_args := true`.

Nothing here is written by us: they are Lean's semantics for the OCaml backend,
and the Java backend's counterpart is `javaAxioms` in `ToJava.ard` →
`runtime/Rt.java`. That is exactly the point of the differential cases: the same
λ□ program runs against two independently written sets of realizations.

`nat.ml`/`int.ml` are Zarith-based, so a case using them declares

    OCAMLOPT="ocamlfind ocamlopt"
    OCAML_FLAGS="-package zarith"
    OCAML_LINK_FLAGS="-linkpkg"

and `LeanArray.ml` needs OCaml ≥ 5.2 (`Dynarray`).

A case pulls them in through `OCAML_EXTRA`, with `$LEAN_OCAML_RT/` in front of
each name; `build-ocaml.sh` copies them into the work directory and compiles
them there, in the declared order (`decidable`, `eq`, `nat`, `int`,
`LeanArray`, `axioms` — dependencies first).

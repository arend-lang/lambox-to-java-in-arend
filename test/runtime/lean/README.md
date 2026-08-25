# Runtime bundle `lean` — OCaml realizations for Lean's primitives (not ours)

Every file here except this README, `vars.sh`, `bench.mli` and `bench_main.ml` is
a **verbatim copy** from
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

`nat.ml`/`int.ml` are Zarith-based, so `vars.sh` declares

    OCAMLOPT="ocamlfind ocamlopt"
    OCAML_FLAGS="-package zarith"
    OCAML_LINK_FLAGS="-linkpkg"

and `LeanArray.ml` needs OCaml ≥ 5.2 (`Dynarray`).

The two files that are ours:

| file | role |
|---|---|
| `bench_main.ml` | prints `Z.to_string Bench.main` — the same two lines upstream's `natio.ml.template` generates, minus the command-line argument (our programs are closed over their input during erasure) |
| `bench.mli` | `val main: Z.t`, the interface for the malfunction-generated module (`malfunction cmx` emits no `.cmi`). The six axiom benchmarks used to check in six byte-identical copies of this file |

`vars.sh` lists them all in `OCAML_EXTRA`, as bare names resolved against this
directory; the OCaml stage scripts copy them into the work directory and compile
them there, in the declared order (`decidable`, `eq`, `nat`, `int`, `LeanArray`,
`axioms` — dependencies first — then `bench.mli`).

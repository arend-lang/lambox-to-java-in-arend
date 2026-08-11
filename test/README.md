# Test harness

Takes a λ□ program defined in Arend, produces the target code for each backend,
compiles it, runs it, times every stage and prints the program's output.
There are **no assertions** — correctness is judged by eye, with the backends'
outputs next to each other.

## Layout

One script per verb; scripts call scripts, no `case`/`if` dispatch tables.

    config.sh           tool paths (all env-overridable) + require_tool, produce
    load-case.sh        sourced by every backend script: config + timing + the case
    lib/log.sh          info / warn / die (everything to stderr)
    lib/timing.sh       timed <case> <backend> <stage> -- cmd...
    extract-arend.sh    <MODULE:DEF> [outfile] -> the artifact that definition printed
    import-ast.sh       <file.ast> <Module>  external λ□ file -> Imported.<Module>
    tools/ast-to-arend  the importer itself (Python 3): .ast -> Arend source
    build-java.sh       <case>  extract Prog.java + copy Rt.java + javac
    run-java.sh         <case>  build-java.sh + run-timed.sh
    build-c.sh          <case>  extract .ast/.attr + peregrine c + gcc
    run-c.sh            <case>  build-c.sh + run-timed.sh
    build-ocaml.sh      <case>  extract .ast/.attr + peregrine ocaml + malfunction + ocamlopt
    run-ocaml.sh        <case>  build-ocaml.sh + run-timed.sh
    run-timed.sh        <case> <backend> -- cmd...   time, print and tee output.txt
    run-case.sh         <case> [backend...]          one case, its declared backends
    run-all.sh          [case...]                    every case, then summary.sh
    summary.sh          [case...]  timing table + every backend's output
    case-backends.sh    <case>  the case's BACKENDS, one per line
    case-note.sh        <case>  the case's NOTE (expected result)
    cases/<case>/case.sh  declarative case description (variables only)
    work/               gitignored scratch: work/<case>/<backend>/...

## Usage

    test/run-all.sh                                         # everything + summary
    test/run-case.sh matmul                                 # one case, all its backends
    test/run-case.sh matmul java                            # one backend only
    test/build-c.sh matmul                                  # a single stage, by hand
    test/extract-arend.sh ExamplePrint:peanoJava            # print generated Java
    test/extract-arend.sh ExamplePrint:matMulSexpr prog.ast # write the λ□ s-expression
    test/import-ast.sh cases/peano-ast/prog.ast PeanoAst   # import an external λ□ file

## How artifacts are obtained

`lambox-to-java/src/ExamplePrint.ard` has one `\func` per artifact, each of the
form `putStrLn <text>`, so *typechecking* the definition prints it.
`extract-arend.sh` runs the CLI narrowed to a single `MODULE:DEF` and slices the
text between the CLI's `--- Typechecking ... ---` and `--- Done (NNms) ---`
lines, which replaces the old manual copy-paste into `lambox-to-java/out*/`.

The CLI is never invoked with `--serialize`: a binary cache would suppress the
print on subsequent runs.

## Prerequisites

* A **development build** of Arend (`AREND_JAR`, e.g.
  `cli-1.11.0-full.jar`). The library relies on the new `String`
  implementation, which is not released yet (expected in 1.13).
* Python 3 (`PYTHON`) for `tools/ast-to-arend`, needed only by the cases that
  import an external `.ast`; stdlib only, nothing to install.
* A JDK (`JAVA`, `JAVAC`); `JAVA_STACK=-Xss1g` is required, since evaluating a
  whole generated program during typechecking is stack-hungry.
* The fixed Java runtime `Rt.java` (`Fn`, `Data`, `BOX`, the primitive int
  ops `PRIM_{ADD,MUL,SUB,EQB}_{INT,LONG}` and the `unbound`/`freeVar` failure
  helpers for ill-formed λ□ input) from
  `JAVA_RUNTIME_DIR` (`lambox-to-java/runtime`). It is hand-written, not
  generated: `build-java.sh` copies it into the work dir and compiles it
  together with the generated `Prog.java`. The primitive ops realize matmul's
  four arity-2 λ□ axioms — the Java counterpart of remapping them onto
  CertiRocq's `prim_int63_*` via peregrine's `--attributes`; the mapping lives
  in `javaAxioms` in `ToJava.ard`.
* For the C/OCaml backends: `PEREGRINE`, the CertiRocq runtime
  (`CERTIROCQ_RT`, providing `gc_stack.c` and `prim_int63.c`), `gcc`,
  `ocamlopt` and `malfunction` (the latter comes from the opam switch
  Peregrine was built in; `config.sh` puts `$OPAM_SWITCH_BIN` on `PATH`).

Missing tools are reported by `require_tool` with a clear message.

## Integer representation of the Java backend

`JAVA_INT` picks how λ□ primitive ints are represented in the generated Java
(the `JavaTarget` record in `ToJava.ard`); both variants use the same
`Rt.java`:

    test/run-case.sh matmul java               # JAVA_INT=bigint (default)
    JAVA_INT=long test/run-case.sh matmul java

* `bigint` — `java.math.BigInteger` literals and `Rt.PRIM_*_INT`: unbounded,
  never overflows, but boxed arithmetic and no wraparound.
* `long` — `Long.valueOf(..L)` literals and `Rt.PRIM_*_LONG`, i.e. Java's
  built-in 64-bit integers: much faster (matmul: ~1.1s vs ~8.1s run time), wraps
  at 2^64 and signed.

Neither matches the source semantics: a λ□ `prim (primInt, _)` is a 63-bit
machine integer with cyclic (mod 2^63) arithmetic — MetaRocq
`erasure/theories/EPrimitive.v` (`primIntModel (i : PrimInt63.int)`) and the
[Rocq refman on primitive integers](https://rocq-prover.org/doc/master/refman/language/core/primitive.html)
(unsigned view `Uint63`, signed view `Sint63`) — which is what the C backend
(CertiRocq `prim_int63_{add,mul,sub,eqb}`) and the OCaml backend (unboxed OCaml
`int`, cf. `ExtrOCamlInt63`) implement. Our own AST is unbounded too
(`LambdaBox.ard`'s `PrimModel primInt => Int`), so the three layers agree only
while values stay well below 2^62 — true for all current cases. A future
`JAVA_INT=int63` (backed by a `Rt.PRIM_*_INT63` family normalizing mod 2^63) is
the planned fix; see the int63-mismatch section of `RESEARCH_AND_PLAN.md`. Until
then, comparing the `java` output against `c`/`ocaml` for a case whose values
exceed 2^62 is expected to differ.

A case declares its Java producer as `...:<name>Java$JAVA_DEF_SUFFIX`, and
`config.sh` turns `JAVA_INT` into that suffix (`""` / `"Long"`), so the switch
applies to every case without touching any backend script. Both variants build
into the same `work/<case>/java` dir, i.e. the last run wins.

## Cases

A case is a directory under `cases/` with a `case.sh` holding *variables only*,
plus any driver files it needs (`main.c` for C; `matmul_main.ml`,
`prim_int63.ml/.mli` and the hand-written `matmul.mli` for OCaml — `malfunction
cmx` emits no `.cmi`, so the interface is compiled separately).

`BACKENDS` lists the backends the case supports; `example` and `peano` only
declare `java`, since they return constructor data rather than a primitive int
and have no C/OCaml driver yet. `matmul-ast` and `peano-ast` hold a `prog.ast`
instead of pointing at a hand-written Arend program (see "Importing external λ□
programs").

### Producers

Every artifact is obtained by running a *producer command* declared by the case
(`JAVA_PRODUCER`, `AST_PRODUCER`, `ATTR_C_PRODUCER`, `ATTR_OCAML_PRODUCER`),
which writes the artifact to stdout. That is the extension point: to test a λ□
program that comes from an s-expression file instead of Arend, declare

    AST_PRODUCER="cat $CASE_DIR/prog.ast"

which is what the `matmul-ast` and `peano-ast` cases do — the backend scripts do
not change.

### Attribute files

`matmul`'s four primitive-op axioms are realized per backend: for C on the
CertiRocq runtime's `prim_int63_{add,mul,sub,eqb}` (so `prim_int63.c` must be on
the `gcc` line — the default Peregrine harness links only `gc_stack.c`), for
OCaml on the hand-written `Prim_int63` wrapper (the OCaml backend only consumes
`reConstS`, i.e. `"Module.value"`; the rest of `RemappedConstant` is ignored).

ABI notes: CertiRocq encodes a prim int `n` as the odd machine word `2n+1`,
hence the `>> 1` in `main.c`. In OCaml, `tPrim primInt` is a plain `int`, and
nullary inductive constructors are plain ints too (ordinal among nullary
constructors only) — only non-nullary constructors become real blocks.

This replaces the former hand-run `lambox-to-java/outc/build-and-run.sh` and
`outocaml/build-and-run-ocaml.sh`, which required copy-pasting the printed
`.ast`/`.attr` lines into `lambox-to-java/out*/` by hand.

## Importing external λ□ programs

A λ□ program produced elsewhere (Rocq/Lean/Agda via `peregrine extract`) arrives
as an `.ast` s-expression file, but Arend has no file IO: our compiler runs
*during typechecking*, so a program must reach it as Arend source.
`test/tools/ast-to-arend` (Python 3, stdlib only) bridges that gap, and
`import-ast.sh` wires it into the harness:

    test/import-ast.sh cases/matmul-ast/prog.ast MatmulAst
    test/extract-arend.sh Imported.MatmulAst:progJava

The importer writes `lambox-to-java/src/Imported/<Module>.ard` — **generated,
gitignored, overwritten on every run** — defining `progDecls`, `progTerm`,
`program` and the printing entry points `progJava` / `progJavaLong`, so from
there on an imported case is indistinguishable from a hand-written one. It
prints nothing on stdout, which is why a case chains it in front of its
extraction:

    JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast MatmulAst \
                   && extract-arend Imported.MatmulAst:progJava$JAVA_DEF_SUFFIX"

The grammar it reads is exactly the one `Serialize.ard` writes, read backwards,
so `peano-ast` (whose `prog.ast` came from `ExamplePrint:peanoSexpr`) is a
round-trip test of the two against each other — its generated `Prog.java` is
byte-identical to `peano`'s. `matmul-ast` instead uses the real file the `matmul`
case hands to Peregrine.

Two things worth knowing:

* **WORKAROUND: constructor application is un-curried on import.** Peregrine's build has
  `cstr_as_blocks = false`: a `tConstruct` always carries an *empty* argument
  list and its fields arrive as ordinary curried `tApp`s (`wrapTApp` in
  `Serialize.ard` does the same outbound). `ToJava.ard`'s `construct` clause
  needs the fields, and compiling the curried form yields Java that casts a
  `Rt.Data` to `Rt.Fn` and does not even compile. The importer therefore
  collects the fields back, using each constructor's declared `cstrNargs`, and
  *rejects* a partially applied constructor (which would need eta-expansion the
  generator cannot express).

  This is a workaround in a *test tool* for a gap in the compiler, not a
  property of the format: every real Rocq/Lean/Agda file hits the curried form
  on every constructor, so `compileExpr` should handle it itself (recognize an
  application spine headed by a `construct`, or eta-expand an under-applied
  one). Both need the constructor arities, i.e. `GlobalDeclarations` threaded
  into `compileExpr`, which currently discards even the `InductiveId`. Until
  that is done, an imported program is only correct because the importer
  re-saturated it. See `RESEARCH_AND_PLAN.md`.
* **Anything outside our λ□ subset is a loud failure**, not a mistranslation:
  `tVar`/`tEvar`/`tCoFix`/`tLazy`/`tForce`, non-`primInt` primitives and typed
  λ□ (`.tast`) exit non-zero with a reason on stderr, since `LBTerm` has no
  counterpart for them. That list is the point: it measures which fragment we
  actually cover.

The interface is deliberately language-agnostic (read an `.ast`, write Arend to
stdout, non-zero exit + stderr on unsupported input), overridable via
`AST_TO_AREND` and `PYTHON`, so the implementation can be replaced without
touching a single case. `--mode=literal` emits the same file as one escaped
single-line Arend string literal instead — Arend has no multi-line literals —
which is what an in-Arend deserializer would consume.

## Checking an exported program against Peregrine

A case that declares only the `java` backend never hands its `.ast` to
Peregrine, so nothing checks that the program we *export* is well-formed λ□.
The cheapest such check needs no driver and no attributes:

    peregrine ast box  cases/peano-ast/prog.ast -o /dev/null   # wellformedness only
    peregrine ast mut  cases/peano-ast/prog.ast -o /dev/null   # + CertiRocq's L1g

Worth running after touching an example, because our own generator is much more
permissive than `CheckWf.v`. The one failure this has already caught:

* **Global declarations are ordered dependents-first.** `check_wf_glob` checks
  each entry against only the *tail* of the list, so a declaration may
  reference only entries that come AFTER it. `ExamplePeano.ard` and
  `Example.ard` used the opposite ("declare before use") order, which made
  `add`'s inductive invisible and produced the misleading
  `Error while checking .add: Case not exhaustive`. Our own lookup scans from
  the head and is order-insensitive, so the Java backend never noticed. The
  invariant is now documented on `GlobalDeclarations` in `LambdaBox.ard`.

# Test harness

Takes a λ□ program defined in Arend (or a checked-in λ□ file), produces the target
code for each backend, compiles it, runs it, times every stage and prints the
program's output.

The run scripts themselves still assert nothing — every output is printed, with
the backends' outputs next to each other. Checking is a *separate* script:
`check-case.sh`/`check-all.sh` compare the outputs a run left behind against each
other and against the case's `EXPECTED` (for the upstream benchmarks, the value
Lean's own compiler produces), and `run-all.sh` ends by calling it. See "The
upstream benchmark corpus and differential checking".

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
    run-eval.sh         <case>  peregrine eval: run the program, no codegen
    run-timed.sh        <case> <backend> -- cmd...   time, print and tee output.txt
    run-case.sh         <case> [backend...]          one case, its declared backends
    run-all.sh          [case...]                    every case, then summary + check
    check-case.sh       <case> [backend...]  compare outputs to each other + EXPECTED
    check-all.sh        [case...]            check-case.sh over the corpus, one verdict
    bench.sh            <case> [variant...]          build once, run N times, compare
    run-ast-suite.sh    <name> <paths...>             external .ast corpus runner
    run-lean-benchmark-suite.sh [lean-repo]           close + run Lean benchmarks
    summary.sh          [case...]  timing table + every backend's output
    case-backends.sh    <case>  the case's BACKENDS, one per line
    case-note.sh        <case>  the case's NOTE (expected result)
    cases/<case>/case.sh  declarative case description (variables only)
    lean-ocaml-runtime/   Lean's own OCaml realizations of its axioms (verbatim
                          upstream copies) + the case.sh fragment sharing them
    lean-peano-drivers/   drivers for the axiom-free Lean cases, the only ones the
                          C backend and the evaluator accept
    work/               gitignored scratch: work/<case>/<backend>/...

## Usage

    test/run-all.sh                                         # everything + summary
    test/run-case.sh matmul                                 # one case, all its backends
    test/run-case.sh matmul java                            # one backend only
    test/build-c.sh matmul                                  # a single stage, by hand
    test/extract-arend.sh ExamplePrint:peanoJava            # print generated Java
    test/extract-arend.sh ExamplePrint:matMulSexpr prog.ast # write the λ□ s-expression
    test/import-ast.sh cases/peano-ast/prog.ast PeanoAst   # import an external λ□ file
    test/check-all.sh                                       # verdict on the last run
    test/run-case.sh lean-qsort && test/check-case.sh lean-qsort

## How artifacts are obtained

`lambox-to-java/src/ExamplePrint.ard` has one `\func` per artifact, each of the
form `putStrLn <text>`, so *typechecking* the definition prints it.
`extract-arend.sh` runs the CLI narrowed to a single `MODULE:DEF` and slices the
text between the CLI's `--- Typechecking ... ---` and `--- Done (NNms) ---`
lines, which replaces the old manual copy-paste into `lambox-to-java/out*/`.

### Binary caches (`.arc`)

The CLI is invoked *with* `--serialize`, so every dependency module —
`LambdaBox`, `ToJava`, `JavaPrint`, ... and any not-yet-cached arend-lib
module — is persisted as a `.arc` binary cache (`lambox-to-java/bin/`,
gitignored) and loaded instead of re-typechecked on the next run. A cache for
the *print module itself* would suppress the `putStrLn` we harvest, so
`extract-arend.sh` deletes the target module's `.arc` both before the run (a
stale one would silence it) and after (`--serialize` just wrote a fresh one).
Caches invalidate automatically when a source file changes (verified: editing
`ToJava.ard` re-typechecks it and regenerates its `.arc`); `-r/--recompile`
forces a from-source run if a cache is ever suspected stale.

This cut an extraction from ~36 s to ~21 s (~27 s since the 1.12 upgrade below).
The remaining ~20 s is a *fixed* per-JVM-start cost — resolving and
cache-loading the ~156-module arend-lib
import cone (JVM+prelude alone is ~1.2 s) — which `.arc` files cannot remove;
the target definition itself typechecks in ~100–250 ms. The CLI does accept
several `MODULE:DEF` positionals in one run, so batching all of a case's
extractions into a single JVM start would amortize that cost further (not
wired into the harness yet).

Note: arend-lib's own `bin/` caches are version-specific and have twice needed
repair — first two stale files (`Category.Topos*`), then *all* of them after the
1.12 upgrade (`36 loaded, 36 incomplete, 84 failed out of 156`, i.e. most of the
library silently re-typechecked on every run, pushing extraction to ~57 s). The
recipe is a **narrowed** serialize inside `~/.arend/libs/arend-lib`:

    cli-1.12.0-full.jar arend.yaml --serialize Data.Array Data.String Set

which rebuilds the whole import cone we use (afterwards: `157 loaded out of 157`,
extraction back to ~27 s). A whole-library `--serialize` must **not** be used: it
still fails on parse errors in `Category.Topos.Sheaf.Sub` and then aborts with a
`NullPointerException` before writing anything. If the `Cannot load binary cache`
warning reappears, redo the narrowed run.

### Arend 1.12

The project was migrated from Arend 1.11 to 1.12 (`lambox-to-java/arend.yaml`
declares `langVersion: 1.12`, `AREND_JAR` defaults to `cli-1.12.0-full.jar`),
because the installed arend-lib in `~/.arend/libs` is now 1.12 and an older CLI
rejects it outright ("Incompatible language version").

One source change was needed, and it is a *syntax* change rather than a library
one: **a qualified infix operator can no longer be applied in prefix form.**
`Data.Array.++ xs ys` used to mean `xs ++ ys`; under 1.12 only the first argument
is taken and the result is applied to the second as an *index*, so it fails with
`Expected type: Fin xs.len`. Array append is therefore imported under an alias,

    \import Data.Array (map, mkArray, Big, ++ \as \infixr 5 ++A)

and used infix (`xs ++A ys`) at the three sites in `ToJava.ard` (`appendStmts`,
`concatMembers`, `compileClass`). The alias is still needed instead of importing
`++` directly, for the original reason: it would shadow `Data.String`'s `++`.
The infix form of the qualified name (`xs Data.Array.++ ys`) also works, but the
alias keeps the call sites readable.

## Prerequisites

* A **development build** of Arend (`AREND_JAR`, e.g.
  `cli-1.12.0-full.jar`; it must match `arend.yaml`'s `langVersion: 1.12`). The
  library relies on the new `String` implementation, which is not released yet
  (expected in 1.13).
* Python 3 (`PYTHON`) for `tools/ast-to-arend`, needed only by the cases that
  import an external `.ast`; stdlib only, nothing to install.
* A JDK (`JAVA`, `JAVAC`); `JAVA_STACK=-Xss1g` is required, since evaluating a
  whole generated program during typechecking is stack-hungry.
  `JAVA_RUN_STACK=-Xss512m` is still passed when RUNNING a generated program, but
  it is no longer what makes deep recursion work — the generated program sizes its
  own stack now; see "Recursion depth" below.
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

## Recursion depth (a documented limitation)

λ□ `fix` compiles to **plain Java recursion**, and the recursive call is usually
*not* in tail position (building a list, `map`, `foldr`, the `deriv` tree walk),
so evaluation depth is bounded by the thread stack. This is a real difference from
the backends we compare against: `peregrine c` and the OCaml/Malfunction backend
are not bounded this way.

The generated `main` therefore does not evaluate the body itself. It hands it to
`Rt.runMain`, which runs *and prints* it on a thread it creates with an explicit
stack size (`Rt.STACK_BYTES`, default **1 GiB**, overridable at run time with
`-Dlambox.stack=<bytes>`), and turns an exception on that thread into a stack
trace plus a non-zero exit status — so a `StackOverflowError` can never look like
a successful run with no output:

    public static void main(String[] args){
      Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
        return __main();
      } });
    }

**Why not just pass `-Xss`.** `-Xss` sizes the threads the JVM creates, while the
*primordial* thread that runs `main` may take its stack from the OS (`ulimit -s`,
here 8 MB) — so the depth a program survived used to depend on how it happened to
be launched, and on the JVM/OS combination. Measured on this machine (JDK 26,
`ulimit -s` 8192, a probe with exactly the shape generated code produces: a
non-tail recursive call building an `Rt.Data` node on the way out, ~48 bytes of
stack per frame):

| where the body runs | flags | max depth |
|---|---|---:|
| primordial `main` | none | **6 559** |
| primordial `main` | `-Xss512m` | 11 182 642 |
| `Rt.runMain` thread | none (8 MB probe) | 172 592 |
| `Rt.runMain` thread | none (1 GiB default) | **22 367 452** |

So without flags the old entry point overflowed after ~6.5k nested calls; the
program now gets ~22 M by default, and the number is a property of the generated
program rather than of the harness. `JAVA_RUN_STACK=-Xss512m` is kept because it
also covers the printing thread and does no harm, but no case depends on it any
more (verified: `lean-map`, which used to need it, runs with plain `java -cp …
Prog`).

**This bounds the depth, it does not remove the bound.** Making non-tail `fix`
stack-independent needs CPS or heap-allocated frames — *not* a trampoline, which
only flattens tail calls and so would not help the recursion we actually see, at
the price of a thunk check on every call (dispatch is already 30–85% of samples in
these workloads) and a much weaker correspondence between `JavaAst` and λ□
evaluation. Deliberately deferred; the trigger to revisit is a benchmark we did
not write failing on stack at 1 GiB, or the verification track reaching an
evaluation relation that makes a CPS transform provable.

## Integer representation of the Java backend

`JAVA_INT` picks how λ□ primitive ints are represented in the generated Java
(the `JavaTarget` record in `ToJava.ard`); both variants use the same
`Rt.java`:

    test/run-case.sh matmul java                 # JAVA_INT=long (default)
    JAVA_INT=bigint test/run-case.sh matmul java

* `long` — **the default.** `Long.valueOf(..L)` literals and `Rt.PRIM_*_LONG`,
  i.e. Java's built-in 64-bit integers: wraps at 2^64, signed, and much faster
  (matmul: ~1.1s vs ~8.1s run time).
* `bigint` — `java.math.BigInteger` literals and `Rt.PRIM_*_INT`: unbounded,
  never overflows, but boxed arithmetic and no wraparound.

`long` is the default because it is the *closer* approximation of the source
semantics (below): a fixed-width integer with wraparound has the right shape and
only the width is off by a bit, whereas BigInteger's unboundedness is a
different kind of thing altogether — not a more conservative choice. `bigint` is
kept for the occasional debugging run and is **no longer measured**: it was 6x
slower on `matmul-bench` and 5% slower on `lean-deriv`, so it either loses or
says nothing.

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
`config.sh` turns `JAVA_INT` into that suffix (`""` for `long`, `"BigInteger"`
for `bigint`), so the switch applies to every case without touching any backend
script. The unsuffixed name is the default one throughout — `ToJava.ard`'s
`compileProgram` fixes `targetLong`, and `compileProgramWith targetBigInteger`
is what the `*JavaBigInteger` definitions call. Both variants build into the same
`work/<case>/java` dir, i.e. the last run wins.

## Cases

A case is a directory under `cases/` with a `case.sh` holding *variables only*,
plus any driver files it needs (`main.c` for C; `matmul_main.ml`,
`prim_int63.ml/.mli` and the hand-written `matmul.mli` for OCaml — `malfunction
cmx` emits no `.cmi`, so the interface is compiled separately).

`matmul-bench` and `lean-matmul-peano` are the benchmark cases; see "Comparing
the backends" below. `lean-deriv` is an *upstream* program (see "An upstream
benchmark: lean-deriv"), and by far the slowest case — ~190 s to generate and
~70 s to run — so `run-all.sh` now takes several minutes longer.

`BACKENDS` lists the backends the case supports, and a case declares only what a
backend can actually consume:

* **No C** unless the program is axiom-free — `peregrine c` refuses outright
  ("Axioms found, use Extract Constant to realize them in C"), and no upstream C
  realizations of Lean's primitives exist. That leaves the `*-peano` cases and
  `matmul`/`matmul-bench` (whose four prim-int axioms *are* realized, on the
  CertiRocq runtime).
* **No C or OCaml for a program returning constructor data** (`peano`,
  `peano-ast`, `example`, `lean-map`): both drivers print one primitive int.
  Those four instead declare `eval`, Peregrine's evaluator, where it is free (a
  checked-in `.ast`, no attributes) — not text-comparable, so `check-case.sh`
  skips it, but it is an independent reference semantics for the same file.
* `matmul-ast` stays java-only on purpose: `matmul-bench` already runs C and
  OCaml on the byte-identical program, so a third copy of the drivers would add
  no evidence.

`matmul-ast`, `peano-ast`, `lean-map`, and `lean-matmul` hold a `prog.ast`
instead of pointing at a hand-written Arend program (see "Importing external λ□
programs").

Seven cases are *upstream* Lean 4 code-generator benchmarks, none of them written
by us — see "The upstream benchmark corpus" below. They are also where the
`EXPECTED` variable and `check-case.sh` come from: a case may declare the value
Lean itself computes, and the check compares every backend against it and against
every other backend.

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
`import-ast.sh` first runs Peregrine's verified `ast box` normalization, then
`test/tools/ast-to-arend` (Python 3, stdlib only) structurally translates the
result into Arend source:

    test/import-ast.sh cases/matmul-ast/prog.ast MatmulAst
    test/extract-arend.sh Imported.MatmulAst:progJava

The importer writes `lambox-to-java/src/Imported/<Module>.ard` — **generated,
gitignored, overwritten on every run** — defining `progDecls`, `progTerm`,
`program` and the printing entry points `progJava` / `progJavaBigInteger`, so from
there on an imported case is indistinguishable from a hand-written one. It
prints nothing on stdout, which is why a case chains it in front of its
extraction:

    JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast MatmulAst \
                   && extract-arend Imported.MatmulAst:progJava$JAVA_DEF_SUFFIX"

The grammar it reads is the constructor-block form of the one `Serialize.ard`
writes. `peano-ast` starts from `ExamplePrint:peanoSexpr`, passes through
Peregrine's normalization, and must still generate Java byte-identical to the
hand-written `peano` case. `matmul-ast` instead starts from the real file the
`matmul` case hands to Peregrine.

Two things worth knowing:

* **Constructor normalization belongs to Peregrine.** External `.ast` files
  use curried constructor applications (`cstr_as_blocks = false`), whereas
  `LambdaBox.ard` and `ToJava.ard` consume saturated constructor blocks.
  `import-ast.sh` bridges these two pipeline stages with `peregrine ast box`,
  which runs MetaRocq's verified constructors-as-blocks transformation. The
  Python importer no longer reconstructs spines: it only checks every block
  against its declared `cstrNargs` and rejects raw or malformed input loudly.
* **Anything outside our λ□ subset is a loud failure**, not a mistranslation:
  `tVar`/`tEvar`/`tCoFix`/`tLazy`/`tForce`, non-`primInt` primitives and typed
  λ□ (`.tast`) exit non-zero with a reason on stderr, since `LBTerm` has no
  counterpart for them. That list is the point: it measures which fragment we
  actually cover.

The translator interface is deliberately language-agnostic (read a boxed
`.ast`, write Arend to stdout, non-zero exit + stderr on unsupported input),
overridable via `AST_TO_AREND` and `PYTHON`. `--mode=literal` emits the same
file as one escaped single-line Arend string literal instead — Arend has no
multi-line literals — which is what an in-Arend deserializer would consume.

### Regenerating the Lean cases

`lean-matmul` is an independent frontend test: `prog.lean` defines custom
lists, constructs two 130x130 all-ones matrices, multiplies them, and sums every
result cell. Its checked-in `prog.ast` is the otherwise unmodified output of
lean-to-lambdabox. With that project available at `~/lean-to-lambdabox`,
regenerate it from the project root with:

    cd ~/lean-to-lambdabox
    ~/.elan/bin/lake env lean \
      ~/lambox-to-java-in-arend/test/cases/lean-matmul/prog.lean
    cp prog.ast \
      ~/lambox-to-java-in-arend/test/cases/lean-matmul/prog.ast

The frontend emits machine arithmetic as the qualified axioms `Nat.add`,
`Nat.mul`, `Nat.sub`, and `Nat.beq`. The Java axiom table realizes those names
with the same runtime operations as the hand-written `prim_*_int` axioms; its
lookup includes the module path so an unrelated `Foo.add` cannot match.

`lean-map` is copied from Peregrine's official
`test/lean/src/Map.lean` at the revision recorded in its `case.sh`; only the
`#erase` output path is adapted. It doubles the Peano list `[1, 3, 5]`, testing
higher-order application, recursive functions, pattern matching, and nested
constructor results. Regenerate its artifact with:

    cd ~/lean-to-lambdabox
    ~/.elan/bin/lake env lean \
      ~/lambox-to-java-in-arend/test/cases/lean-map/prog.lean
    cp prog.ast \
      ~/lambox-to-java-in-arend/test/cases/lean-map/prog.ast

### Running external suites

`run-ast-suite.sh` runs every untyped `.ast` below one or more paths through
the complete `ast box` → Arend import → Java compile → JVM pipeline. It keeps
going after a failure and writes a tab-separated status and output report to
`test/work/suites/<name>/results.tsv`; each program's full pipeline log stays
beside it. For example, after generating Peregrine's Rocq and Lean fixtures:

    (cd ~/peregrine-tool/test/rocq && \
      opam exec --switch peregrine -- make theory)
    (cd ~/peregrine-tool/test/lean && ~/.elan/bin/lake build)
    test/run-ast-suite.sh peregrine \
      ~/peregrine-tool/test/rocq/extraction \
      ~/peregrine-tool/test/lean/extraction

The runner exits non-zero if any artifact fails, after finishing and writing the
complete report. `SUITE_RUN_TIMEOUT` (default 300 s) bounds the JVM run of one
program; exceeding it is recorded as `timeout` and counted separately, an
ACCEPTED outcome — the program compiled and started, so it says nothing about
the backend. Only import, compile and runtime errors fail the suite.

Each row also carries the wall-clock seconds of `import_s` (Peregrine `ast box`
plus the Python reader), `extract_s` (Arend generating `Prog.java`), `javac_s`
and `run_s`, so "generating the program" and "running it" stay separable. Note
`extract_s` includes the Arend CLI's constant `arend-lib` loading of ~27 s.

Raw `.tast` files are deliberately ignored because `LambdaBox.ard` currently
models only untyped λ□. Peregrine's `_typed.ast` fixtures do work: `ast box`
erases their type annotations while running the verified normalization passes.

The runner executes the entry term embedded in each artifact. The companion
script generates closed wrappers for all parameterized lean-to-lambdabox
benchmarks and uses input `10` by default, keeping this a coverage suite rather
than a long performance run:

    test/run-lean-benchmark-suite.sh ~/lean-to-lambdabox
    LEAN_BENCH_INPUT=20 test/run-lean-benchmark-suite.sh

The generated wrappers and `.ast` files stay under `test/work/suites/`.

Status (2026-08-12, Peregrine `247d4956` and lean-to-lambdabox `58701f8b`):

- all 14 artifacts generated by Peregrine's official Rocq and Lean tests pass,
  including 6 typed Rocq inputs and mutual/odd-even recursion; corresponding
  Lean and Rocq `Demo`/`Map` programs produce identical Java output;
- **24 of the 26** lean-to-lambdabox manifest benchmarks pass with input `10`
  (9 before the axioms below were realized), 0 fail, 2 time out;
- `demo1`/`demo1_tc` are the two timeouts, and NOT for lack of tail calls as the
  first run suggested: they return an 8000-element list, and `Rt.Data`'s
  human-readable format indents by nesting depth, so printing the result alone
  is ~192 MB of text. The stack overflow disappeared with `JAVA_RUN_STACK`.

Timings from that run (seconds): generating a program takes 29–110 s, of which
~27 s is `arend-lib` loading, `javac` takes 1–3 s, and the programs themselves
run in 0.1–1.5 s. `deriv` is the outlier at 300 s to generate and 98 s to run.
So the pipeline's cost is code generation, not the generated code.

The results are checked against Lean, not just against "it printed something":
`#eval`ing each benchmark at the same input inside Lean gives a reference value,
and all 20 numeric results agree. To reproduce, put one `#eval <benchmark> 10`
per line into a file importing `FromLeanCommon` and elaborate it against the
built benchmark library:

    cd ~/lean-to-lambdabox
    LEAN_PATH=$PWD/benchmarks/.lake/build/lib/lean \
      ~/.elan/bin/lake env lean <file>.lean

(`demo0`/`demo1`/`demo2`/`unit` return lists or `Unit`, which the `Rt.Data`
format spells differently from Lean, so only the numeric ones are compared.)
That comparison is what caught the one real
bug of the run — `const_fold` returned 2048 instead of 4772, because Lean's
`Nat.sub` truncates at zero while the runtime's shared subtraction went
negative, silently defeating an `if v = 0` guard. `Rt.NAT_SUB_*` is now separate
from `PRIM_SUB_*` (which realizes Peregrine's wrapping int63 `prim_sub_int`).

Two earlier findings from the same corpus:

- illegal Java names from Lean identifiers containing `?` and `'`;
  `StringUtil.javaIdentPart` now escapes every non-identifier UTF-8 byte without
  collisions at the `mangleKername` boundary;
- the axioms the benchmarks need are now realized in `runtime/Rt.java` and
  listed in `ToJava.ard`'s `javaAxioms`: `Nat.div/mod/pow/ble/blt` and
  `decEq/decLe/decLt`, the machine-`Int` operations, Lean's `Array` (as a
  persistent `Object[]` — it must copy, since λ□ has lost the linearity
  information that lets Lean mutate in place), and `Eq.rec`/`Eq.ndrec`.

An axiom that is not realized stays an explicit throwing method: an unsupported
operation must fail loudly rather than be papered over in the importer.

## Comparing the backends (bench.sh)

`bench.sh <case> [variant...]` builds each variant **once** and then runs it
`BENCH_REPEATS` times (default 3), reporting the fastest and the median run:

    MATMUL_SIZE=200 test/bench.sh matmul-bench
    test/bench.sh lean-matmul-peano
    test/bench.sh matmul-bench c java             # only these two variants

A *variant* is a backend; with no variants given, the case's `BACKENDS` are used
as they are. `java` means the default `long` representation (`java-long` is an
explicit spelling of the same thing), and `java-bigint` is the BigInteger one —
not measured any more, but still available for a one-off. Historical rows in the
tables below predate this and label the two as `java-long` and `java`
(BigInteger). Rows are appended to `work/bench/<case>/results.tsv`, so runs at
several sizes accumulate; the per-stage breakdown of a build stays in
`work/timings.tsv`.

Separating build from run is the whole point: in this pipeline they differ by
two orders of magnitude, and only the run compares the *generated code*.

### The two benchmark cases

* `matmul-bench` — the `matmul` program (63-bit prim ints), with `MATMUL_SIZE`
  substituting the size literal in a checked-in copy of the `.ast`. Unlike
  `matmul`, **every** backend consumes that same file (`matmul` feeds Java from a
  hand-written Arend term), and its attribute files are checked in rather than
  extracted, since each extraction costs ~21 s of Arend startup and would
  dominate the measurement.
* `lean-matmul-peano` — the same workload over **unary** naturals, extracted
  from Lean with `config { nat := .peano, extern := .preferLogical }`, therefore
  axiom-free. It exists so `peregrine eval` can be included, and returns a
  `Bool` (`Nat.beq sum (size^3)`) rather than the sum: a unary 8000 is an
  8000-deep term, and every backend here indents a printed value by nesting
  depth, so printing it would cost more than computing it.

### Measurements (2026-08-13, `matmul-bench`, seconds, median of 3)

| size | c | ocaml | java-long | java (BigInteger) |
|---|---:|---:|---:|---:|
| 130 | 0.54 | 1.03 | 1.57 | 9.56 |
| 200 | 3.12 | 5.89 | 8.99 | 52.66 |
| 260 | 11.35 | 16.50 | 24.35 | (not run) |

and the corresponding build (code generation + compilation):

| variant | build |
|---|---:|
| c | 0.5–1.1 s (`peregrine c` ~0.05 s + `gcc -O2`) |
| ocaml | 0.3 s (`peregrine ocaml` ~0.01 s + `malfunction`/`ocamlopt`) |
| java / java-long | 31–37 s, of which ~30 s is Arend (`javac` 1–2 s) |

`lean-matmul-peano` at size 20, all five variants agreeing on `Bool.true`:

| variant | run | build |
|---|---:|---:|
| c | 0.01 s | 1.05 s |
| ocaml | 0.01 s | 0.31 s |
| java-long | 0.30 s | 36.8 s |
| java | 0.14 s | 34.7 s |
| eval | 5.65 s | none |

At this size the Java rows are dominated by JVM startup (~0.1 s, and the
`java-long` run varies 0.15–0.32 s because of it), so read them as an upper
bound rather than as compute time; the `matmul-bench` table above is the one to
compare throughput on.

What this says:

* **On this workload our generated Java is in the same league as the verified
  backends**: `java-long` is 2.1–2.9x the C backend and 1.4–1.5x the OCaml one,
  and the ratios are stable across sizes — so nothing in the generated shape
  degrades as the workload grows. All four scale alike (~x16 from 130 to 260,
  i.e. quartic, which is the algorithm: `lookupCol`/`nth` walk lists). Do not
  generalize the ratio: across the whole corpus java/ocaml ranges from 1.06x to
  50x (see "Timings: the whole corpus"), and this workload is at the good end.
* **BigInteger costs ~6x** over `long` on this integer-heavy program. That is the
  price of the current default; see the int63 discussion above.
* **Code generation, not generated code, is our cost**: ~30 s of Arend against
  Peregrine's ~0.3–1 s for a whole backend. Most of it is the CLI's constant
  `arend-lib` loading, and it is *per program*, so it dominates any corpus run.
* **`peregrine eval` is an oracle, not a backend**: ~40x our Java and ~700x the
  C backend on the same program — and that is at a size all three compiled
  backends finish in milliseconds. It also cannot run most of our cases at all
  (below).

### What the evaluator can and cannot do

`run-eval.sh` adds `eval` as a backend: `peregrine eval` runs the program
instead of compiling it, so it is the reference value from Peregrine's own
pipeline. Two limits, both worth knowing before trusting it:

* **It cannot run a program with axioms.** `--attributes` remaps an axiom onto a
  *native* C/OCaml symbol, which the evaluator has no implementation for, so the
  `matmul` family fails with `Eprim: prim not found` (ANF evaluator) or
  `wcbvEval;TConst;ecTyp: .prim_add_int` (`--anf false`). Hence the axiom-free
  `lean-matmul-peano` case.
* **`--fuel` is a Rocq unary `nat` allocated up front**, ~16 bytes per unit: on a
  trivial program, fuel 1e6/1e7/1e8/1e9 costs 0.03/0.45/4.6/222 s and up to
  1.6 GB *before evaluation starts*. `EVAL_FUEL` defaults to 1e7 for that
  reason. Worse, **exhausted fuel is not an error**: the evaluator prints the
  residual ANF program, which looks like a result. Check the output shape
  (`constr ...`) before believing an eval answer.

Peano scaling of the evaluator, for choosing a size: 10 → 1.5 s, 20 → 5.8 s,
30 → 27 s (~1.2 GB).

### The other Peregrine backends

Not comparable here, for two different reasons:

* `peregrine rust` and `peregrine elm` reject our input outright — *"Rust/Elm
  extraction requires typed lambda box input"* — and `LambdaBox.ard` models
  untyped λ□;
* `peregrine wasm` and `peregrine cakeml` do compile `lean-matmul-peano`
  successfully, but no runtime for either is installed on this machine (no
  `node`/`deno`, no `cake`), so they cannot be run. CakeML's Peregrine pipeline
  also still has `Admitted` obligations and an observational relation of `True`,
  so it would be a performance data point only.

## An upstream benchmark: lean-deriv

`lean-deriv` is the first case that is **not ours**: `deriv.lean` is a verbatim
copy of lean-to-lambdabox's `benchmarks/FromLeanCommon/deriv.lean` (itself from
Lean 4's own code-generator benchmarks, revision 58701f8) and `prog.ast` is its
unmodified λ□ output; only `prog.lean` is ours, and it merely closes the program
over the input (10) the benchmark manifest uses. It differentiates `x^x` nested
ten times and counts the nodes of the result: `40230090`.

It is worth pinning as a case, rather than leaving it inside
`run-lean-benchmark-suite.sh`, for two reasons: it is the only Lean-corpus
program that costs *minutes*, and it is the first one for which a second backend
could be made to run — so it is the first cross-backend measurement on a program
nobody here wrote.

### Making the OCaml backend run it

`deriv` leaves 13 Lean primitives as axioms, and each backend resolves them
differently:

* **our Java** realizes them in the runtime (`javaAxioms` in `ToJava.ard` →
  `runtime/Rt.java`), so it needs no attributes at all;
* **Peregrine's OCaml backend** compiles an unrealized axiom `.Nat.add` to
  `(global $Axioms $def__Nat_add)` — no attribute entry either, the module name
  `Axioms` is a convention. The realizations are lean-to-lambdabox's own
  (`nat.ml`, `int.ml`, `decidable.ml`, `eq.ml`, copied verbatim; our `axioms.ml`
  is trimmed to those three includes since this program uses no Lean `Array`).
  They are Zarith-based, hence `OCAMLOPT="ocamlfind ocamlopt"` plus
  `OCAML_FLAGS`/`OCAML_LINK_FLAGS` in `case.sh` — `build-ocaml.sh` word-splits
  the compiler and adds the link flags only when linking;
* **`c` is impossible today**: `peregrine c` rejects the program outright
  (*"Axioms found, use Extract Constant to realize them in C"*) and no C
  realizations exist upstream — they would have to allocate (`Decidable` is a
  constructor) through the CertiRocq GC. Likewise `eval` cannot run it.

### Measurements (2026-08-13, median of 2)

| variant | run | build | peak memory |
|---|---:|---:|---:|
| ocaml | 6.8 s | 1.1 s | 711 MB |
| java-long | 69.5 s | 180.7 s | ~3.6 GB heap |
| java (BigInteger) | 73.2 s | 195.3 s | ~3.6 GB heap |

Both backends print `40230090`, which is also what Lean's own `#eval` gives.

This is a **10x gap**, against 1.4–1.5x on `matmul-bench` — and the interesting
part is what it is *not*:

* **not the integer representation.** `java-long` is only 5% faster than
  BigInteger here, where on `matmul-bench` it was 6x. So this program's cost is
  not arithmetic.
* **not lost sharing.** Our backend compiles a λ□ constant to a *method*, so
  every reference re-evaluates its body, whereas Malfunction gets a top-level
  `let` evaluated once. Memoizing all 55 constant methods in the generated
  `Prog.java` by hand changed nothing measurable — the JIT already handles it.
* **partly the literals.** `intLit` emits `new java.math.BigInteger("0")`, i.e.
  a decimal string re-parsed at every *use*, inside the hottest loop; replacing
  those by `BigInteger.valueOf(0L)` by hand gave 73 s → 65 s (~10%, matching
  BigInteger's ~10% share of the profile). A cheap, real improvement — it needs a
  guard for literals that do not fit a `long`, since `bigint` mode exists to be
  unbounded.
* **mostly the curried calls.** JFR execution sampling puts **84%** of samples in
  the generated `Prog$…$1.apply` methods. Every λ□ application is one
  `Rt.Fn.apply`, so an *n*-argument call allocates *n*-1 intermediate closures
  and performs *n* virtual calls; Malfunction instead has n-ary `Mlambda`/`Mapply`
  and OCaml compiles a saturated call directly. `matmul` hides this (a tight
  arithmetic loop over lists), `deriv` does not (higher-order, allocation-heavy,
  many multi-argument functions).

So `deriv` turns the previously-cosmetic uncurrying question into a measured one:
arity-specialized `Rt.Fn2`/`Fn3` plus compiling a saturated application spine to
a single call is the change with the largest expected payoff, and it needs
neither closure conversion nor a different input IR.

### Peregrine's optional passes do not help (`PEREGRINE_BOX_FLAGS`)

Before writing that pass, the free experiment: Peregrine's *optional* middle-end
passes are flags on `peregrine ast box`, which `import-ast.sh` already runs, so
`PEREGRINE_BOX_FLAGS` (see `config.sh`) enables them for any imported case
without a generator change:

    PEREGRINE_BOX_FLAGS="--betared=true --unboxing=true" ./run-case.sh lean-deriv java

On `lean-deriv` this is a no-op in practice — output stays `40230090` and:

| | AST bytes | `tCase` | `tApp` | closures in `Prog.java` | `.apply(` sites | run (best of 3) |
|---|---:|---:|---:|---:|---:|---:|
| default | 131739 | 102 | 2064 | 181 | 400 | 82.0 s |
| `--betared --unboxing` | 130497 | 90 | 2065 | 180 | 399 | 78.5 s |

The 4% is inside the noise — the *same* class file measured 82–205 s across three
runs on this machine, so treat only best-of-N as meaningful. `--dearg-consts`/
`--dearg-ctors` produce byte-identical output: dearging needs a typed AST and our
imported `.ast` files are `Untyped`.

The reason is structural: `betared` fires only on syntactic `(λx. e) a` redexes
and `unboxing` removes *allocation* (hence `tCase`/`tConstruct` drop while `tApp`
does not) — neither touches the per-argument application protocol, which is where
the 84% is. The flag stays because it makes "input or backend?" a one-line
experiment, and it becomes useful the day we can import λ□^T.

### Spine flattening through a generic `Rt.app` loop makes things WORSE

The next experiment on the list — flatten the left-nested binary spine
`((f a) b) c` at compile time (Malfunction's `Mapply_u`) and emit one
`Rt.app(f, new Object[]{a, b, c})` whose runtime loop does the same unary
`apply` calls — was implemented (a `compileApp` spine collector mutual with
`compileExpr`, ~25 lines, 1-argument spines unchanged), measured, and
**reverted**:

| run (quiet machine) | before | flattened |
|---|---:|---:|
| `matmul` | 2.0 s | 10–16 s (**~6x worse**) |
| `lean-deriv` | 61–63 s | 94–127 s (**~1.5x worse**) |

Outputs stayed correct (`2197000` / `40230090`; `lean-deriv` had 333 of 400
call sites flattened). The reason it regresses is the same JVM mechanism that
made the curried chains bearable: a nested
`((Fn)((Fn)PRIM_ADD_LONG).apply(a)).apply(b)` is a chain of *separate call
sites*, each with its own (often mono/bimorphic) inline cache, so the JIT
inlines through them and escape analysis deletes the intermediate closure.
`Rt.app`'s loop is ONE call site shared by every flattened application in the
program — maximally megamorphic, never inlined — plus an `Object[]` allocation
per call that can no longer be scalarized.

Conclusion: call-site flattening only pays if it lands on an **arity-aware
callee** — `Rt.Fn2`/`Fn3` with real `apply(Object, Object)` entry points
generated for 2-/3-argument lambdas, so the flattened call is a direct
interface call with register-passed arguments, not a generic loop. That
(callee side + this same spine collector) is the actual next step; the array
fallback should exist only for arity > N and partial application.

### Arity-aware callees (`Rt.Fn2`/`Fn3` + `Rt.app2`/`app3`) — REVERTED, see below

(Historical. This was implemented, measured as described here, and then reverted
together with the next section — see "The three-part performance change was
reverted". The code is on branch `inline-data-and-arity-calls`.)

The callee-side change above is now in: `ToJava.ard` compiles a 2-/3-deep
lambda nest to ONE anonymous class implementing `Rt.Fn2`/`Rt.Fn3`, whose real
entry point is `apply(Object, Object[, Object])` — arguments in registers, no
intermediate closure for a saturated call. A `default` unary `apply` on the
interfaces provides partial application, so an Fn2/Fn3 is still an ordinary
curried `Fn` to any caller that doesn't know better. The same spine collector
that regressed with the generic loop now emits `Rt.app2(f, a, b)` /
`Rt.app3(f, a, b, c)` — a static dispatcher that does one `instanceof` and one
direct interface call when arities match, and falls back to the curried
protocol (partial/over-application, unknown callees) otherwise; spines longer
than 3 are chunked (`app3` then continue), matching the generator's Fn3-then-
rest compilation of deeper nests. 1-argument spines and single lambdas are
byte-for-byte unchanged. All `Bin`-based binary axioms (`PRIM_*`, `Nat.*`,
`Int.*`) implement `Fn2`, so `Rt.app2(PRIM_ADD_LONG, a, b)` is one call.

Measured (same machine, best of 3, outputs correct):

| run | curried baseline | arity-aware |
|---|---:|---:|
| `matmul` | 2.0 s | 2.0 s (parity) |
| `lean-deriv` | 61–63 s | **40.6 s (~1.5x faster)** |

`lean-deriv`'s generated code: 333 call sites became `app2`/`app3`, closures
split 54 `Fn2`/`Fn3` + 50 `Fn` (was 181 `Fn`), curried `.apply` sites 400 → 208.
Unlike the generic `Rt.app` loop, this does not regress `matmul`: the
arithmetic-heavy sites hit `Bin.apply(x, y)` directly instead of allocating an
intermediate closure, and the fallback path inside `app2`/`app3` is the same
chain the JIT was already inlining.

### Inline constructor fields and chunked axioms — REVERTED, see below

(Historical, as above. Note in particular that the "none" baselines in this
section predate `JAVA_RUN_FLAGS`, which alone accounts for most of the famous
5–7x; the honest corpus-wide numbers are in the next section.)

After the arity work, JFR (`settings=profile`) said the protocol was no longer
the bottleneck (~13% of samples, was 84%): the cost was **allocation** — 31.6 GB
in 45 s, ~700 MB/s, with GC pauses summing to only ~1 s. The top items were
9.2 GB of `Object[]` (constructor fields), 3.3 GB of `Fn2`'s partial-application
wrapper, 1.9+ GB inside `Rt.curry`, and a 1.58 GB live set for the result tree.
Two changes address that, both measured on `lean-deriv` (best of 3, output
`40230090` throughout):

| run | arity-aware baseline | inline `Data` only | inline `Data` + chunked axioms |
|---|---:|---:|---:|
| `lean-deriv` | 40.6 s | 12.3–16.1 s | **8.6–9.1 s** |
| `matmul` | 2.0 s | | 2.0 s (parity) |

(The middle column was produced by recompiling the *same* `Prog.java` against a
`Rt.java` with the axiom chunking reverted, so it isolates the two changes.)

**These three optimizations are synergistic, and none of them stands alone.**
That was measured properly afterwards, by *regenerating* `lean-deriv` and
`matmul` from a tree containing only the inline-`Data` change (no `Fn2`/`Fn3`,
no spine flattening, no axiom chunking) — as opposed to patching a `Prog.java`
that had been generated *with* the arity work, which is what the column above
and an earlier ablation did:

| configuration (regenerated, best of 3, same machine) | `lean-deriv` | `matmul` |
|---|---:|---:|
| none (`HEAD` before this work) | 50.7–55.5 s | **1.5 s** |
| inline `Data` only | 41.1–43.2 s (1.2x) | 2.3–2.4 s (**1.6x SLOWER**) |
| all three | **6.7–10.1 s** (5–7x) | 1.7–2.0 s |

So inline `Data` on its own buys only ~1.2x on `lean-deriv` and *costs* 1.6x on
`matmul` (a six-field object with `arity` and three possibly-null slots is
bigger than a two-field one, and `matmul`'s cons cells are built far more often
than they are read). It pays only once the arity-aware calling protocol stops
the allocation of intermediate closures — which is why the three changes belong
together and are treated as one unit. The earlier per-optimization ablation
numbers ("inline `Data` alone captures 75% of the win") were an artifact of
patching generated code and are wrong.

1. **`Rt.Data` carries its first three fields inline** (`tag`, `arity`, `f0`,
   `f1`, `f2`, `rest`), instead of `tag` + one `Object[]`. That is ONE allocation
   per constructor value rather than two (~40 B instead of ~56 B; OCaml's block
   is 24 B), and every field read is a `getfield` at a constant offset rather
   than a dependent array load with a bounds check. `ToJava.ard` emits
   `new Rt.Data(tag, a, b)` for arities 0–3 and `Rt.data(tag, new Object[]{…})`
   beyond them, and `dataField` resolves each statically-known index to
   `f0`/`f1`/`f2`/`rest[i-3]` — so `Rt.Data.field(int)` is used only by
   `toString`. On top of the arity work this is the biggest single step
   (40 s → ~13 s); on its own it is worth almost nothing (see the table above).
2. **High-arity axioms collect arguments in chunks of three.** `Rt.curry`'s
   collector now implements `Fn3`, so a flattened `Rt.app3` call site fills it
   three arguments at a time — one array and one closure per chunk instead of per
   argument — with over-application handled explicitly (a chunk may overshoot the
   arity). `EQ_REC` (arity 6, all but one argument erased) is hand-realized as
   `Fn3`-returning-`Fn3`, so a rewrite costs two interface calls and no array at
   all. And `Rt.app2` builds a genuine one-argument closure when handed an `Fn3`,
   instead of going through two default unary `apply`s. Together: ~1.4x on top of
   the `Data` change.

With this, `lean-deriv` is **8.6–9.1 s against Peregrine's OCaml backend at
7.0 s on the same machine — 1.25–1.3x**, where this case started at 10x.

### The three-part performance change was reverted (2026-08-17)

The two sections above — inline `Rt.Data` fields, `Fn2`/`Fn3` + spine
flattening, chunked axioms, committed as one unit in `05eabe4` — are **no longer
on `main`**. They are preserved on branch `inline-data-and-arity-calls`
(pushed), and `main` is back to one calling protocol (`Rt.Fn.apply(Object)`) and
one value representation (`Data(tag, Object[] fields)`), i.e. ~260 fewer lines
of generator and hand-written runtime Java.

The decision was made after measuring the **whole** 17-case corpus in both
configurations, with every case *regenerated* (not patched) and run with the
harness's own flags. Two of the numbers we had been quoting turned out to be
artifacts, and both flattered the optimizations:

* seven builds under `test/work/` were stale leftovers from the parked
  `known-arity-and-sinking` branch, so "full" timings taken from them measured a
  *different* patch;
* the famous "`lean-deriv`: 50–55 s without the optimizations" was measured
  before `JAVA_RUN_FLAGS=-XX:-DontCompileHugeMethods` existed. With the flag the
  unoptimized build runs in 13–17 s, so most of that 5–7x was the 8000-bytecode
  JIT cliff, not the optimizations.

Run time (ms, best of 3–5, all outputs correct in both configurations):

| case | optimized | simple | optimized is |
|---|---:|---:|---|
| `lean-binarytrees` | **376** | 1311 | 3.5x faster |
| `lean-binarytrees-peano` | **97** | 299 | 3.1x faster |
| `lean-rbmap-mono` | **198** | 383 | 1.9x faster |
| `lean-unionfind` | **415** | 604 | 1.5x faster |
| `lean-qsort` | **570** | 793 | 1.4x faster |
| `lean-matmul-peano` | **65** | 84 | 1.3x faster |
| `lean-deriv` | 10084–14905 | 13386–17174 | ~1.15x, inside noise |
| `lean-const-fold` | 10525–14170 | 10912–15357 | wash |
| `lean-const-fold-peano` | 70 | 74 | wash |
| `lean-matmul` | 3702 | **3280** | 1.1x *slower* |
| `matmul-ast` | 1773 | **1303** | 1.4x *slower* |
| `matmul` | 1906 | **1287** | 1.5x *slower* |
| `peano`, `peano-ast`, `example`, `lean-map` | 28–29 | 25–29 | JVM startup |

Generation time, same warm `.arc` caches, `extract-arend` stage only — the
number that actually decided it, because the generator is the part of the
development loop one waits for:

| case | optimized | simple | optimized is |
|---|---:|---:|---|
| `lean-qsort` | **964 s** | **44 s** | 22x slower |
| `lean-unionfind` | 582 s | 63 s | 9x slower |
| `lean-binarytrees` | 94 s | 32 s | 2.9x slower |
| `lean-deriv` | 362 s | 189 s | 1.9x slower |
| `lean-const-fold` | 71 s | 38 s | 1.9x slower |
| `lean-rbmap-mono` | 82 s | 43 s | 1.9x slower |
| small cases | 23–31 s | 22–27 s | fixed Arend startup |

So the change cost 2–22x in the generator to save 0–3.5x in the generated
program, and *lost* 1.4–1.5x on the matmul family. Regenerating the corpus is
~50 min without it and ~5 h with it.

The pattern is consistent: the win is confined to programs whose cost is
allocating many short-lived constructor nodes (inline `Data` removes one object
per node); where the cost is boxed arithmetic in a tight loop the arity
machinery is a net loss (`Rt.app2`/`app3` is one shared megamorphic site
replacing per-site mono/bimorphic `.apply` chains that the JIT inlined
through); and where the C2 `unloaded`-uncommon-trap pathology dominates
(`lean-const-fold`) neither configuration matters.

The other reason to revert is correctness. The arity machinery is a second,
implicit protocol that has to agree between three places `javac` cannot check —
the generator's chunking (`applySpine`), the runtime dispatchers
(`app2`/`app3`/`Fn2`/`Fn3`), and every hand-written axiom (`curry`, `EQ_REC`,
`Bin`). That disagreement already produced the corpus' only silent wrong answer
in our own code (`ef2751a`). The simple protocol has one rule.

What was **kept**, because none of it is a code-shape optimization: `long`
instead of `BigInteger` (a faithfulness choice, one line), `Rt.Data.render` into
one `StringBuilder` (the old version was quadratic in nesting depth),
`Rt.runMain` (the program sizes its own stack), `JAVA_RUN_FLAGS`, and the corpus
plus `check-case.sh`/`check-all.sh` — which is what made the simplification safe
to do: `check-all.sh` was green before and after.

When to re-apply: after ANF and closure conversion (plan steps 4–5), and only
after fixing the generator's asymptotics — the 22x on `lean-qsort` says there is
a quadratic path in the optimized `ToJava.ard` that should be understood first.

### Memoizing nullary constants is a REGRESSION — not implemented

The remaining big allocation item in the profile was Lean's typeclass
dictionaries: λ□ has no sharing of top-level definitions (`const k` is a call),
so `mul`/`add` rebuild the whole `OfNat`/`instOfNat` chain and allocate a fresh
`Decidable` just to test the literal pattern `Val 0`, up to ten times per call
(>2 GB). Giving every constant a `private static Object memo_c_foo` cell filled
on first call removes that allocation and still makes `lean-deriv` **slower**:
41–43 s wall / 66 s CPU versus 38–40 s / 57 s (measured before the `Data` change).
Escape analysis was already deleting those allocations, and the `apply` on a
freshly built, type-exact dictionary is monomorphic and inlined — whereas a value
loaded from a mutable `Object` field has unknown type, costing a real virtual
dispatch plus a memory load at every use. The `jIfNull`/`jStaticField` AST nodes
the experiment introduced were removed again with the rest of it; a future
*typed* dictionary hoist would have to reintroduce them.

### Known-arity calls and sunk match alternatives — 2x at runtime, but REVERTED

**Verdict first: implemented, measured, and taken back out.** The two changes
below make every arithmetic case 2x faster and remove both regressions recorded
above, but they cost ~6x in *generation* time (`lean-deriv`: ~380 s to ~2400 s of
Arend typechecking) and ~250 lines of analysis in `ToJava.ard`: a name-keyed
arity table threaded through `compileExpr`/`compileApp`, plus an occurrence
counter. At 1.3x of Peregrine's OCaml backend, another 2x did not justify that,
so the generator went back to the `Rt.app2`/`app3` dispatch and plain `let`
locals — and that dispatch has since been removed too (see "The three-part
performance change was reverted"), so this patch now applies to
`inline-data-and-arity-calls`, not to `main`. The patch itself is preserved on the pushed branch
`known-arity-and-sinking` (commit `9ae5f38`, branched off `05eabe4`), and the
design is recorded here because it is correct and re-appliable once
the generation cost is fixed (see the *Cost* paragraph); only the JVM flag
finding in the next section was kept.

Profiling the whole corpus (JFR, all cases regenerated) found two bottlenecks
that the previous round had left, and each is a generator change only — no new
runtime code, no new AST node:

* `Rt.app2`/`app3` were the **hottest frame** of both matmul workloads (76.8% and
  85.5% of samples). One shared static dispatcher is a single maximally
  megamorphic call site: the JIT sees every callee in the program there and can
  inline through none of them. This was the cause of the `matmul` 1.3x and
  `lean-matmul` 1.4x regressions recorded above.
* 92% of `lean-matmul`'s allocation (~13 GB in 4 s) was **three closures
  allocated before a `switch` of which at most one is used**. Lean's matchers
  compile to `let`-bound lambdas, one per alternative, all built on every call.

1. **Call a known arity directly.** λ□ has no arity in its syntax, so the
   generator derives it: a lambda nest's depth (we compile it ourselves), a
   `fix` slot's body, an axiom's realization (a new third column in
   `javaAxioms`: `Bin` = 2, `curry`/`EQ_REC` = 3), and a program-wide table of
   top-level constants (`constArities`, built once in `compileClass` from each
   body's leading lambdas). `Env` carries the arity of each de Bruijn index
   alongside its expression. When a spine has at least that many arguments,
   `applySpine` emits `((Rt.Fn2) f).apply(a, b)` — no `instanceof`, no static
   helper, and a call site of its own that sees few receivers. Unknown heads
   (0) keep the `Rt.app2`/`app3` fallback, so nothing depends on the analysis
   being complete.
2. **Sink a single-use `let`-bound lambda into its use site.** `occ` counts
   occurrences of a de Bruijn index, counting an occurrence under a `lambda`/`fix`
   binder as *two* (it would run once per call of that function, turning one
   allocation into many). A `let` whose value is a lambda and whose body uses it
   at most once is substituted instead of bound to a local, so the closure is
   allocated only if that `switch` branch is reached. Nothing is duplicated (at
   most one occurrence) and nothing observable is reordered — building a closure
   has no other effect.

Measured on the whole corpus (best of 3, same `Rt.java`, same JVM flags, every
output identical to the previous build):

| case | before | after | |
|---|---:|---:|---|
| `matmul` | 2079 ms | **1052 ms** | 2.0x |
| `matmul-ast` | 2088 ms | **1024 ms** | 2.0x |
| `matmul-bench` | 2101 ms | **1086 ms** | 1.9x |
| `lean-matmul` | 3659 ms | **1793 ms** | 2.0x |
| `lean-deriv` | 8639 ms | **6408 ms** | 1.35x |
| `peano`, `peano-ast`, `example`, `lean-map`, `lean-matmul-peano` | 37–121 ms | 29–156 ms | JVM startup, no signal |

With the change in, both documented regressions were gone: `matmul` was **1.4x
faster than it ever was** (1.5 s before any of this work) and `lean-deriv` below
Peregrine's OCaml
backend (7.0 s on this machine). Codegen, `lean-deriv`: `Rt.app3` 176 → 102 and
`Rt.app2` 233 → 206, replaced by 142 direct `(Rt.Fn3)` and 39 direct `(Rt.Fn2)`
calls; `final Object l…` locals 45 → 27. `matmul`: `app2` 13 → 2, `app3` 5 → 1.

**Cost — the reason for the revert: generation time.** `lean-deriv` (23k lines of
imported λ□) went from ~380 s to ~2400 s of Arend typechecking. `headArity`
compares mangled names against a list per call site — an O(n) lookup inside the
O(n) walk — and `occ` re-walks a `let` body, so the analysis is quadratic in
program size. It is gated to spines of ≥2 arguments, but that is not enough on a
program this size. Small cases are unaffected (peano/matmul extraction unchanged
at ~21–36 s), so the whole cost falls on the one *foreign* benchmark we have.

If this is picked up again, fix the asymptotics *first*: an association tree (or a
sorted array with binary search) keyed by mangled name for `constArities`, and one
bottom-up occurrence pass instead of an `occ` walk per `let`. Only then
re-measure — the runtime numbers above are reproducible; the generation cost is
the only thing that has to change.

### The 8000-bytecode JIT cliff — `-XX:-DontCompileHugeMethods`

Worth knowing before measuring anything on generated Java. HotSpot refuses to
JIT-compile a method larger than **8000 bytecodes** (`-XX:HugeMethodLimit`) and
interprets it forever. The heuristic assumes such a method is a hand-written
mistake; ours are machine-generated, and one Lean definition — `Deriv.Expr.mul`
with its ten match alternatives — is naturally that big.

`lean-deriv`'s `mul` sits at 7938 bytecodes, i.e. *right* at the edge. The two
(now reverted) changes above grew it by 4%, to 8266, and the case became
**2.6x slower**
(8.0–9.6 s → 23.8–24.5 s) while every other case got 2x faster; JFR showed 80.7%
of samples in that one method (it had been 21.3%). With
`-XX:-DontCompileHugeMethods` the same class file runs in 5.1–7.0 s. The flag is
therefore part of the harness (`JAVA_RUN_FLAGS` in `config.sh`, used by
`run-java.sh`, `bench.sh` and `run-ast-suite.sh`); it is neutral on every case
whose methods are small.

The lesson generalizes: a code generator can cross this limit from a change that
has nothing to do with performance, and the symptom (one hot method, a plausible
story about allocation) looks exactly like an ordinary regression. `javap -c` on
the hot class is the cheap check.

## The upstream benchmark corpus and differential checking

Until this round the corpus was thin in a way that had repeatedly misled us: ten
cases, three of which (`matmul`, `matmul-ast`, `matmul-bench`) are the *same*
generated program, and exactly one (`lean-deriv`) that we had not written
ourselves. Seven cases now come from Lean 4's own code-generator benchmarks, as
shipped by `lean-to-lambdabox` (`benchmarks/FromLeanCommon/`, revision `58701f8`):

| case | what it stresses | backends | expected |
|---|---|---|---|
| `lean-deriv` | symbolic differentiation, higher-order | java, ocaml | 40230090 |
| `lean-const-fold` | Nat arithmetic incl. truncated `sub` | java, ocaml | 6895932 |
| `lean-binarytrees` | allocation / GC (the benchmarks-game program) | java, ocaml | 679974 |
| `lean-qsort` | Lean's **array** axioms, in-place sort | java, ocaml | 0 |
| `lean-rbmap-mono` | balanced tree, erased proof component | java, ocaml | 2000 |
| `lean-unionfind` | state monad over an array | java, ocaml | 4000 |
| `lean-const-fold-peano` | the same, axiom-free | **java, c, ocaml, eval** | 1 |
| `lean-binarytrees-peano` | the same, axiom-free | **java, c, ocaml, eval** | 1 |

(`lean-matmul` is *ours*, written in Lean rather than taken from upstream, but it
uses the same shared realizations and so also runs on `ocaml`: its axioms are
exactly `.Nat.add/.sub/.beq/.mul`, which `lean-ocaml-runtime/nat.ml` realizes.)

Each case ships the upstream `.lean` verbatim, `lean-to-lambdabox`'s unmodified
`prog.ast`, a two-line `prog.lean` extraction driver (which only closes the
benchmark over its input, and records how to regenerate), and — for the peano
variants — nothing else. Inputs are reduced from upstream's (e.g. `binarytrees`
12 instead of 17) so a full `run-all.sh` stays minutes rather than hours; the
`prog.lean` header says how to change them.

### Three kinds of comparison, and what each is worth

* **Against Lean itself.** `EXPECTED` is the value Lean's *native* compiler
  produces for the same benchmark at the same input — an oracle from outside this
  project. (`#eval` is not usable for several of them: the interpreter's own depth
  limit trips, independently of `ulimit -s`.)
* **java vs ocaml, on the same λ□ file.** For the axiom cases this is stronger
  than it looks: Lean's `@[extern]` primitives are erased to λ□ **axioms**, and the
  two backends realize them *independently* — ours in `javaAxioms` → `runtime/Rt.java`,
  Lean's own OCaml realizations in `test/lean-ocaml-runtime/` (copied verbatim,
  Zarith-based). Agreement is evidence about the realizations, not only about the
  generator.
* **All four backends on one file.** Only possible for a program with no axioms,
  hence the two `*-peano` cases: erased with `nat := .peano, extern :=
  .preferLogical`, they need no attributes and no realizations, so `peregrine c`
  and `peregrine eval` accept them too. This is the first time the **C backend has
  ever run a Lean-originated program here**. See `lean-peano-drivers/README.md`,
  including why `rbmap_mono` cannot be made axiom-free (`.False.rec` survives).

`check-case.sh <case>` / `check-all.sh` do the comparing. They run nothing: they
read the `output.txt` files the run scripts already wrote, so `run-all.sh` ends
with a machine-checked verdict while still printing every output for eyeballing.
`eval` is excluded from the text diff (it prints `constr Bool.true` where the
compiled backends print `1`), and the outputs must come from one run of the case
— comparing a `java` output taken at `MATMUL_SIZE=130` against a `c` output taken
at 260 is a mismatch in the files, not in the backends.

### It immediately found a bug in committed code

`lean-qsort` is the first case that uses Lean's `Array` axioms, and it **crashed**
in generated Java (`ClassCastException` in `Rt.lng`, reached from `Nat.sub`) while
the OCaml backend printed the correct `0`. `lean-unionfind` failed the same way.

Cause: `Rt.curry`'s argument collector always advertised `Fn3` (from the chunked-
axiom optimization), but `Rt.app2` treats an `Fn3` as a genuine *partial*
application and returns a one-argument closure. So an arity-**2** axiom
(`Array.size`, `Array.mk`, `Array.emptyWithCapacity`) called from a saturated
2-argument call site quietly evaluated to a closure instead of its value — no
error at that point, since a closure is a perfectly good `Object` — and blew up
later inside whatever consumed the number. The collector now implements the
interface matching the arguments *still missing* (`Fn3`/`Fn2`/`Fn`). This is
exactly the class of bug the previous corpus could not reach: it needed a foreign
program using a 2-ary axiom at a flattened call site.

(The whole mechanism is gone from `main` since the revert — there is one interface
and one collector again, so this bug cannot recur here. It is recorded because it
is the concrete evidence that the arity protocol's cost was not only performance:
it had to agree across three places `javac` does not check, and once it didn't.)

A second, smaller blocker: `tools/ast-to-arend` hit CPython's `RecursionError` on
the deeper peano program, and raising the limit alone then overflowed the thread
stack, so the importer now runs its work on a thread with a large stack.

### Timings: the whole corpus, all backends, simplified generator

The numbers below replace two earlier tables. They were taken after the
three-part performance change was reverted, with **every case regenerated and
rebuilt in one `run-all.sh`**, so the compared artifacts come from one state of
the tree. `check-all.sh` was green for all 17 cases.

Two corrections to what this file used to claim, both of which had made us look
worse than we are:

* **The old `ocaml` figure for `lean-const-fold` (696 ms) was a crashed run.**
  Several OCaml binaries need a raised stack limit (the harness sets
  `NATIVE_RUN_STACK=unlimited`); without it `lean-const-fold` dies with
  `Fatal error: exception Stack_overflow` after ~0.5 s. Measured with the limit
  raised — and verified to print `6895932` — it takes ~2.0 s, so the headline
  "17x" is really **6.6x**. Lesson worth keeping: time only runs whose output was
  checked; `run-timed.sh` does that, ad-hoc loops don't.
* Run times here are best of 3 on a machine with other load; the two big cases
  (`lean-const-fold`, `lean-deriv`) have ±30% spread in *every* configuration
  because of the C2 `unloaded`-uncommon-trap pathology described above.

#### Run time (ms, best of 3, `-Xss512m -XX:-DontCompileHugeMethods`, all outputs verified)

| case | java | ocaml | c | java/ocaml |
|---|---:|---:|---:|---:|
| `lean-deriv` | 13835 | 6419 | — | 2.2x |
| `lean-const-fold` | 13097 | 1994 | — | 6.6x |
| `lean-matmul` | 2769 | 2617 | — | **1.06x** |
| `matmul` | 1584 | 1126 | 459 | 1.4x |
| `matmul-bench` | 1506 | 836 | 463 | 1.8x |
| `lean-binarytrees` | 1290 | 100 | — | 13x |
| `lean-qsort` | 944 | 71 | — | 13x |
| `lean-unionfind` | 691 | 53 | — | 13x |
| `lean-rbmap-mono` | 506 | 26 | — | 19x |
| `lean-binarytrees-peano` | 465 | 9 | 7 | 50x |
| `lean-matmul-peano` | 181 | 11 | 10 | 16x |
| `lean-const-fold-peano` | 88 | 16 | 9 | 5.5x |
| `peano`, `peano-ast`, `example`, `lean-map` | 26–31 | — | — | JVM startup |

The spread is 1.06x to 50x, so **no single ratio characterizes the backend** —
which is exactly why `lean-deriv`'s old 1.3x was misleading, and why the 17x
was too. Reading it by workload:

* `lean-matmul` at 1.06x and `matmul` at 1.4x are the arithmetic-bound cases, and
  they are the ones the reverted optimizations *hurt*.
* The 13–19x cases are the ones that allocate constructor nodes hard
  (`binarytrees`, `rbmap_mono`) or use `Array` (`qsort`, `unionfind`) — but note
  they are 26–1300 ms in absolute terms, i.e. a large ratio on a small number.
* The `-peano` ratios are the largest and the least informative: at 9–16 ms for
  the native backends, ~28 ms of JVM startup alone loses the race.

The two structural suspects the corpus names (unchanged by the remeasurement):

* **`Nat` as boxed `Long` through curried axioms** — `const_fold` is almost pure
  `Nat` arithmetic and is the worst of the big cases, while OCaml's realizations
  are Zarith calls the native compiler inlines. Same axis as the documented
  `int63` mismatch, so `targetInt63` would address correctness *and* this. Note,
  though, that profiling `const_fold` blamed a JIT deoptimization pathology and
  allocation, **not** boxing (`java.lang.Long` was 0.3% of allocation samples).
* **Persistent arrays** — `Rt`'s `Array.push`/`set!`/`swap` **copy** (λ□ has no
  linearity information left, see `Rt.java`), so `qsort`/`unionfind` are O(n)
  where Lean is O(1). Upstream's OCaml realizations use Filliâtre's persistent
  arrays with the standard rerooting trick, which is O(1) amortized on the linear
  use these programs actually make. A realization-level fix, not a compiler one.

#### Compile time (ms, from `work/timings.tsv` of the same run)

This is the comparison that decides whether run-time optimization is worth
anything to us right now. "java-gen" is `import-ast` plus the Arend typechecking
run that prints the program; the C/OCaml backends start from the *same* `.ast`,
so `peregrine` is the honest counterpart:

| case | java-gen | javac | c: peregrine | gcc | ocaml: peregrine | ocamlopt |
|---|---:|---:|---:|---:|---:|---:|
| `lean-deriv` | **176787** | 3145 | — | — | 142 | 660 |
| `lean-binarytrees-peano` | 77932 | 2010 | 490 | 2313 | 89 | 377 |
| `lean-binarytrees` | 60315 | 4348 | — | — | 118 | 1525 |
| `lean-unionfind` | 54389 | 1889 | — | — | 87 | 698 |
| `lean-const-fold` | 43961 | 2206 | — | — | 55 | 597 |
| `lean-qsort` | 42333 | 1651 | — | — | 49 | 627 |
| `lean-const-fold-peano` | 41875 | 1689 | 167 | 1107 | 49 | 205 |
| `lean-rbmap-mono` | 36270 | 3504 | — | — | 67 | 812 |
| `lean-matmul` | 24970 | 1205 | — | — | 12 | 517 |
| `matmul` | 22516 | 1045 | 47 | 915 | 28 | 327 |
| small cases | 21291–29133 | ~1100 | 23–86 | 625–858 | 13–18 | 174–255 |

So **our compiler is 300–1400x slower than Peregrine's backends** (12–490 ms
there, 21–177 s here), and ~21 s of that is a fixed floor: resolving and
cache-loading arend-lib's ~156-module cone on every JVM start (see "Binary
caches" above). Compilation is therefore 3–13x the *run* time of even the
slowest case, and 1000x it for the small ones.

#### Verdict: run-time optimizations are not what this project needs

Every case runs in ≤14 s and 13 of 17 in under 1.6 s, so the corpus is
comfortably usable for experimentation — which is the stated goal of the first
cut. Meanwhile the thing one actually waits for is generation, where we are three
orders of magnitude behind, and where the reverted optimizations made it *2–22x
worse still*. Any performance work that ignores the generator optimizes the
wrong end of the pipeline; and the honest fixes on the run-time side
(`targetInt63`, non-copying arrays) are realization- and semantics-level changes
that belong to a dedicated phase, not micro-tuning of the emitted shape.

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

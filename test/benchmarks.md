# The runtime benchmark: what to run before and after changing ToJava

`results.tsv` records timings for every program, but only a handful of programs
run long enough for their run stage to *mean* anything -- most finish in ~0.1 s,
which is JVM startup and nothing else. This file names the ones that do, records
which ones were measured and rejected, and pins down the provenance a
`results.tsv` row cannot hold (it has no commit column).

## The programs

Run exactly these, with `--repeat 5` so the recorded run time is a best-of-5
rather than one sample:

    test/run.py --repeat 5 --timeout 900 matmul matmul250 lean-binarytrees \
        lean-deriv lean-const-fold

| program | java_run | what it stresses | backends |
| --- | --- | --- | --- |
| `matmul` | 1.8 s | primitive int63 arithmetic, 130^3 | java ocaml c |
| `matmul250` | 23.7 s | the same term, 250^3 (7.1x the arithmetic) | java ocaml c |
| `lean-deriv` | 13.1 s | closures, deep `case`, 13 Lean axioms; symbolic differentiation of x^x nested 10 times | java ocaml |
| `lean-const-fold` | 9.8 s | building and folding a 2^20-node expression tree, twice | java ocaml |
| `lean-binarytrees` | 1.8 s | constructor allocation and GC, n=12 | java ocaml |

(best-of-5, from the baseline below, i.e. the `fixKnotArray` encoding; they say
what SIZE of measurement each program gives, not what the current encoding
costs.)

Why these five and not others:

* Every one has a **checked-in `prog.ast`**. The `.ast` is ToJava's *input*, so
  the same bytes go in before and after the change -- that is what makes a
  before/after comparison a comparison. The `leanbench-*` and `peregrine-*`
  programs are read out of upstream checkouts and can move under you; in
  particular use `lean-deriv`, NOT `leanbench-deriv`.
* `matmul` and `matmul250` are the **same term one literal apart**
  (`ExampleMatMul.matMulProgramOf`), so they have the same generated code and
  the same gen/build cost. A change that shows up in `matmul250`'s run column
  but not in `matmul`'s gen/build columns is a runtime change, which is the
  question being asked. `matmul` is also the fast canary: if it goes `wrong`,
  stop reading times.
* They cover four different shapes of work -- primitive arithmetic (matmul),
  closures and deep pattern matching (deriv), expression-tree build-and-fold
  (const_fold), allocation and GC (binarytrees). A ToJava change tends to hit
  one of those and not the others.
* `matmul` and `matmul250` declare **three backends**, and `ocaml_run`/`c_run`
  are unaffected by a ToJava change: they are the control. If `java_run` moves
  20% and `ocaml_run` moved 20% the same way, that is the machine, not the
  change.

### Why 250 and not 300

The size is one literal, so any size is two minutes away
(`tools/regen-arend-asts.sh` knows `matmul200`, `matmul250` and `matmul300`; a
size needs a program directory with a `meta`, plus the two attribute files
copied from `matmul/` -- they are size-independent). Measured java_run,
best-of-3 or better:

    130   3.4 s      (matmul)
    200   8.6 s
    250  21.3 s      (matmul250)
    300  92.5 s

Cubic scaling from 130 predicts ~42 s at 300; the measurement is 92.5 s, more
than 2x off-trend, while 200 and 250 sit near it. Past ~250 the program is
increasingly measuring heap and GC behaviour rather than the speed of the
generated code, which is the wrong signal for a ToJava change -- and 92 s x 5
repeats x 3 backends is a long time to wait for it. 250 keeps the run stage 13x
above the JVM-startup floor while staying on the trend line.

`matmul200` and `matmul300` are therefore not in the corpus. `results.tsv` has
historical rows for both (from the sizing sweep on 2026-08-31, and a `matmul300`
row in the superseded baseline `2026-08-31T09:44:21Z`); they are not part of the
protocol, and their `.ast` files no longer exist.

## Candidates that were measured and rejected

Every handwritten program with a plausible run stage was run once on 2026-08-31
(rows in `results.tsv`, all `check=expected`, `result=ok` -- so these are
rejections for being too FAST, not for being broken):

    lean-const-fold        15.4 s   -> taken into the set
    lean-matmul             3.3 s   spare: Lean-authored matmul, erased Nat
    lean-qsort              1.5 s   spare: arrays and sorting, n=200
    lean-rbmap-mono         0.8 s   too fast (n=20000)
    lean-unionfind          0.8 s   too fast (n=5000)
    lean-binarytrees-peano  0.7 s   too fast
    lean-matmul-peano       0.4 s   too fast
    lean-const-fold-peano   0.2 s   too fast
    lean-map                0.1 s   too fast

So `lean-qsort` and `lean-matmul` are the two spares worth adding if a change
needs wider coverage: they are real work (arrays and sorting; a second,
independently written matmul) at 1.5-3.3 s. The `*-peano` variants exercise the
unary-Nat path, which is interesting but not at 0.2-0.7 s.

The whole `leanbench-*` corpus was measured earlier (`work/suites/lean-benchmarks-timed/results.tsv`):
everything except `deriv` runs in ~0.1-1.4 s there, because those programs are
closed over input 10. The handwritten `lean-*` programs above are the same
benchmarks at much larger inputs, which is why they are the ones to look at.

Deliberately NOT candidates:

* `leanbench-demo1` / `demo1_tc`, the slowest programs in the harness (>300 s).
  Their time is our Java printer rendering a 192 MB value, not the speed of the
  generated code.
* Raising an input further (say `binarytrees 12 -> 14`) would give a heavier
  program, but only by editing its `prog.lean` and re-extracting through Lean,
  which breaks the pinned-AST property mid-comparison. Do it between
  comparisons, never during one.

## Reading the numbers

* `--repeat N` repeats only the run stage and keeps the **minimum**; it warns
  when the spread exceeds 2x, and such a row is ball-park only.
* Compare run columns, not gen/build. `java_gen` is an Arend CLI start, mostly
  loading arend-lib: the same `matmul` term took 46.7 s, 31.6 s and 29.7 s in
  three runs of this same afternoon. It is noise with a program attached.
* **Run the exact command above, with the programs in that order.** This is a
  15 W laptop CPU (1.20 GHz base) and the whole run takes tens of minutes, so it
  downclocks as it goes: a program late in the list is measured on a hotter chip
  than one early in it. That bias is harmless as long as both sides of the
  comparison carry the same one.
* Execution is serial and single-machine, so a row from a busy machine is not
  comparable to one from an idle one. The baseline below and its comparison
  should be taken on the same machine, otherwise the OCaml/C control columns are
  the only thing worth believing.
* Individual measurements on this machine can move a lot for reasons unrelated
  to the code: in the superseded 300x300 baseline, OCaml's five runs of the same
  binary came in at 56.7, 47.5, 19.0, 21.3, 22.1 s -- a 3x range on a backend a
  ToJava change cannot touch. Treat anything under a 2x move on a single program
  as weak evidence, and look at whether the other four moved with it.
* `check=expected` on all five rows: each has an oracle value from outside this
  project, so a timed run also stays honest about correctness. A `wrong` row is
  not a slow result, it is a broken one.

## Baseline, 2026-08-31

Taken before the ToJava `fix` change, on an otherwise idle tree. These rows are
therefore the `fixKnotArray` encoding, and they are a REFERENCE POINT ONLY: as a
comparison partner they are superseded by the same-session crossover further
down, because comparing across sessions on this machine measures the machine.

    commit    074cfd1 (test: consolidate the test harness into one run.py driver)
              plus the working-tree change that ADDED matmul250
              (ExampleMatMul.matMulProgramOf, corpora/handwritten/matmul250/)
    command   test/run.py --repeat 5 --timeout 900 matmul matmul250 \
                  lean-binarytrees lean-deriv lean-const-fold
    machine   11th Gen Intel Core i7-1160G7 @ 1.20GHz, 8 threads, 15 GiB RAM
    os        Linux 7.0.0-30-generic (Ubuntu 24.04), x86_64
    java      OpenJDK 26.0.1+8-34 (64-Bit Server VM, mixed mode, sharing)
    arend     cli-1.12.0-full.jar from ~/arend-lang-bibin

The rows themselves are in `results.tsv`, stamped `2026-08-31T10:36:50Z` -- they
are the record, not this file. One invocation stamps one timestamp on all its
rows, so:

    awk -F'\t' 'NR==1 || $1 == "2026-08-31T10:36:50Z"' test/results.tsv | column -t

All five came back `check=expected`, `result=ok`, and no spread warning fired.
Numbers, for reading at a glance (seconds; run columns are best-of-5):

    program           java_gen  java_build  java_run  ocaml_run  c_run  output
    matmul                29.7         1.3       1.8        1.1    0.6  2197000
    matmul250             29.9         1.4      23.7       15.0    9.8  15625000
    lean-binarytrees      34.3         2.1       1.8        0.1      -  679974
    lean-deriv           182.0         3.0      13.1        5.1      -  40230090
    lean-const-fold       31.7         1.2       9.8        2.1      -  6895932

Note the shape of `matmul` vs `matmul250`: the run times differ 13x while gen and
build carry no size dependence at all -- they are the same order of magnitude and
which of the two is larger varies from run to run (gen came in at 29.7 vs 29.9 s
here, 18.0 vs 20.8 s later the same day, 26.7 vs 20.4 s later still). That is the
property the pair was built for: ToJava does the same work on both, so the run
gap is purely the generated code executing. Quote the run gap as the evidence,
not the gen equality -- gen is noise-dominated on this machine.

Other rows in `results.tsv` from the same day are NOT the baseline: the
superseded five-program run at `2026-08-31T09:44:21Z` (with `matmul300`), the
single-sample sizing probes, and the nine-program candidate survey.

## How to compare two encodings: A/B in one session, crossover

The baseline above is a REFERENCE POINT, not a comparison partner. This machine
drifts far too much between runs to compare across them: the same unchanged
OCaml binary for `matmul250` measured 15.0 s at 10:36 and 9.9 s at 11:52, and
`lean-deriv`'s OCaml run moved 4.8 -> 6.1 s between two java runs eleven minutes
apart. A number from an hour ago is not evidence about a code change.

So to compare encoding A against encoding B:

1. Run the benchmark command with A.
2. Change the generator to emit B and nothing else. (When this was written, that
   was one line -- `targetLong` vs `targetLongKnotArray` in
   `lambox-to-java/src/ToJava.ard`. Both are GONE: the `JavaTarget` record and
   the second `fix` encoding were removed once the comparison below had settled
   the question, so reproducing that particular A/B now means reintroducing the
   encoding. The protocol is what generalizes, not those two names.)
3. Run the same command again, immediately.
4. Do it a second time in the OPPOSITE order (B then A). Drift is monotone over
   a session, so averaging the two orders cancels it; agreeing in SIGN across
   both orders is what makes a few-percent difference believable at all.
5. Read `ocaml_run`/`c_run` as the control on every pair. A ToJava change cannot
   touch them, so if they moved as much as `java_run` did, the run pair is
   telling you about the machine.

A single pair, in one direction, cannot resolve anything below ~20%.

## Result: `fixLocalClass` vs `fixKnotArray` (2026-08-31)

The two `fix` encodings that `ToJava.ard`'s `FixStyle` used to select, measured
by the protocol above. `FixStyle` and the mutable-`Fn[]` encoding have since been
removed and only the local class remains; the reasoning it preserves is now in
the `fix` clause of `compileExpr`. Every run was `check=expected`, `result=ok` -- the two encodings agree on
every value, which is the first thing being tested.

    order 1 (local class 11:52, knot array 12:03)
    program           local  knot   java   ocaml control
    matmul250          16.0  15.4   +3.9%  9.9 vs 9.7  (+2%)
    lean-deriv         12.3  14.1  -12.8%  4.8 vs 6.1 (-21%)   <- control moved MORE
    lean-const-fold    10.6  11.4   -7.0%  2.1 vs 2.6 (-19%)   <- control moved MORE
    matmul              1.3   1.2   +8.3%  0.8 vs 0.7
    lean-binarytrees    1.2   1.4  -14.3%  0.1 vs 0.1

    order 2 (knot array 12:14, local class 12:25) -- controls identical, so this
    is the clean pair
    program           knot   local  java    ocaml control
    matmul250          19.7  20.0   +1.5%   12.5 vs 12.6 (+0.8%)
    lean-deriv         14.1  14.8   +5.0%   6.0 vs 6.0 (0%)
    lean-const-fold    12.2  12.7   +4.1%   2.6 vs 2.6 (0%)

Reading it: in order 1 the machine sped up by more than the java columns did, so
the local class' apparent 7-13% *win* on deriv and const-fold is drift, and
correcting for the control turns it into a loss. Order 2 has flat controls and is
the number to quote: **the local-class encoding is 1-5% slower** -- ~1.5% on
`matmul250`, ~4-5% on `lean-deriv` and `lean-const-fold`. Both orders agree in
sign once the control is taken into account, on all three programs.

`matmul` and `lean-binarytrees` (1.2-1.4 s) disagreed in sign between orders and
resolve nothing, as expected at that size.

So: no significant regression, a consistent small one. Where it comes from is not
mysterious -- a sibling used as a value allocates a forwarding closure at the
point of use, where the array encoding reads `x[j]`. The next step if that 1-5%
ever matters: give the environment a "this is a known method" entry so an
application of a fix slot compiles to a direct method call and allocates nothing.
That is a change to `compileExpr`'s `app` clause and the env type, not to this
encoding, and it is only worth doing with these numbers in hand.

Correctness, same change: `run.py --all` -- 55 programs, 0 failures, the one
xfail (`example`) unchanged and unrelated. 46 of the 71 generated programs
contain a local `Fix` class (178 of them, with 294 sibling references), and the
eta-expansion branch for an unguarded fix body appeared in NONE of them, which is
what makes it dead code in practice rather than in theory.

## Result: `case` as a ternary chain vs as a `switch` (2026-08-31)

The change that replaced `jSwitch` + a result local with `jCond` + `jTagEq`, and
bound a branch's field binders to `d.fields[i]` instead of to locals. Every value
was correct on every run of both sides.

Measured by interleaving A/B on one pair of already-built trees rather than by
running the protocol's five programs twice: the `before` side is a copy of the
project with `JavaAst`/`JavaPrint`/`ToJava`/`JavaAxioms`/`Rt.java` restored from
HEAD, so both sides are generated from the same `.ast` bytes in the same session.

**The signal program, with the control.** Two interleaved rounds, best-of-3 per
sample (control best-of-2):

    program                switch   ternary   delta
    matmul250 round 1       19.49     18.16    -6.8%
    matmul250 round 2       19.49     18.15    -6.9%
    matmul    round 1        1.62      1.41
    matmul    round 2        1.48      1.41
    ocaml matmul250 control 11.55     11.64    +0.8%   <- flat, so the machine held

Both rounds agree to 0.01 s and the control moved 0.8%, so **-6.8% on matmul250
is real**. That is the opposite sign to the two small Lean programs below.

**The rest**, measured earlier the same way but WITHOUT a control -- three of the
four finish under 2.7 s, which is why `lean-binarytrees` could not be explained.
Columns are the MEDIAN of three samples, each sample itself a best-of-3
(best-of-5 under 4 s); median rather than best-of because `lean-const-fold`
spread 4.8-7.6 s and a best-of would quote it as -57%.

    program           switch  ternary  delta   samples (switch vs ternary)
    matmul              1.54     1.49   -3%    1.55/1.49/1.54 vs 1.49/1.49/1.45
    lean-matmul         2.12     2.64   +25%   2.17/2.03/2.12 vs 2.62/2.66/2.64
    lean-binarytrees    1.08     1.22   +13%   1.10/1.01/1.08 vs 1.22/1.21/1.22
    lean-const-fold    11.18     7.28   -35%   11.1/11.2/11.2 vs 7.3/7.6/4.8

`lean-deriv` was value-checked but not A/B'd: 40230090 in 7.8 s, against the
12.1-14.8 s its `results.tsv` rows span. Different session, no control, so read
it as agreeing in sign with `lean-const-fold` and not as a measurement.

So the change is a WIN on the two programs big enough to measure well
(`matmul250` -6.8% controlled, `lean-const-fold` -35%) and a loss on two small
ones (`lean-matmul` +25%, `lean-binarytrees` +13%). The +25% has an identified
cause, below; it is a property of one hot arm, not of the encoding.

Non-runtime columns all improved: the committed goldens went 5082 -> 2098 lines
(-59%), and Arend spent 35.9 s generating the four programs where it had spent
75.6 s (-53%), the generator having less to build.

**Where the +26% comes from, measured rather than guessed.** A branch that needs
statements -- one that names an intermediate value -- becomes a thunk
(`armExpr`). Counting executions by patching a `long[]` into the runtime and
incrementing per thunk site:

    lean-matmul       2 thunk sites, executed 145,010,450 and 2,197,000 times
    lean-binarytrees  3 thunk sites, executed 5, 5 and 5,456 times
    lean-const-fold  12 thunk sites, executed 2.6M total across 4 live sites

So lean-matmul has one thunk in its innermost loop: an arm that must evaluate and
name `Nat.beq(l, 0)` before matching on it. That is intrinsic to `case` being an
expression, not an accident of this encoding -- Java has no block expression, so
naming a value inside an arm costs an `Rt.Fn`. Its GC count rose 23 -> 33, which
agrees.

`lean-binarytrees`' +16% is NOT the thunk (5,456 executions) and NOT allocation
(young GCs went 14 -> 12) and NOT the field-read change (26 reads -> 20). What is
left is the tag chain replacing a jump table: matches have 1-4 arms (a few have
8), so a `tableswitch` became 2-4 comparisons. Unproven, and at 1.1 s the program
is warmup-dominated, so treat it as measured-but-unexplained.

The fix for both, when it matters: lambda-lift a statementful arm into a
`private static Object arm_<path>(<captured>)` and call it -- a static call
allocating nothing, instead of a closure. That needs `JMethod` to grow
parameters (it is deliberately zero-argument today) plus a free-variable analysis
of the arm, so it is its own change. A cheaper partial one: compile an
application of a `fix` sibling to a direct call, which removes both the
forwarding closure and, at sites like matmul's, some of the naming pressure.

### How the `before` side was rebuilt

Worth writing down, because an A/B needs the OLD generator and the old sources
were uncommitted-over rather than committed:

    cp arend.yaml src/ runtime/ -> /tmp/before-project
    for f in JavaAst JavaPrint ToJava JavaAxioms; do
      git show HEAD:lambox-to-java/src/$f.ard > /tmp/before-project/src/$f.ard
    done
    git show HEAD:lambox-to-java/runtime/Rt.java > /tmp/before-project/runtime/Rt.java

Then point `golden.py`'s `AREND_PROJECT` at it and reuse `golden.generate`, which
dumps every selected program in ONE Arend run. `src/Imported/` comes along in the
copy, so no peregrine is needed. Each side is built with ITS OWN `Rt.java` --
`noBranch` exists only on the ternary side.

### The variant not taken: `Rt.match(scrut, f0, f1, ..)`

The alternative to a ternary chain is one runtime call per `case`, taking the
scrutinee and every branch as a varargs `Fn...`:

    return Rt.match(scrut,
      new Rt.Fn(){ public Object apply(Object i){ <stmts0> return <e0>; } },
      new Rt.Fn(){ public Object apply(Object i){ <stmts1> return <e1>; } });

    // runtime
    public static Object match(Object scrut, Fn... bs) {
      Data d = (Data) scrut;
      return d.tag < bs.length ? bs[d.tag].apply(BOX) : noBranch(d, "?");
    }

Varargs is what makes the "no AST change" claim true -- it is a `jCallStatic`
with n+1 arguments, needing neither an array type nor an array-literal node (both
were deleted in 881dfe6).

Rejected on both counts.

**Cost.** It allocates k closures AND the varargs array on EVERY evaluation of
EVERY match, where the chain allocates only the selected arm's thunk, and only
when that arm needs statements. In lean-matmul that is 2 of 21 arms; the other 19
allocate nothing. Worse, the allocations are not eliminable: `bs[d.tag]` indexes
by a value the JIT cannot fold, so escape analysis cannot scalar-replace the
array. The chain's thunk sits at a monomorphic `new Fn(){..}.apply(BOX)` site,
which HotSpot can and sometimes does scalar-replace -- lean-matmul's hot thunk is
too big to inline, which is precisely why that one costs 25%.

Order of magnitude, derived not measured: the chain's 0.52 s over 145M hot-thunk
executions is ~3.5 ns per closure. `Rt.match` would pay several of those per
inner-loop iteration instead of one, plus an array, so expect a multiple of the
chain's +25% -- and it would pay them on `lean-const-fold` too, which the chain
made 35% FASTER.

**Verifiability.** `match` would be an ASSUMED runtime function -- the
`JavaAxioms.ard` category, "data a proof takes as a HYPOTHESIS". That puts
`case`, a core λ□ construct, in the assumed periphery, which is the opposite of
the split JavaAst.ard exists to maintain. It also needs `bs[d.tag]`: a COMPUTED
array index, the one thing the fragment deliberately excludes (`jDataField` takes
a `Nat` so that no arithmetic is needed anywhere). `jCond`/`jTagEq` instead
interpret `case` in the AST, and the thunk is not a new node or a new hypothesis
at all -- it reuses `jClosure`/`jApply`, whose semantics the proof already needs
for λ□ `lambda`/`app`, and `apply(closure(b), BOX) = b` is a beta step already in
that semantics.

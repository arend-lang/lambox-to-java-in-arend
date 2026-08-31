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

(best-of-5, from the baseline below.)

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

Taken before the planned ToJava change, on an otherwise idle tree.

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

Note the shape of `matmul` vs `matmul250`: gen (29.7 vs 29.9 s) and build (1.3
vs 1.4 s) agree while the run time differs 13x. That is the property the pair
was built for -- ToJava does the same work on both, so the run gap is purely the
generated code executing -- and it held on both runs it was measured on.

Other rows in `results.tsv` from the same day are NOT the baseline: the
superseded five-program run at `2026-08-31T09:44:21Z` (with `matmul300`), the
single-sample sizing probes, and the nine-program candidate survey.

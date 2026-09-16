# Test harness

Compiles λ□ programs with this repository's Arend-implemented backend and with
two reference backends (Peregrine's OCaml/Malfunction and C), runs the result,
and checks the value that comes out.

A program is always a λ□ s-expression file (`prog.ast`). One driver, `run.py`,
owns the matrix of (program × backend); everything else is a small script it
calls.

    test/run.py                      # list the programs there are, run nothing
    test/run.py matmul peano         # run exactly these
    test/run.py --all                # every program, every backend it declares

## Prerequisites

Nothing has to be installed to run the harness: a stage whose toolchain is
missing exits 3, the row is recorded as `skip-no-tool`, and the run prints one
warning per backend. It never aborts, and a missing toolchain is never a
failure. Tool paths are hard-coded in `lib.sh` (edit them there if a tool
moves on this machine) rather than configurable through the environment:
Arend CLI (a **development** 1.12 build), a JDK, Peregrine, Python 3, OCaml
(`ocamlopt`/`malfunction`), and gcc plus the CertiRocq runtime.

## Two checks, and which one to reach for

There are two scripts, and they answer different questions:

| | question | cost |
|---|---|---|
| `golden.py` | did the **generated Java** change? | 35 s |
| `run.py` | does the compiled program compute the **right value**? | ~30 min for `--all` |

Most changes to `ToJava.ard` / `JavaPrint.ard` need only the first, so that is
the inner loop: `golden.py` runs no peregrine, no `javac`, and executes no
program. Run `run.py --all` before a commit, because a golden diff cannot tell
you that the code it blessed still *runs* — see `golden.py`'s own docstring for
why keeping both is the point rather than redundancy.

## Usage: golden.py

    test/golden.py [PROGRAM...] [--set smoke|cover|all] [--update] [--jobs N] [--list]

Regenerates the Java for a few programs in ONE Arend invocation and diffs it
against `golden/<program>.java`, which is committed. `--update` accepts the
current output *and prints the diff it is accepting*, so blessing a change is
visible both in the terminal and afterwards in `git diff`.

* `--set smoke` (default) — four programs, 3.2k lines of λ□ (1.6 % of the
  corpus), 35 s. Chosen by set cover over the features observable in generated
  Java, minimized by input size; each program's reason is recorded next to it in
  `golden.py`. **Do not prune the set by size** — three of the four are the
  cheapest program in the corpus exhibiting their feature.
* `--set cover` — adds `lean-deriv`, the only program (with `leanbench-deriv`)
  reaching `Rt.EQ_REC` and the `Rt.INT_*` family. Complete coverage, but ~130 s,
  because that one program is 23k lines.
* `--jobs N` — shards across N Arend processes. **Measured to lose** on these
  sets (12 small programs: 31 s with 1 shard, 82 s with 4): each shard pays ~25 s
  of JVM start, arend-lib load and typechecking `ToJava.ard`, which dominates.
  Only `--set all` is expected to gain. Default 1.

Not covered by any set, because no corpus program exercises it: λ□ `proj`
(**zero** occurrences across all 68 programs), `fvar`, and an unguarded `fix`
body. Closing that needs a hand-written λ□ term, not a wider corpus.

## Usage: run.py

    test/run.py [PROGRAM...] [--all] [--repeat N] [--jobs N] [--timeout S]

Selection is program names, and nothing else. With no name and no `--all` the
run lists what there is (name, backends, corpus, note) and stops; an unknown
name is an error that suggests the nearest ones. A program always runs on every
backend it declares — there is no way to ask for one, because a run of a single
backend cannot use the differential oracle (see below).

* `--repeat N` — run the RUN stage N times and keep the best time; generation
  and build are deterministic and are paid once.
* `--jobs N` — run N programs concurrently, and **do not record** anything.
  Worth about 1.4x on this machine (4 programs: 102 s serial, 71 s at `-j 4`) —
  less than the core count suggests, because one Arend generation already uses
  ~2.7 cores, so a few concurrent ones saturate the box. It refuses to combine
  with `--repeat > 1`, and it skips `results.tsv` entirely: that file's timing
  columns are what `benchmarks.md` quotes, and a contended number is not
  comparable to anything (an unchanged binary has measured 15.0 s and 9.9 s an
  hour apart on this machine). Use it for a correctness sweep, never for timing.
* `--timeout S` — per-stage timeout in seconds (default 300; java generation is
  30-60 s on this corpus). The stage runs in its own process group, so a
  timeout kills the compiled program too.

The exit status is non-zero if any program failed **or** if two backends of one
program disagreed. Every program appends one row to `results.tsv`; the scratch
of a run (generated code, binaries, `output.txt`) is in
`work/<program>/<backend>/`.

While iterating, prefer `test/golden.py` (35 s). When a value needs checking,
two programs are worth running (about two minutes together, most of it java
generation):

    test/run.py matmul lean-matmul-peano

`matmul` has an upstream value and all three backends; `lean-matmul-peano` is
the same computation with no primitives and no attributes, so a break in the
axiom machinery shows up as one of the two going red rather than both.
Everything else belongs to `--all` before a commit.

## Optional: the Arend CLI daemon

Both `golden.py` and `run.py` work with or without a daemon. Without one,
nothing changes: every Arend invocation pays ~18 s to parse arend-lib (see
`tools/extract-arend.sh`). With one, that is paid once at startup.

    test/tools/daemon.sh start        # ~30 s, then it idles
    AREND_DAEMON=1 test/golden.py
    AREND_DAEMON=1 test/run.py peano letchain
    test/tools/daemon.sh stop         # also: status

Measured on this machine, same jar both ways (`cliDaemon-12`):

    golden.py (smoke, 4 programs)        27 s  ->  10-11 s
    run.py peano leanbench-even          50 s  ->     7 s   <- gen: 21 s -> 1.2 s
    golden.py --set cover               129 s  ->    131 s   <- NO gain

The pattern: the daemon removes a fixed per-invocation cost and nothing else.
That is most of the runtime for small programs and for `run.py`, which pays it
once per program; it is nothing at all for `--set cover`, whose time is
`lean-deriv` actually being compiled -- there the two modes measure the same to
within noise. So reach for it when iterating, not to make a big sweep cheap.

**It needs a CLI that has a daemon**, which 1.12 as released does not; `start`
exits 3 (skip-no-tool) if the jar has no `-d`. Verified against upstream
`cliDaemon-12` with this fork's String commit cherry-picked on top — that branch
is a strict improvement on `cliDaemon-2`/`-4`: it takes the library positional
like any other command (so the harness' command line is now identical in both
modes), and the stale-`.arc` failures those branches showed are gone (they are
what its `Write .arc files atomically…` / `Pin the order binary caches are
deserialized in` commits are about). Three consequences of the daemon are handled
for you, and are worth knowing because they all bit us first:

* `start` clears `src/Imported` — bootstrap typechecks the whole library, and
  each generated module typechecks by COMPILING its program. On `cliDaemon-2`
  that overflowed the stack at 69 of them; on `cliDaemon-12` it does not overflow
  (measured: 12 of 65 modules in 6 minutes, no overflow) but it is far slower
  than the CLI's own 600 s wait for readiness, so a start with them present never
  reports ready. The gen stage rewrites them anyway.
* `start` exports `-Xss1g` to the daemon's child JVM, which is spawned with no
  options of its own.
* a definition the daemon considers unchanged is not re-typechecked, and the
  text this harness harvests is a side effect of typechecking it. So the
  generated module gets a `--stamp` (`tools/ast-to-arend`) and `golden.py`
  stamps its dump definitions' NAMES. Stamping a comment is not enough: the
  file changes, the definition does not.

## Layout

    run.py         the driver: the matrix, the timing, the statuses, the table
    golden.py      the fast check: generated Java vs golden/, one Arend run
    golden/        committed expected output, one .java per program
    lib.sh         tool paths (hard-coded) + require_tool + run_cmd helpers
                   and AREND_DAEMON, the one daemon switch
    stages/        one script per backend: java.sh, ocaml.sh, c.sh, each
                   taking `gen|build|run` as its first argument
    corpora/       one script per corpus, each printing TSV rows:
                     handwritten.sh     our own programs, one directory each
                     lean-benchmarks.sh lean-to-lambdabox's benchmark suite (upstream)
                     peregrine.sh       peregrine's own .ast fixtures (upstream)
    runtime/       C/OCaml driver bundles: lean, peano, int63 (each a vars.sh + README)
    tools/         manual tools: extract-arend.sh, import-ast.sh, ast-to-arend,
                   eval-ast.sh, regen-arend-asts.sh, extract-lean-benchmarks.sh
    work/          gitignored scratch, work/<program>/<backend>/
    results.tsv    append-only history, one row per program per run
    benchmarks.md  which programs are worth TIMING, and the recorded baseline

A stage script takes positional arguments only and knows nothing about
programs or corpora; it can always be re-run by hand:

    test/stages/java.sh gen corpora/handwritten/matmul/prog.ast work/matmul/java Matmul

Its contract with `run.py` is the exit status: **3** = a tool is missing,
**4** = this backend cannot run this program, any other non-zero = failure.

## Adding a program to the handwritten corpus

Create `corpora/handwritten/<name>/` with a `prog.ast` (the λ□ program) and a
`meta` file of `key=value` lines — plain data, deliberately *not* sourced.

    expected=2197000            # the value every backend must print; empty = no such oracle
    backends=java ocaml c       # which backends can consume this program
    runtime=int63               # a runtime/ bundle, for the C/OCaml drivers; empty for java-only
    xfail=                      # non-empty = the REASON this program is known to fail
    note=130^3; the corpus' only int63-vs-long witness

The OCaml and C stages also need `prog.attr` next to `prog.ast` (Peregrine
requires the flag); copy `runtime/peano/empty.attr` if the program realizes no
axioms. A program whose axioms map to *different* native symbols in C ships an
additional `prog-c.attr`, which `stages/c.sh gen` prefers when present.

If the program is written in Arend rather than coming from Lean/Rocq, add its
`\func` to the `lambox-to-java-examples` project, not `lambox-to-java` itself
(see `lambox-to-java-examples/README.md`), and run
`tools/regen-arend-asts.sh <name>` once to serialize and commit the `.ast`.

## Adding a corpus

Drop one executable bash script `corpora/<name>.sh` that prints one TSV row per
program on stdout and nothing else. The columns are fixed:

    program  ast  expected  backends  runtime  xfail  note

`ast` is a path relative to `test/`, or absolute. A corpus whose upstream is
not installed must print **no rows and exit 0**: `run.py` then reports it as
unavailable instead of failing. `corpora/handwritten.sh` is the template.

The two upstream corpora (`lean-benchmarks`, `peregrine`) each read a checkout
that is not part of this repository, at `$HOME/lean-to-lambdabox` and
`$HOME/peregrine-tool`, and treat it as read-only. `lean-benchmarks` also needs
its `.ast` cache produced once with `tools/extract-lean-benchmarks.sh`.

## Statuses

    ok                the backend ran and, if the row has one, matched `expected`
    wrong             it ran and produced a different value than `expected`
    gen-fail          the gen stage failed (our generator, or peregrine's)
    build-fail        the build stage failed (javac / ocamlopt+malfunction / gcc)
    run-fail          the compiled program exited non-zero
    timeout           a stage exceeded --timeout; its process group was killed
    skip-unsupported  exit 4: this backend cannot run this program (no driver in
                      the runtime bundle)
    skip-no-tool      exit 3: the toolchain is not installed on this machine
    disagree          two backends of one program printed different values
    xfail             a known, documented failure of this program

Only `wrong`, `gen-fail`, `build-fail`, `run-fail`, `timeout` and `disagree` are
failures; the two `skip-*` statuses and `xfail` let a wide external corpus say
what it cannot do without going permanently red. A program's row reports the
worst thing that happened, with the backend that caused it (`build-fail(ocaml)`).
`xfail` absorbs a genuine failure and *only* that: a `wrong` value is still
reported as wrong on an `xfail` program.

## The two oracles

Every row says in its `check` column what actually verified it:

1. **`expected`** — the program's `expected` value, compared against what it
   printed. It comes from *outside* this project: upstream's own recorded
   answer, Lean's `#eval`, or a value derived by hand from the program's
   constructor declaration order.
2. **`differential`** — the backends of one program agreed, with no value to
   compare against.
3. **`none`** — neither applied: one backend, no value. The run only
   established that the program did not crash; the summary names these.

Values are compared with whitespace deleted (our Java printer indents
constructor data by nesting depth; the other backends do not), and a value
longer than 200 characters is recorded and compared as a head plus a `sha256`
of the whole of it. The value itself is always in
`work/<program>/<backend>/output.txt`.

## Known limitations

* **Comparison ignores whitespace**, so a program printing two adjacent numbers
  (`2 3`) would compare equal to one printing `23`. No current program prints
  more than one value.
* **The OCaml `lean` runtime bundle can only print a `Nat`** (its driver is
  `print_endline (Z.to_string Bench.main)`), so a program returning `Unit` or a
  list declares `java` only.
* **No artifact caching**: every run regenerates from the `.ast`, and java
  generation costs ~20 s per program. Almost all of that is a FIXED
  per-invocation cost, and it is not what it looks like: JVM start is 0.1 s,
  `Loaded arend-lib` 0.14 s and typechecking the target 0.02 s, while ~18 s is
  ANTLR parsing arend-lib's sources. Arend's `.arc` binary cache does not help,
  because it skips typechecking and not parsing — measured, 18.9 s cold vs
  18.8 s warm. Turning it on is not merely useless but harmful here: a cached
  print module is not re-typechecked, so the `putStrLn` this harness harvests
  never runs (measured, 0 lines out), which is why `tools/extract-arend.sh`
  clears `bin/` on purpose. Its header has the full numbers, the per-import
  cliff, and where an upstream win would come from.
* **Gen is one Arend invocation per program**, so `run.py --all` pays that ~18 s
  sixty-eight times — about 20 minutes of pure parsing. Batching it is the one
  big lever, and `golden.py` shows it works (4 programs in 30 s against ~74 s
  for four separate invocations), but it is not a flag anyone forgot: it needs
  `golden.py`'s one-module-many-programs `dump_module` trick generalized to
  write files per program, because today each program gets its own
  `Imported/<Module>.ard` and its own CLI run.
* **Serial execution**: timings are ball-park and can come from a dirty tree
  (only the timestamp identifies a `results.tsv` row).
* **`peregrine eval`** (Peregrine's own evaluator) is not a backend of the
  matrix — its output is a rendered λ□ term, not a comparable value. It
  survives as the standalone `tools/eval-ast.sh`, run by hand.

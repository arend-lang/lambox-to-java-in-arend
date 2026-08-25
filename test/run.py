#!/usr/bin/env python3
"""The harness driver: the only thing that knows about the matrix.

    test/run.py                      # list the program names, run nothing
    test/run.py matmul peano         # run exactly these
    test/run.py --all                # every program of every corpus

It discovers programs by RUNNING corpora/*.sh (each prints TSV rows), runs the
stage scripts of each backend with a timeout, times them, and appends ONE row
per program to the append-only results.tsv -- backends as columns, so java and
ocaml sit next to each other.

Two things verify a row, and the `check` column says which one did: the
program's `expected` value (from outside this project), or the backends of one
program agreeing with each other. `check=none` means the run only established
that the program did not crash, and the summary counts those out loud.

Everything about a command line -- flags, file names, tool paths -- lives in
stages/*.sh and lib.sh instead. This file owns only what bash did badly: the
matrix, the timing, the statuses and the table.
"""

import argparse
import difflib
import hashlib
import os
import signal
import subprocess
import sys
import time
from datetime import datetime, timezone
from pathlib import Path

TEST_DIR = Path(__file__).resolve().parent
CORPORA_DIR = TEST_DIR / "corpora"
STAGES_DIR = TEST_DIR / "stages"
WORK_DIR = TEST_DIR / "work"
RESULTS = TEST_DIR / "results.tsv"

# The whole pipeline, as data. A stage's arguments are derived from the program
# row (Program.stage_args); nothing per-program is ever a command string. One
# script per backend (stages/<backend>.sh), taking the kind (gen/build/run) as
# its first argument.
BACKEND_SCRIPT = {
    "java": "java.sh",
    "ocaml": "ocaml.sh",
    "c": "c.sh",
}
KINDS = ("gen", "build", "run")

# The stage scripts' side of the contract (lib.sh).
EXIT_NO_TOOL = 3
EXIT_UNSUPPORTED = 4

# The per-backend statuses that are a failure of the run. A `skip-*` says the
# machine is missing something, which a wide external corpus must be able to say
# without going permanently red.
FAILED = ("wrong", "gen-fail", "build-fail", "run-fail", "timeout")
# The statuses whose backend actually produced a value: "ocaml=2197000 vs java="
# is not a disagreement, it is a missing toolchain reported twice.
PRODUCED = ("ok", "wrong")

# One row per program; the times grouped by stage kind, so the comparison the
# table exists for is one glance along a row.
COLUMNS = (["timestamp", "program", "check", "result"]
           + [f"{b}_{k}" for k in KINDS for b in BACKEND_SCRIPT]
           + ["output", "expected"])
CORPUS_COLUMNS = ["program", "ast", "expected", "backends", "runtime", "xfail", "note"]


class Program:
    """One row of a corpus script."""

    def __init__(self, corpus, fields):
        row = dict(zip(CORPUS_COLUMNS, fields + [""] * len(CORPUS_COLUMNS)))
        self.corpus = corpus
        self.name = row["program"]
        self.ast = row["ast"]
        self.expected = normalize(row["expected"])
        self.backends = row["backends"].split()
        self.runtime = row["runtime"].strip()
        self.xfail = row["xfail"].strip()  # a REASON, or empty
        self.note = row["note"]

    def module(self):
        """lean-const-fold -> LeanConstFold: the Imported.<Module> a java run
        typechecks. Derived from the program id so two programs cannot overwrite
        each other's generated Arend module (execution is serial, so that is
        enough). Passed explicitly to stages/java.sh to keep the rule in one
        place."""
        return "".join(w[:1].upper() + w[1:] for w in self.name.replace("_", "-").split("-"))

    def outdir(self, backend):
        return WORK_DIR / self.name / backend

    def stage_args(self, kind, backend):
        outdir = str(self.outdir(backend))
        ast = str(TEST_DIR / self.ast)
        if kind == "gen":
            return [ast, outdir] + ([self.module()] if backend == "java" else [self.runtime])
        if kind == "build" and backend != "java":
            return [outdir, self.runtime]
        return [outdir]


def normalize(text):
    """A value as it is compared and recorded.

    Whitespace is deleted: our Java printer's is layout (it indents constructor
    data by nesting depth), and the other backends' is not the same layout. The
    price is that a program printing `2 3` would compare equal to one printing
    `23` -- no program prints two values, and this is written down in the
    README's KNOWN GAPS rather than guarded against.

    Past 200 characters the value becomes a head plus a sha256 of the whole of
    it: `leanbench-demo1` returns an 8000-element list, which the same indenting
    printer renders as 192 MB of text. A hash still compares exactly; the value
    itself is always in work/<program>/<backend>/output.txt."""
    value = "".join(text.split())
    if len(value) <= 200:
        return value
    return f"{value[:200]}...sha256:{hashlib.sha256(value.encode()).hexdigest()}"


def load_corpora():
    """Run corpora/*.sh and parse their rows. A corpus whose upstream is absent
    prints nothing; that is not an error, it is reported as unavailable."""
    programs = []
    for script in sorted(CORPORA_DIR.glob("*.sh")):
        proc = subprocess.run([str(script)], cwd=TEST_DIR, capture_output=True, text=True)
        if proc.returncode != 0:
            tail = proc.stderr.strip().splitlines()
            warn(f"corpus {script.stem} exited {proc.returncode}: "
                 f"{tail[-1] if tail else 'no message'}")
        rows = [line for line in proc.stdout.splitlines()
                if line.strip() and not line.lstrip().startswith("#")]
        if not rows:
            warn(f"corpus {script.stem}: no rows (upstream not installed?)")
        programs += [Program(script.stem, line.split("\t")) for line in rows]
    return programs


def run_stage(prog, backend, kind, timeout):
    """Run one (backend, kind) stage. Returns (exit status, seconds, diagnostic
    tail).

    The stage script is its own session leader (start_new_session), so that a
    timeout can kill the whole process group: the thing we actually want dead is
    the *grandchild* -- the compiled program the stage script started -- and
    killing only the script would leave it running, competing for the single
    core every later timing is measured on."""
    cmd = [str(STAGES_DIR / BACKEND_SCRIPT[backend]), kind] + prog.stage_args(kind, backend)
    start = time.monotonic()
    proc = subprocess.Popen(cmd, cwd=TEST_DIR, text=True, start_new_session=True,
                            stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    try:
        out, err = proc.communicate(timeout=timeout)
        status, err = proc.returncode, err or out
    except subprocess.TimeoutExpired:
        try:
            os.killpg(os.getpgid(proc.pid), signal.SIGKILL)
        except (ProcessLookupError, PermissionError):
            proc.kill()
        out, err = proc.communicate()
        status, err = "timeout", err or out
    return status, time.monotonic() - start, err


def run_backend(prog, backend, args):
    """The three stages of one backend, stopping at the first that fails.

    Returns (status, {stage kind: seconds}, value, diagnostic tail)."""
    secs = {}
    stale = prog.outdir(backend) / "output.txt"
    if stale.exists():
        # A value left over from an earlier run must never be read as this one's:
        # that is how a crashed run once got recorded as a 696 ms success.
        stale.unlink()
    for kind in KINDS:
        status, took, err = run_stage(prog, backend, kind, args.timeout)
        secs[kind] = took
        if status == "timeout":
            return "timeout", secs, "", err
        if status == EXIT_NO_TOOL:
            return "skip-no-tool", secs, "", err
        if status == EXIT_UNSUPPORTED:
            return "skip-unsupported", secs, "", err
        if status != 0:
            return f"{kind}-fail", secs, "", err
        if kind == "run" and args.repeat > 1:
            # Best-of: only the run stage is repeated -- gen and build are
            # deterministic and are what --repeat is meant to stop paying for.
            times = [took]
            for _ in range(args.repeat - 1):
                status, took, err = run_stage(prog, backend, kind, args.timeout)
                if status != 0:
                    return f"{kind}-fail", secs, "", err
                times.append(took)
            secs[kind] = min(times)
            if max(times) > 2 * min(times):
                warn(f"{prog.name}/{backend}: run times spread more than 2x "
                     f"({', '.join('%.1f' % t for t in times)} s) -- ball-park only")
    value = read_output(prog.outdir(backend))
    if prog.expected and value != prog.expected:
        return "wrong", secs, value, ""
    return "ok", secs, value, ""


def read_output(outdir):
    """The run stage writes the program's output, and nothing else, into
    output.txt (lib.sh's run_cmd_capture); read it as-is."""
    path = outdir / "output.txt"
    return normalize(path.read_text()) if path.exists() else ""


def check_of(prog, values):
    """What actually verified this program: an external value, the backends
    against each other, or nothing at all."""
    if prog.expected and values:
        return "expected"
    if len(values) > 1:
        return "differential"
    return "none"


def result_of(prog, statuses, values):
    """The one word the row reports, worst thing first, with the backend that
    caused it. A disagreement outranks a clean `ok` on every backend: it means
    one of them is wrong on a program no `expected` value covers, which is
    exactly the case the Rt.curry bug hid in."""
    bad = [f"{s}({b})" for b, s in statuses.items() if s in FAILED]
    if bad:
        # An xfail collapses a genuine failure, and ONLY that: a skip stays a
        # skip, and a `wrong` value on an xfail program is still reported as
        # wrong, because "known to fail to build" must not cover "started
        # answering something else".
        if prog.xfail and not any(s == "wrong" for s in statuses.values()):
            return "xfail"
        return " ".join(bad)
    if len(set(values.values())) > 1:
        return "disagree"
    if not values:
        skipped = [f"{s}({b})" for b, s in statuses.items() if s.startswith("skip")]
        return " ".join(skipped) if skipped else "no-backend"
    return "ok"


def seconds(value):
    """Ball-park, to a tenth. A sub-100 ms stage reads 0.0 on purpose: a number
    inviting precision it does not have is worse than a visible zero."""
    return "-" if value is None else f"{value:.1f}"


def append_row(row):
    new = not RESULTS.exists()
    with RESULTS.open("a") as fh:
        if new:
            fh.write("\t".join(COLUMNS) + "\n")
        fh.write("\t".join(row) + "\n")


def table(rows):
    """An aligned text table of the result rows -- formatted here rather than by
    `column -t`, where a value containing a tab silently shifts the row. The two
    value columns are clipped to keep the table readable; results.tsv has them
    in full."""
    def cell(column, row):
        text = row[column] or "-"
        return text if column not in ("output", "expected") or len(text) <= 22 \
            else text[:19] + "..."
    lines = [COLUMNS[1:]] + [[cell(c, r) for c in COLUMNS[1:]] for r in rows]
    widths = [max(len(line[i]) for line in lines) for i in range(len(COLUMNS) - 1)]
    return ["  ".join(c.ljust(w) for c, w in zip(line, widths)).rstrip() for line in lines]


def summary(rows, xfails):
    """Everything the run has to say: the table, then the recap. At the end
    rather than streamed -- the live per-program lines are progress (a java
    generation takes 30-60 s), this is the result."""
    print()
    for line in table(rows):
        print(line)

    failures = [r for r in rows if r["result"] not in ("ok", "xfail")
                and not r["result"].startswith("skip")]
    unchecked = [r["program"] for r in rows if r["check"] == "none"]
    print(f"\n{len(rows)} program(s), {len(failures)} failure(s) -> {RESULTS}")
    for row in failures:
        print(f"  {row['program']}: {row['result']}"
              + (f" (out={row['output']} expected={row['expected']})"
                 if row["result"].startswith(("wrong", "disagree")) else ""))
    for name, reason in xfails:
        print(f"  {name}: xfail -- {reason}")
    print(f"{len(unchecked)} of {len(rows)} programs have no oracle (check=none)"
          + (": " + " ".join(unchecked) if unchecked else ""))
    return failures


def info(msg):
    sys.stdout.flush()  # keep the result lines and the log in causal order
    print(f"[test] {msg}", file=sys.stderr)


def warn(msg):
    print(f"[test] WARNING: {msg}", file=sys.stderr)


def die(msg):
    print(f"[test] ERROR: {msg}", file=sys.stderr)
    sys.exit(1)


def parse_args(argv):
    p = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    p.add_argument("programs", nargs="*", metavar="PROGRAM",
                   help="the programs to run; none = list what there is")
    p.add_argument("--all", action="store_true", help="every program of every corpus")
    p.add_argument("--repeat", type=int, default=1, metavar="N",
                   help="run the RUN stage N times and keep the best (default: 1)")
    p.add_argument("--timeout", type=float, default=300.0, metavar="S",
                   help="per-stage timeout in seconds (default: %(default)s; java "
                        "generation takes 30-60 s on this corpus)")
    return p.parse_args(argv)


def main(argv=None):
    args = parse_args(argv)
    if args.repeat < 1:
        die("--repeat must be at least 1")

    programs = load_corpora()
    if not args.programs and not args.all:
        for prog in programs:
            print(f"{prog.name}\t{' '.join(prog.backends)}\t{prog.corpus}\t{prog.note}")
        return 0
    if args.all:
        selection = programs
    else:
        known = {p.name: p for p in programs}
        for name in args.programs:
            if name not in known:
                near = difflib.get_close_matches(name, known, n=3)
                die(f"no such program: {name}"
                    + (f" (did you mean {', '.join(near)}?)" if near else ""))
        selection = [known[n] for n in args.programs]

    stamp = datetime.now(timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ")
    info(f"{stamp}: {len(selection)} program(s)")
    rows, xfails = [], []

    for prog in selection:
        statuses, values, times = {}, {}, {}
        for backend in prog.backends:
            status, secs, value, err = run_backend(prog, backend, args)
            statuses[backend] = status
            times[backend] = secs
            if status in PRODUCED:
                values[backend] = value
            if status in FAILED and err.strip():
                info(f"{prog.name}/{backend} {status}, last diagnostics:\n"
                     + "\n".join(err.strip().splitlines()[-10:]))
        result = result_of(prog, statuses, values)
        if result == "xfail":
            xfails.append((prog.name, prog.xfail))
        row = ([stamp, prog.name, check_of(prog, values), result]
               + [seconds(times.get(b, {}).get(k)) for k in KINDS
                  for b in BACKEND_SCRIPT]
               + [next(iter(values.values()), ""), prog.expected])
        append_row(row)
        record = dict(zip(COLUMNS, row))
        rows.append(record)
        print("  ".join(f"{record[c]}" for c in ("program", "check", "result")), flush=True)

    failures = summary(rows, xfails)
    return 1 if failures else 0


if __name__ == "__main__":
    sys.exit(main())

#!/usr/bin/env bash
# check-case.sh <case> [backend...]
#
# The assertion the harness deliberately did not have. It does NOT run anything:
# it reads the output.txt files that run-<backend>.sh already left in
# work/<case>/<backend>/ and checks two things:
#
#   1. every backend agrees with every other one   (differential check)
#   2. they agree with the case's $EXPECTED, if it declares one   (oracle check)
#
# Splitting it out this way keeps the "run" scripts free of assertions -- they
# stay usable for eyeballing and benchmarking -- while making a corpus-wide
# verdict one command:
#
#   ./run-case.sh lean-qsort && ./check-case.sh lean-qsort
#
# Why (1) is worth having on its own: for the Lean cases the two backends
# implement the SAME λ□ axioms independently (ours in ToJava.ard's `javaAxioms` ->
# runtime/Rt.java, Lean's own in test/lean-ocaml-runtime), so agreement is
# evidence about the realizations, not just about the generator. And $EXPECTED
# comes from Lean's native compiler, i.e. from outside this project entirely.
#
# Exit status: 0 if all present outputs agree (and match $EXPECTED), 1 otherwise.
# A backend with no output.txt is reported as skipped, not as a failure, so
# checking a case only some of whose backends have been run is meaningful.
#
# Two deliberate limitations:
#
#   * `eval` is excluded by default ($CHECK_SKIP_BACKENDS). It does not print the
#     program's value but a rendered λ□ term plus its own compile chatter
#     (`constr Bool.true` where the compiled backends print `1`), so comparing it
#     as text would report a disagreement that is not one. Use it as an oracle by
#     reading it, not by diffing it.
#   * the outputs must come from ONE run of the case: they are files on disk, so
#     comparing a `java` output produced with one $MATMUL_SIZE against a `c` output
#     produced with another is a real mismatch in the files, not in the backends.
#     `run-all.sh` runs a case's backends back to back, which is the intended use.
set -uo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"
shift

backends=${*:-${BACKENDS-}}
[ -n "$backends" ] || die "case $CASE_NAME declares no BACKENDS"
: "${CHECK_SKIP_BACKENDS:=eval}"

status=0
ref="" ref_backend=""
for backend in $backends; do
  case " $CHECK_SKIP_BACKENDS " in
    *" $backend "*) info "$CASE_NAME/$backend: not comparable as text, skipped"; continue ;;
  esac
  out="$WORK_DIR/$CASE_NAME/$backend/output.txt"
  if [ ! -f "$out" ]; then
    info "$CASE_NAME/$backend: skipped (no output.txt -- run it first)"
    continue
  fi
  got=$(cat "$out")

  if [ -n "${EXPECTED-}" ] && [ "$got" != "$EXPECTED" ]; then
    warn "$CASE_NAME/$backend: expected '$EXPECTED', got '$got'"
    status=1
  fi

  if [ -z "$ref_backend" ]; then
    ref=$got ref_backend=$backend
  elif [ "$got" != "$ref" ]; then
    warn "$CASE_NAME: $backend and $ref_backend disagree ('$got' vs '$ref')"
    status=1
  fi
done

if [ -z "$ref_backend" ]; then
  info "$CASE_NAME: nothing to check"
elif [ $status -eq 0 ]; then
  info "$CASE_NAME: ok ($ref)${EXPECTED+ = expected}"
fi
exit $status

#!/usr/bin/env bash
# run-all.sh [case...]
#
# Runs every case (or the given ones) on every backend it declares, continues
# past failures, then prints the timing table and every backend's output.
set -uo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/config.sh"

cases=$*
if [ -z "$cases" ]; then
  for d in "$CASES_DIR"/*/; do cases="$cases $(basename "$d")"; done
fi

# Start from a clean table so the summary shows this run only.
mkdir -p "$WORK_DIR"
: >"$TIMINGS_TSV"

failed=""
for case_name in $cases; do
  for backend in $("$here/case-backends.sh" "$case_name"); do
    "$here/run-case.sh" "$case_name" "$backend" || failed="$failed $case_name/$backend"
  done
done

"$here/summary.sh" $cases

if [ -n "$failed" ]; then
  warn "failed:$failed"
  exit 1
fi

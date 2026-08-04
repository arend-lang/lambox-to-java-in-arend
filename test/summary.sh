#!/usr/bin/env bash
# summary.sh [case...]
#
# Prints the collected timings as an aligned table, then each case's note next
# to every backend's output, so the backends can be compared by eye. There are
# no assertions -- correctness is judged from what is printed here.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/config.sh"

cases=$*
if [ -z "$cases" ]; then
  for d in "$CASES_DIR"/*/; do cases="$cases $(basename "$d")"; done
fi

echo
echo "=== timings ==="
if [ -s "$TIMINGS_TSV" ]; then
  { printf 'case\tbackend\tstage\tms\n'; cat "$TIMINGS_TSV"; } | column -t -s "$(printf '\t')"
else
  echo "(no timings in $TIMINGS_TSV)"
fi

echo
echo "=== outputs ==="
for case_name in $cases; do
  note=$("$here/case-note.sh" "$case_name")
  echo
  echo "--- $case_name ${note:+($note)}"
  for out in "$WORK_DIR/$case_name"/*/output.txt; do
    [ -f "$out" ] || continue
    backend=$(basename "$(dirname "$out")")
    printf '%s:\n' "$backend"
    sed 's/^/  /' "$out"
  done
done

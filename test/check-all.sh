#!/usr/bin/env bash
# check-all.sh [case...]
#
# `check-case.sh` over every case (or the given ones) and one verdict line at the
# end. Runs nothing itself, so the intended sequence is
#
#   ./run-all.sh && ./check-all.sh
#
# and it is cheap to re-run on its own after inspecting a work directory.
set -uo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/config.sh"

cases=$*
if [ -z "$cases" ]; then
  for d in "$CASES_DIR"/*/; do cases="$cases $(basename "$d")"; done
fi

failed=""
for case_name in $cases; do
  "$here/check-case.sh" "$case_name" || failed="$failed $case_name"
done

if [ -n "$failed" ]; then
  warn "check failed:$failed"
  exit 1
fi
info "all checked cases agree"

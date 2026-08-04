#!/usr/bin/env bash
# run-case.sh <case> [backend...]
#
# Runs one case on the given backends, or on all backends the case declares
# ($BACKENDS). Each backend is just `run-<backend>.sh <case>`, so adding a
# backend needs no change here.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"
shift

backends=${*:-${BACKENDS-}}
[ -n "$backends" ] || die "case $CASE_NAME declares no BACKENDS"

for backend in $backends; do
  runner="$here/run-$backend.sh"
  [ -x "$runner" ] || die "no runner for backend '$backend' ($runner)"
  info "=== $CASE_NAME / $backend ==="
  "$runner" "$CASE_NAME"
done

if [ -n "${NOTE-}" ]; then info "$CASE_NAME: $NOTE"; fi

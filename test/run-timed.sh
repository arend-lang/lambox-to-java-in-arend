#!/usr/bin/env bash
# run-timed.sh <case> <backend> -- cmd...
#
# Runs the program, times it, prints its output and keeps a copy in
# work/<case>/<backend>/output.txt so the backends can be compared afterwards.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"
shift
backend=${1:?usage: run-timed.sh <case> <backend> -- cmd...}
shift
[ "${1-}" = "--" ] || die "run-timed.sh: expected -- before the command"
shift

dir=$(work_dir "$CASE_NAME" "$backend")

run_and_tee() { "$@" 2>&1 | tee "$dir/output.txt"; }

info "running $CASE_NAME/$backend: $*"
timed "$CASE_NAME" "$backend" run -- run_and_tee "$@"

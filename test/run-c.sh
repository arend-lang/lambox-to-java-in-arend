#!/usr/bin/env bash
# run-c.sh <case> -- build via Peregrine's C backend and run the binary.
#
# The driver prints the result of `body` as a primitive int: CertiRocq encodes a
# prim int n as the odd machine word 2n+1 (OCaml-style), hence the `>> 1` in
# main.c.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"

dir=$(work_dir "$CASE_NAME" c)

"$here/build-c.sh" "$CASE_NAME"
# See NATIVE_RUN_STACK in config.sh: the generated C recurses as deeply as the
# source program loops, exactly like the other backends.
(
  ulimit -s "$NATIVE_RUN_STACK" 2>/dev/null || warn "could not set stack limit to $NATIVE_RUN_STACK"
  "$here/run-timed.sh" "$CASE_NAME" c -- "$dir/prog"
)

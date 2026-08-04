#!/usr/bin/env bash
# run-ocaml.sh <case> -- build via Peregrine's OCaml backend and run the binary.
#
# ABI notes are in the case's prim_int63.ml: tPrim primInt is a plain OCaml int,
# and nullary inductive constructors are plain ints too (ordinal among nullary
# ctors only) -- only non-nullary ctors become real blocks.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"

dir=$(work_dir "$CASE_NAME" ocaml)

"$here/build-ocaml.sh" "$CASE_NAME"
"$here/run-timed.sh" "$CASE_NAME" ocaml -- "$dir/prog"

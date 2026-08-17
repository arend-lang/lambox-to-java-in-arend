#!/usr/bin/env bash
# build-c.sh <case>
#
# Compiles the case's lambda-box program through Peregrine's C backend:
#   AST_PRODUCER      -> prog.ast    (the serialized lambda-box program)
#   ATTR_C_PRODUCER   -> prog.attr   (realizes the primitive-op axioms on the
#                                     CertiRocq runtime's prim_int63_* funcs)
# prim_int63.c must be on the gcc line -- the default Peregrine test harness
# links only gc_stack.c.
#
# $C_DRIVER may be a bare name (taken from the case's own directory) or a path
# (`$LEAN_PEANO_DRIVERS/main.c`, shared by the axiom-free Lean cases); it is
# compiled from the work directory either way.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"

require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"
require_tool "$GCC"
[ -d "$CERTIROCQ_RT" ] || die "CertiRocq runtime not found: $CERTIROCQ_RT (set CERTIROCQ_RT)"
[ -n "${C_DRIVER-}" ] || die "case $CASE_NAME declares no C_DRIVER"

dir=$(work_dir "$CASE_NAME" c)
case $C_DRIVER in
  /*) cp "$C_DRIVER" "$dir/" ;;
  *)  cp "$CASE_DIR/$C_DRIVER" "$dir/" ;;
esac
driver_unit=${C_DRIVER##*/}

timed "$CASE_NAME" c extract     -- produce "${AST_PRODUCER-}"    "$dir/prog.ast"
timed "$CASE_NAME" c extract-attr -- produce "${ATTR_C_PRODUCER-}" "$dir/prog.attr"

timed "$CASE_NAME" c peregrine -- "$PEREGRINE" c \
  --attributes "$dir/prog.attr" -o "$dir/prog.c" "$dir/prog.ast"

timed "$CASE_NAME" c compile -- "$GCC" -o "$dir/prog" -w -O2 -fomit-frame-pointer \
  -I"$CERTIROCQ_RT" -I"$dir" \
  "$CERTIROCQ_RT/gc_stack.c" "$CERTIROCQ_RT/prim_int63.c" "$dir/prog.c" "$dir/$driver_unit"

#!/usr/bin/env bash
# build-ocaml.sh <case>
#
# Compiles the case's lambda-box program through Peregrine's OCaml (Malfunction)
# backend:
#   AST_PRODUCER        -> prog.ast              (shared with the C backend)
#   ATTR_OCAML_PRODUCER -> prog-ocaml.attr       (remaps the primitive-op axioms
#     onto the hand-written wrapper module Prim_int63; the OCaml backend only
#     consumes `reConstS` ("Module.value"), the rest of RemappedConstant is
#     ignored for this backend)
#
# The generated module is named after $OCAML_MODULE because the driver refers to
# it by name and the hand-written .mli must match: `malfunction cmx` produces no
# .cmi of its own, so the interface is compiled separately beforehand.
#
# A case may need more than a bare compiler: $OCAMLOPT is word-split, so it can
# be `ocamlfind ocamlopt`, with $OCAML_FLAGS added to every invocation and
# $OCAML_LINK_FLAGS only to the link step (`-package`/`-linkpkg`, as lean-deriv
# needs for Zarith).
#
# $OCAML_EXTRA is a list of supporting files compiled, in the given order, before
# the generated module. Each entry may be a bare name (taken from the case's own
# directory) or a path (`$LEAN_OCAML_RT/nat.ml` for the shared Lean realizations,
# see lean-ocaml-runtime/README.md); only its basename matters afterwards, since
# ocamlopt derives the module name from the file name.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"

require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"
read -r -a ocamlopt <<<"$OCAMLOPT ${OCAML_FLAGS-}"
require_tool "${ocamlopt[0]}"
require_tool "$MALFUNCTION" "comes from the opam switch peregrine was built in; set OPAM_SWITCH_BIN or MALFUNCTION"
[ -n "${OCAML_DRIVER-}" ] || die "case $CASE_NAME declares no OCAML_DRIVER"
[ -n "${OCAML_MODULE-}" ] || die "case $CASE_NAME declares no OCAML_MODULE"

dir=$(work_dir "$CASE_NAME" ocaml)
# A relative entry is resolved against the case directory, an absolute one taken
# as is; both end up in the work dir under their basename.
copy_unit() { case $1 in /*) cp "$1" "$dir/" ;; *) cp "$CASE_DIR/$1" "$dir/" ;; esac; }
extra_units=""
for f in ${OCAML_EXTRA-}; do copy_unit "$f"; extra_units="$extra_units ${f##*/}"; done
copy_unit "$OCAML_DRIVER"
driver_unit=${OCAML_DRIVER##*/}

timed "$CASE_NAME" ocaml extract      -- produce "${AST_PRODUCER-}"         "$dir/prog.ast"
timed "$CASE_NAME" ocaml extract-attr -- produce "${ATTR_OCAML_PRODUCER-}" "$dir/prog-ocaml.attr"

timed "$CASE_NAME" ocaml peregrine -- "$PEREGRINE" ocaml \
  --attributes "$dir/prog-ocaml.attr" -o "$dir/$OCAML_MODULE.mlf" "$dir/prog.ast"

# Everything below runs inside the work dir: ocamlopt/malfunction derive module
# names from file names and drop their artifacts next to the sources.
link_units=""
for f in $extra_units; do
  case $f in *.ml) link_units="$link_units ${f%.ml}.cmx" ;; esac
done

build_ocaml() (
  cd "$dir"
  for f in $extra_units; do "${ocamlopt[@]}" -c "$f"; done
  "$MALFUNCTION" cmx "$OCAML_MODULE.mlf"
  "${ocamlopt[@]}" -c "$driver_unit"
  "${ocamlopt[@]}" ${OCAML_LINK_FLAGS-} -o prog $link_units "$OCAML_MODULE.cmx" "${driver_unit%.ml}.cmx"
)

timed "$CASE_NAME" ocaml compile -- build_ocaml

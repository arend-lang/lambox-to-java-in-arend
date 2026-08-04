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
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"

require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"
require_tool "$OCAMLOPT"
require_tool "$MALFUNCTION" "comes from the opam switch peregrine was built in; set OPAM_SWITCH_BIN or MALFUNCTION"
[ -n "${OCAML_DRIVER-}" ] || die "case $CASE_NAME declares no OCAML_DRIVER"
[ -n "${OCAML_MODULE-}" ] || die "case $CASE_NAME declares no OCAML_MODULE"

dir=$(work_dir "$CASE_NAME" ocaml)
for f in ${OCAML_EXTRA-} "$OCAML_DRIVER"; do cp "$CASE_DIR/$f" "$dir/"; done

timed "$CASE_NAME" ocaml extract      -- produce "${AST_PRODUCER-}"         "$dir/prog.ast"
timed "$CASE_NAME" ocaml extract-attr -- produce "${ATTR_OCAML_PRODUCER-}" "$dir/prog-ocaml.attr"

timed "$CASE_NAME" ocaml peregrine -- "$PEREGRINE" ocaml \
  --attributes "$dir/prog-ocaml.attr" -o "$dir/$OCAML_MODULE.mlf" "$dir/prog.ast"

# Everything below runs inside the work dir: ocamlopt/malfunction derive module
# names from file names and drop their artifacts next to the sources.
link_units=""
for f in ${OCAML_EXTRA-}; do
  case $f in *.ml) link_units="$link_units ${f%.ml}.cmx" ;; esac
done

build_ocaml() (
  cd "$dir"
  for f in ${OCAML_EXTRA-}; do "$OCAMLOPT" -c "$f"; done
  "$MALFUNCTION" cmx "$OCAML_MODULE.mlf"
  "$OCAMLOPT" -c "$OCAML_DRIVER"
  "$OCAMLOPT" -o prog $link_units "$OCAML_MODULE.cmx" "${OCAML_DRIVER%.ml}.cmx"
)

timed "$CASE_NAME" ocaml compile -- build_ocaml

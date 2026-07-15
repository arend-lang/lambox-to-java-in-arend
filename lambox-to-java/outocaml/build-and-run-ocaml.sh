#!/usr/bin/env bash
# Build & run the 130x130 matmul lambda-box program via Peregrine's OCaml
# (Malfunction) backend.
#
# Inputs (regenerate by typechecking the Arend project; `ser` prints the
# .ast line, `attrsOCaml` the .attr line -- needs a big JVM stack):
#   cd .. && ~/.jdks/openjdk-26.0.1/bin/java -Xss512m \
#     -jar ~/Arend/cli/build/libs/cli-1.11.0-full.jar arend.yaml
#   -> save "(Untyped ...sumRes..." as out/matmul.ast (shared with the C build)
#   -> save "(attributes_config ...Prim_int63..." as out/matmul-ocaml.attr
#
# matmul-ocaml.attr remaps the 4 primitive-op axioms onto a hand-written
# wrapper module Prim_int63 (prim_int63.ml/.mli in this dir) -- the OCaml
# backend only consumes `reConstS` ("Module.value"), everything else in
# RemappedConstant is ignored for this backend.
#
# ABI notes baked into prim_int63.ml (see its comments): tPrim primInt is a
# plain OCaml int; nullary inductive constructors (BoolBlock/ListBlock's
# nil) are ALSO plain ints (ordinal among nullary ctors only), not blocks --
# only non-nullary ctors (List's cons) become real blocks. Verified by
# inspecting `malfunction fmt < matmul.mlf`'s generated switches.
set -euo pipefail
cd "$(dirname "$0")"

PEREGRINE=~/peregrine-tool/_build/install/default/bin/peregrine

$PEREGRINE ocaml --attributes matmul-ocaml.attr -o matmul.mlf ../out/matmul.ast
ocamlopt -c prim_int63.mli prim_int63.ml
ocamlopt -c matmul.mli          # hand-written; malfunction cmx produces no .cmi
malfunction cmx matmul.mlf
ocamlopt -c matmul_main.ml
ocamlopt -o matmul_ocaml prim_int63.cmx matmul.cmx matmul_main.cmx

echo "expected: 2197000 (= 130^3)"
time ./matmul_ocaml

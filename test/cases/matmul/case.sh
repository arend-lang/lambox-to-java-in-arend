#!/usr/bin/env bash
# 130x130 matrix multiplication over primitive 63-bit ints
# (ExampleMatMul.matMulProgram). Declarations only, no logic.
#
# The C and OCaml backends need per-backend attribute files realizing the four
# primitive-op axioms: for C on the CertiRocq runtime's prim_int63_{add,mul,
# sub,eqb}, for OCaml on the hand-written Prim_int63 wrapper module.

BACKENDS="java c ocaml"
JAVA_PRODUCER="extract-arend ExamplePrint:matMulJava"
AST_PRODUCER="extract-arend ExamplePrint:matMulSexpr"
ATTR_C_PRODUCER="extract-arend ExamplePrint:matMulAttrsCText"
ATTR_OCAML_PRODUCER="extract-arend ExamplePrint:matMulAttrsOCamlText"
C_DRIVER=main.c
OCAML_DRIVER=matmul_main.ml
# Module name of the generated OCaml/Malfunction code; matmul_main.ml refers to
# it and matmul.mli is its hand-written interface, so the three must agree.
OCAML_MODULE=matmul
OCAML_EXTRA="prim_int63.mli prim_int63.ml matmul.mli"
NOTE="expected: 2197000 (= 130^3)"

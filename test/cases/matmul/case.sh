#!/usr/bin/env bash
# 130x130 matrix multiplication over primitive 63-bit ints
# (ExampleMatMul.matMulProgram). Declarations only, no logic.
#
# The C and OCaml backends need per-backend attribute files realizing the four
# primitive-op axioms: for C on the CertiRocq runtime's prim_int63_{add,mul,
# sub,eqb}, for OCaml on the hand-written Prim_int63 wrapper module.

BACKENDS="java c ocaml"
# $JAVA_DEF_SUFFIX comes from config.sh's JAVA_INT: empty for the default
# program (Java's built-in 64-bit integers), "BigInteger" for the unbounded one.
JAVA_PRODUCER="extract-arend ExamplePrint:matMulJava$JAVA_DEF_SUFFIX"
AST_PRODUCER="extract-arend ExamplePrint:matMulSexpr"
ATTR_C_PRODUCER="extract-arend ExamplePrint:matMulAttrsCText"
ATTR_OCAML_PRODUCER="extract-arend ExamplePrint:matMulAttrsOCamlText"
C_DRIVER=main.c
OCAML_DRIVER=matmul_main.ml
# Module name of the generated OCaml/Malfunction code; matmul_main.ml refers to
# it and matmul.mli is its hand-written interface, so the three must agree.
OCAML_MODULE=matmul
OCAML_EXTRA="prim_int63.mli prim_int63.ml matmul.mli"
# All three backends agree here only because 130^3 stays far below 2^62: C/OCaml
# implement genuine int63 (wrapping mod 2^63), the Java backend 64-bit long (or
# BigInteger). See "Integer representation of the Java backend" in ../../README.md.
NOTE="expected: 2197000 (= 130^3); backends agree only well below 2^62 (int63 mismatch)"

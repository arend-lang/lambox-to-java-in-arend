#!/usr/bin/env bash
# Runtime bundle `int63`: the drivers for a program computing over λ□ PRIMITIVE
# 63-bit integers, whose four primitive-op axioms (prim_{add,mul,sub,eqb}_int)
# are remapped by the program's attribute files onto native symbols --
#   C:     the CertiRocq runtime's prim_int63_{add,mul,sub,eqb} (prog-c.attr)
#   OCaml: the hand-written wrapper module Prim_int63 below   (prog.attr)
# which is why a program using this bundle ships two attribute files while every
# other program ships one.
#
# Assignments only -- no logic, no producers. A stage script sources this file
# and resolves every file name below against this directory.
#
# This is the one bundle where the `long`-vs-`int63` gap is observable: C and
# OCaml implement genuine int63 (wrapping mod 2^63), our Java backend a 64-bit
# `long`, so the three agree only well below 2^62.
OCAML_MODULE=matmul
OCAML_DRIVER=matmul_main.ml
# prim_int63.mli/ml realize the remapped axioms; matmul.mli types the generated
# module, since `malfunction cmx` emits no .cmi of its own.
OCAML_EXTRA="prim_int63.mli prim_int63.ml matmul.mli"

OCAMLOPT=ocamlopt
OCAML_FLAGS=
OCAML_LINK_FLAGS=

C_DRIVER=main.c

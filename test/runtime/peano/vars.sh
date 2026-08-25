#!/usr/bin/env bash
# Runtime bundle `peano`: the drivers for an axiom-free ("Peano") Lean program,
# i.e. one erased with `config { nat := .peano, extern := .preferLogical }` so
# that Lean's `Nat` stays an inductive type and its arithmetic comes from the
# logical definitions instead of from @[extern] axioms.
#
# Assignments only -- no logic, no producers. A stage script sources this file
# and resolves every file name below against this directory.
#
# This is the only shape of Lean program `peregrine c` will touch (see
# README.md), which is why the bundle carries a C driver as well as an OCaml one
# and why these programs are the corpus' only cross-backend Lean comparison.
#
# Every such program returns a Lean `Bool`, on purpose: a unary 8000 is an
# 8000-deep term and every backend renders a value with per-level indentation,
# so printing the number itself would cost more than computing it. As a `Bool`
# both drivers print the constructor's ordinal among the nullary constructors of
# `false | true`, i.e. the expected 1.
OCAML_MODULE=bench
OCAML_DRIVER=bench_main.ml
OCAML_EXTRA="bench.mli"

# No Zarith here: the naturals are ordinary constructor data.
OCAMLOPT=ocamlopt
OCAML_FLAGS=
OCAML_LINK_FLAGS=

C_DRIVER=main.c

#!/usr/bin/env bash
# regen-arend-asts.sh [program...]
#
# Refreshes the checked-in `prog.ast` of the three AREND-AUTHORED programs.
#
# Every program in the corpus is a λ□ s-expression file -- that is the single
# program input shape of the harness, so `example`, `peano` and `matmul`, whose
# source is a hand-written `LBTerm` in the Arend project rather than a file from
# Lean or Rocq, need their term serialized once and committed. This script is the
# only producer of those files; the harness itself never runs Arend to obtain a
# program, only to compile one.
#
# The round trip that makes this legitimate -- serialize with `Serialize.ard`,
# read back with `tools/ast-to-arend`, compile, and get the same output as
# compiling the original term -- is what the retired `peano-ast` and `matmul-ast`
# cases used to check by hand. Running it on every program instead of on two is
# an improvement, not a loss: `Serialize` and the importer are now on the path of
# all three.
#
# Cost: one Arend CLI run per program, ~40 s each (library loading dominates), so
# this is a rare, manual step -- never part of a `run.py` run.
#
# `matmul` additionally needs its two attribute files, which are extracted from
# the same Arend module and are refreshed here as well. They are four fixed
# declarations independent of the matrix size, which is why they are checked in
# rather than re-extracted per run.
set -euo pipefail

TOOLS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$TOOLS_DIR/../lib.sh"

HANDWRITTEN="$CORPORA_DIR/handwritten"

# program -> the ExamplePrint definition that prints its serialized λ□ term.
sexpr_def() {
  case $1 in
    example) printf 'ExamplePrint:exampleSexpr\n' ;;
    peano)   printf 'ExamplePrint:peanoSexpr\n' ;;
    matmul)  printf 'ExamplePrint:matMulSexpr\n' ;;
    *)       die "no Arend source for program: $1 (regenerable: example peano matmul)" ;;
  esac
}

regen() {
  local prog=$1 dir="$HANDWRITTEN/$prog"
  [ -d "$dir" ] || die "no such program directory: $dir"
  info "regenerating $prog/prog.ast from $(sexpr_def "$prog")"
  "$TOOLS_DIR/extract-arend.sh" "$(sexpr_def "$prog")" "$dir/prog.ast"
  if [ "$prog" = matmul ]; then
    # Two files, because the two backends remap the four primitive-op axioms
    # onto different native symbols; see runtime/int63/README.md.
    "$TOOLS_DIR/extract-arend.sh" ExamplePrint:matMulAttrsCText     "$dir/prog-c.attr"
    "$TOOLS_DIR/extract-arend.sh" ExamplePrint:matMulAttrsOCamlText "$dir/prog.attr"
  fi
}

if [ $# -gt 0 ]; then
  for prog in "$@"; do regen "$prog"; done
else
  for prog in example peano matmul; do regen "$prog"; done
fi

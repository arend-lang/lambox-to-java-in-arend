#!/usr/bin/env bash
# 130x130 matrix multiplication, as the `matmul` case, but with the matrix size
# as a knob so the SAME λ□ program can be run at several problem sizes:
#
#   MATMUL_SIZE=200 test/bench.sh matmul-bench
#
# Everything else is what makes this case a fair cross-backend comparison:
#
#   * every backend consumes the very same prog.ast (a copy of the `matmul`
#     case's serialized program). The `matmul` case instead feeds Java from a
#     hand-written Arend term and only the C/OCaml backends from the .ast, so a
#     difference there could always be a difference between two sources.
#   * the attribute files are CHECKED IN rather than extracted from Arend. They
#     are four fixed declarations, independent of the size, and each extraction
#     costs ~36 s of Arend startup -- which would dominate the measurement.
#
# The size literal occurs four times in prog.ast (randVec, randMat and the two
# dimension arguments of `res`) and nowhere else does the literal 130 appear, so
# the substitution below is exactly "set SIZE".

# Sourced, so this runs before any backend starts: the scaled program must exist
# before a producer is evaluated, and generating it is a sed over 5 KB.
: "${MATMUL_SIZE:=130}"
BENCH_AST="$WORK_DIR/matmul-bench/prog-$MATMUL_SIZE.ast"
mkdir -p "$(dirname "$BENCH_AST")"
sed "s/primInt 130/primInt $MATMUL_SIZE/g" "$CASE_DIR/prog.ast" >"$BENCH_AST"

# No `eval` backend: the program's four prim_*_int axioms are realized by
# NATIVE C/OCaml symbols, which Peregrine's evaluator has no implementation for
# (see run-eval.sh). The peano variant of this workload is what eval can run.
BACKENDS="java c ocaml"

AST_PRODUCER="cat $BENCH_AST"
JAVA_PRODUCER="import-ast $BENCH_AST MatmulBench && extract-arend Imported.MatmulBench:progJava$JAVA_DEF_SUFFIX"
ATTR_C_PRODUCER="cat $CASE_DIR/prog-c.attr"
ATTR_OCAML_PRODUCER="cat $CASE_DIR/prog-ocaml.attr"
C_DRIVER=main.c
OCAML_DRIVER=matmul_main.ml
OCAML_MODULE=matmul
OCAML_EXTRA="prim_int63.mli prim_int63.ml matmul.mli"
EXPECTED=$((MATMUL_SIZE * MATMUL_SIZE * MATMUL_SIZE))
NOTE="expected: $EXPECTED (= $MATMUL_SIZE^3); backends agree only well below 2^62 (int63 mismatch)"

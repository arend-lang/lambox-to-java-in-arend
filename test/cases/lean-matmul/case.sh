#!/usr/bin/env bash
# 130x130 all-ones matrix multiplication and result summation, written in Lean
# and extracted by lean-to-lambdabox. The checked-in prog.lean is the source;
# prog.ast is its generated, otherwise unmodified λ□ output.

BACKENDS="java"
AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast LeanMatmul && extract-arend Imported.LeanMatmul:progJava$JAVA_DEF_SUFFIX"
NOTE="expected: 2197000 (= 130^3), independently extracted from Lean"
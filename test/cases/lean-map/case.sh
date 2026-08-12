#!/usr/bin/env bash
# Upstream Peregrine lean-to-lambdabox test/lean/src/Map.lean, revision
# 247d495638667cb855f43855775c6feb462e8121. Only the #erase output path is
# adapted so the checked-in source regenerates this case's prog.ast.

BACKENDS="java"
AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast LeanMap && extract-arend Imported.LeanMap:progJava$JAVA_DEF_SUFFIX"
NOTE="expected: Peano list [2, 6, 10], official Peregrine Lean Map test"

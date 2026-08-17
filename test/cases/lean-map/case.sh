#!/usr/bin/env bash
# Upstream Peregrine lean-to-lambdabox test/lean/src/Map.lean, revision
# 247d495638667cb855f43855775c6feb462e8121. Only the #erase output path is
# adapted so the checked-in source regenerates this case's prog.ast.

# The program is axiom-free and its .ast is checked in, so Peregrine's evaluator
# runs it for free (no extraction, no attributes) and acts as a reference
# semantics. It is not text-comparable (`constr List_.cons ...` against our
# `1(...)`), so check-case.sh skips it; the structures are compared by eye.
# No C: the result is constructor data, and the C driver can only print a
# primitive int (see lean-peano-drivers/README.md).
BACKENDS="java eval"
AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast LeanMap && extract-arend Imported.LeanMap:progJava$JAVA_DEF_SUFFIX"
NOTE="expected: Peano list [2, 6, 10], official Peregrine Lean Map test"

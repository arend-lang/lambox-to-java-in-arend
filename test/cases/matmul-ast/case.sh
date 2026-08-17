#!/usr/bin/env bash
# 130x130 matrix multiplication, taken from an EXTERNAL λ□ file (prog.ast)
# instead of a hand-written Arend LBTerm: `import-ast` rebuilds it as an Arend
# module (Imported.MatmulAst), which is then compiled as usual.
#
# prog.ast is the file the `matmul` case hands to Peregrine, i.e. real
# Peregrine input, exercising every construct the C backend sees: tFix, tCase
# with several branches, tPrim, curried tConstruct (cstr_as_blocks = false) and
# body-less constant declarations for the four primitive-op axioms. import-ast
# normalizes the constructors through Peregrine's `ast box` before translation.
#
# Only the java backend: the C/OCaml ones would need this case's own copies of
# matmul's attribute files and drivers, and the `matmul` case already covers
# them for the very same program.

BACKENDS="java"
AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast MatmulAst && extract-arend Imported.MatmulAst:progJava$JAVA_DEF_SUFFIX"
EXPECTED=2197000
NOTE="expected: $EXPECTED (= 130^3), identical to the 'matmul' case"

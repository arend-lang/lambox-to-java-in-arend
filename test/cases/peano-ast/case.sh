#!/usr/bin/env bash
# Peano addition, but taken from an EXTERNAL λ□ file (prog.ast) instead of a
# hand-written Arend LBTerm: `import-ast` first runs Peregrine's `ast box`, then
# turns the normalized s-expression into Imported.PeanoAst for compilation.
#
# prog.ast here was produced by our own serializer
# (`extract-arend.sh ExamplePrint:peanoSexpr`), so this case is a ROUND TRIP:
# it must print exactly what the `peano` case prints, which makes it a test of
# the importer against Serialize.ard rather than of the compiler.

# `eval` costs nothing here (the .ast is checked in, the program is axiom-free)
# and makes Peregrine's evaluator a reference semantics for the same file. Its
# output is not text-comparable (`constr suc ...` against our `1(...)`), so
# check-case.sh skips it; the structure is compared by eye. No C/OCaml: the
# result is constructor data and both drivers print a primitive int only.
BACKENDS="java eval"
AST_PRODUCER="cat $CASE_DIR/prog.ast"
# The import step prints nothing on stdout, so it chains in front of the
# extraction; $JAVA_DEF_SUFFIX comes from config.sh's JAVA_INT
# (empty/"BigInteger").
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast PeanoAst && extract-arend Imported.PeanoAst:progJava$JAVA_DEF_SUFFIX"
NOTE="expected: 1(1(1(1(0)))), identical to the 'peano' case (importer round trip)"

#!/usr/bin/env bash
# Peano addition, but taken from an EXTERNAL λ□ file (prog.ast) instead of a
# hand-written Arend LBTerm: `import-ast` first runs Peregrine's `ast box`, then
# turns the normalized s-expression into Imported.PeanoAst for compilation.
#
# prog.ast here was produced by our own serializer
# (`extract-arend.sh ExamplePrint:peanoSexpr`), so this case is a ROUND TRIP:
# it must print exactly what the `peano` case prints, which makes it a test of
# the importer against Serialize.ard rather than of the compiler.

BACKENDS="java"
AST_PRODUCER="cat $CASE_DIR/prog.ast"
# The import step prints nothing on stdout, so it chains in front of the
# extraction; $JAVA_DEF_SUFFIX comes from config.sh's JAVA_INT
# (empty/"BigInteger").
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast PeanoAst && extract-arend Imported.PeanoAst:progJava$JAVA_DEF_SUFFIX"
NOTE="expected: 1(1(1(1(0)))), identical to the 'peano' case (importer round trip)"

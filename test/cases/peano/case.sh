#!/usr/bin/env bash
# Peano addition (ExamplePeano.addProgram): 1 + 3 on unary naturals.
# Declarations only, no logic.

BACKENDS="java"
JAVA_PRODUCER="extract-arend ExamplePrint:peanoJava"
AST_PRODUCER="extract-arend ExamplePrint:peanoSexpr"
# No C/OCaml drivers yet: the result is constructor data, not a primitive int.
NOTE="expected: 1+3 = suc^4 zero, i.e. 1(1(1(1(0))))"

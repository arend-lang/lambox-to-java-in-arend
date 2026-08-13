#!/usr/bin/env bash
# The introductory example program (Example.testProgram).
# Declarations only, no logic.

BACKENDS="java"
# $JAVA_DEF_SUFFIX comes from config.sh's JAVA_INT: empty for the default
# 64-bit-long program, "BigInteger" for the unbounded variant of the same one.
JAVA_PRODUCER="extract-arend ExamplePrint:exampleJava$JAVA_DEF_SUFFIX"
AST_PRODUCER="extract-arend ExamplePrint:exampleSexpr"
# No C/OCaml drivers yet: the result is constructor data, not a primitive int.
NOTE="expected: succ (succ zero), i.e. 1(1(0))"

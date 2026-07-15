#!/usr/bin/env bash
# Build & run the 130x130 matmul lambda-box program via Peregrine's C backend.
#
# Inputs (regenerate by typechecking the Arend project; `ser` prints the .ast
# line, `attrs` the .attr line -- needs a big JVM stack for the meta):
#   cd .. && ~/.jdks/openjdk-26.0.1/bin/java -Xss512m \
#     -jar ~/Arend/cli/build/libs/cli-1.11.0-full.jar arend.yaml
#   -> save the "(Untyped ...sumRes..." line as out/matmul.ast
#   -> save the "(attributes_config ..." line as out/matmul.attr
#
# matmul.attr realizes the 4 primitive-op axioms as the CertiRocq runtime's
# prim_int63_{add,mul,sub,eqb}; prim_int63.c must be on the gcc line (the
# default Peregrine test harness links only gc_stack.c).
set -euo pipefail
cd "$(dirname "$0")"

PEREGRINE=~/peregrine-tool/_build/install/default/bin/peregrine
RT=~/.opam/peregrine/lib/coq/user-contrib/CertiRocq/Plugin/runtime

$PEREGRINE c --attributes matmul.attr -o matmul.c ../out/matmul.ast
gcc -o matmul -w -O2 -fomit-frame-pointer -I"$RT" -I. \
    "$RT/gc_stack.c" "$RT/prim_int63.c" matmul.c main.c

echo "expected: 2197000 (= 130^3)"
time ./matmul

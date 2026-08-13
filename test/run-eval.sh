#!/usr/bin/env bash
# run-eval.sh <case> -- evaluate the case's lambda-box program with Peregrine's
# own evaluator (`peregrine eval`), i.e. no code generation at all.
#
# This is a REFERENCE backend, not a compiled one: it exists so a case's value
# can be obtained from Peregrine's verified pipeline plus an interpreter, and
# compared against what our generated Java prints. Two consequences:
#
#   * it prints values structurally (`constr suc ...`), not through a driver, so
#     its output format differs from every compiled backend's -- compare values,
#     not text;
#   * it cannot run a program with unrealized axioms. `--attributes` remaps an
#     axiom onto a NATIVE symbol of the C/OCaml runtime, which the evaluator has
#     no implementation for, so a program using our `prim_*_int` axioms fails
#     with `Eprim: prim not found` (ANF evaluator) or `TConst;ecTyp` (the direct
#     one). Only axiom-free programs can be evaluated.
#
# EVAL_FUEL bounds the number of steps; EVAL_ANF selects the evaluator
# (`true` = the ANF one, Peregrine's default; `false` = the direct λ□ one).
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$here/load-case.sh" "$@"

require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"

dir=$(work_dir "$CASE_NAME" eval)

timed "$CASE_NAME" eval extract -- produce "${AST_PRODUCER-}" "$dir/prog.ast"

"$here/run-timed.sh" "$CASE_NAME" eval -- \
  "$PEREGRINE" eval --anf "$EVAL_ANF" --fuel "$EVAL_FUEL" "$dir/prog.ast"

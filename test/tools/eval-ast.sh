#!/usr/bin/env bash
# eval-ast.sh <prog.ast|program> [peregrine-eval-flags...]
#
# Runs a λ□ program through Peregrine's OWN evaluator (`peregrine eval`), i.e.
# with no code generation at all, and prints the term it reduces to.
#
#   tools/eval-ast.sh lean-map                       # a program of the corpus
#   tools/eval-ast.sh corpora/handwritten/peano/prog.ast
#   tools/eval-ast.sh lean-map --fuel 100000000 --anf false
#
# This is a DEBUGGING TOOL, not a backend, and deliberately unknown to run.py:
# `eval` left the matrix because its output is a rendered λ□ term
# (`constr List_.cons ...`) rather than a value comparable with what a compiled
# backend prints, and normalizing the two shapes is a deferred decision. What it
# still buys is a second opinion from a verified pipeline when our generated Java
# prints something suspicious -- so the capability is kept here, one script, run
# by hand.
#
# Two limits, both worth knowing before trusting an answer:
#
#   * It cannot run a program with AXIOMS. `--attributes` remaps an axiom onto a
#     native C/OCaml symbol the evaluator has no implementation for, so the
#     `matmul` family fails with `Eprim: prim not found` (ANF evaluator) or
#     `wcbvEval;TConst;ecTyp: .prim_add_int` (`--anf false`). Only the axiom-free
#     programs -- the `peano` ones, `lean-map`, `peano`, `example` -- can be
#     evaluated. No attribute file is passed for that reason.
#   * `--fuel` is a Rocq UNARY `nat` allocated up front, ~16 bytes per unit: on a
#     trivial program, fuel 1e6/1e7/1e8/1e9 costs 0.03/0.45/4.6/222 s and up to
#     1.6 GB *before evaluation starts*, hence the modest default below. Worse,
#     exhausted fuel is NOT an error: the evaluator prints the residual ANF
#     program, which looks like a result. Check the shape (`constr ...`) before
#     believing an answer.
#
# EVAL_FUEL and EVAL_ANF below are the defaults (`true` = the ANF evaluator,
# Peregrine's default; `false` = the direct λ□ one); pass `--fuel`/`--anf`
# again as a trailing flag to override one for a single run, since any extra
# flag is passed through to `peregrine eval` verbatim.
set -euo pipefail

TOOLS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$TOOLS_DIR/../lib.sh"

EVAL_FUEL=10000000
EVAL_ANF=true

[ $# -ge 1 ] || die "usage: eval-ast.sh <prog.ast|program> [peregrine-eval-flags...]"
ast=$1
shift

# A bare name is resolved as a program of the handwritten corpus, so that this
# reads like a run.py --program argument; anything else is taken as a path.
if [ ! -f "$ast" ] && [ -f "$CORPORA_DIR/handwritten/$ast/prog.ast" ]; then
  ast="$CORPORA_DIR/handwritten/$ast/prog.ast"
fi
[ -f "$ast" ] || die "no such .ast file or corpus program: $ast"
require_tool "$PEREGRINE" "set PEREGRINE to the peregrine binary"

info "+ $PEREGRINE eval --anf $EVAL_ANF --fuel $EVAL_FUEL $* $ast"
exec "$PEREGRINE" eval --anf "$EVAL_ANF" --fuel "$EVAL_FUEL" "$@" "$ast"

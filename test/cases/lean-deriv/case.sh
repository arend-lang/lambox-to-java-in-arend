#!/usr/bin/env bash
# `deriv` from Lean 4's own code-generator benchmarks, as shipped by
# lean-to-lambdabox (benchmarks/FromLeanCommon/deriv.lean, revision 58701f8):
# symbolic differentiation of `x^x` nested 10 times, then counting the nodes of
# the result. NOT one of our programs -- `deriv.lean` is a verbatim copy and
# `prog.ast` is its unmodified λ□ output; `prog.lean` only closes it over the
# input (10) the benchmark manifest uses.
#
# It is the heaviest program our pipeline handles: it is the one case in the
# whole Lean corpus that costs minutes rather than seconds, both to compile and
# to run, which is why it is worth pinning as a case of its own instead of
# leaving it inside run-lean-benchmark-suite.sh.
#
# The 13 Lean primitives it leaves as axioms are what makes it interesting
# across backends:
#
#   * our Java realizes them in the runtime (`javaAxioms` in ToJava.ard ->
#     runtime/Rt.java), so the `java` backend needs no attributes at all;
#   * Peregrine's OCaml backend compiles an unrealized axiom to
#     `(global $Axioms $def__Nat_add)`, i.e. it expects a module named `Axioms`
#     -- also no attribute entry. The realizations are lean-to-lambdabox's own
#     (`nat.ml`, `int.ml`, `decidable.ml`, `eq.ml`, copied verbatim; `axioms.ml`
#     is trimmed to those since this program uses no Lean `Array`). They are
#     Zarith-based, hence the ocamlfind flags below;
#   * there is NO `c` backend here: `peregrine c` rejects the program outright
#     ("Axioms found, use Extract Constant to realize them in C"), and nobody
#     upstream has written C realizations -- they would have to allocate
#     (`Decidable`) through the CertiRocq GC. That is a real gap, not an
#     oversight of this case.
#   * `eval` cannot run it either, for the usual reason: the evaluator has no
#     implementation for a remapped native symbol (see run-eval.sh).
BACKENDS="java ocaml"

AST_PRODUCER="cat $CASE_DIR/prog.ast"
JAVA_PRODUCER="import-ast $CASE_DIR/prog.ast LeanDeriv && extract-arend Imported.LeanDeriv:progJava$JAVA_DEF_SUFFIX"
# Empty: every axiom is resolved by name (above), not by remapping.
ATTR_OCAML_PRODUCER="cat $CASE_DIR/prog.attr"
OCAML_DRIVER=deriv_main.ml
OCAML_MODULE=deriv
OCAML_EXTRA="decidable.mli decidable.ml eq.mli eq.ml nat.mli nat.ml int.mli int.ml axioms.mli axioms.ml deriv.mli"
# The realizations use Zarith, so the compiler must be ocamlfind's wrapper.
OCAMLOPT="ocamlfind ocamlopt"
OCAML_FLAGS="-package zarith"
OCAML_LINK_FLAGS="-linkpkg"
EXPECTED=40230090
NOTE="expected: $EXPECTED; upstream Lean benchmark, ~9 s in Java vs ~7 s in OCaml"

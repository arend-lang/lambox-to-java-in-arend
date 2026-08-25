-- Extraction driver for the `qsort` benchmark. `qsort.lean` next to this file
-- is a verbatim copy of lean-to-lambdabox's
-- benchmarks/FromLeanCommon/qsort.lean (revision 58701f8); this file only
-- closes it over an input and asks for the OCaml interface as well.
--
-- Regenerate prog.ast / bench.mli (both are otherwise unmodified):
--   cp prog.lean $HOME/lean-to-lambdabox/Gen.lean
--   cd $HOME/lean-to-lambdabox && LEAN_PATH=$PWD/benchmarks/.lake/build/lib/lean \
--     $HOME/.elan/bin/lake env lean Gen.lean
--   cp $HOME/lean-to-lambdabox/{prog.ast,bench.mli} <this directory>
--
-- The input below is SMALLER than the one in upstream's manifest
-- (benchmarks/TESTS), so that one run costs seconds rather than minutes; see
-- case.sh. After changing it, recompute EXPECTED with Lean's native compiler
-- (benchmarks/via_lean, `./.lake/build/bin/test <n>`), not with `#eval`.
import FromLeanCommon
import LeanToLambdaBox

def suite_qsort := qsort 200
#erase suite_qsort to "prog.ast" mli "bench.mli"

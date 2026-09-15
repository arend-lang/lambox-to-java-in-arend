#!/usr/bin/env bash
# extract-arend.sh <MODULE:DEF> [outfile]
#
# Typechecks a single definition of the Arend project and prints what that
# definition printed (the ExamplePrint.ard definitions are `putStrLn <text>`,
# so typechecking one of them emits the generated artifact).
#
# A target module of `ExamplePrint` lives in the separate lambox-to-java-examples
# project (see AREND_EXAMPLES_PROJECT in lib.sh), which depends on lambox-to-java;
# every other target (chiefly `Imported.<Module>`, written by stages/java.sh) is
# typechecked in lambox-to-java itself.
#
# The CLI is narrowed to one definition and runs WITHOUT `--serialize`, and the
# project's binary cache dir is cleared first, so a run always typechecks the
# current sources. That correctness decision COSTS NOTHING, and the reason is
# worth knowing, because "turn the cache on" is the first idea anyone has about
# the ~18 s an invocation takes. Measured on `Imported.Peano:progJava`:
#
#   cold, no .arc                    18.9 s
#   warm .arc (compiler modules)     18.8 s   <- the cache saves NOTHING
#   warm, repeated                   17.9 / 17.7 / 17.5 s
#
# Where the time actually goes, from the CLI's own [INFO] lines and a JFR profile
# of the CLI itself: JVM start 0.1 s, `Loaded arend-lib` 0.14 s, and typechecking
# the target 0.02 s. The other ~18 s is ANTLR (`ParserATNSimulator`) PARSING
# arend-lib's sources. A `.arc` skips TYPECHECKING, not PARSING, which is exactly
# why enabling it changes nothing.
#
# Two measurements pin that down. Deleting arend-lib's `src/` (binaries only)
# takes the same run to 1.7 s -- and fails name resolution, so it is a proof of
# cause, not a fix. And the cost is a CLIFF, not a slope, measured with a
# one-line project importing exactly one module:
#
#   \import Paths          1 module loaded    1.7 s
#   \import Data.Maybe     2 modules          1.6 s
#   \import Logic        156 modules         17.0 s
#   \import Meta         156 modules         16.4 s
#   \import Data.Bool    156 modules         16.1 s
#   \import Data.String  157 modules         17.5 s
#   \import Data.Array   156 modules         19.3 s
#
# `Paths.ard` imports nothing and `Data.Maybe` imports only `Paths`; everything
# else reaches arend-lib's meta/extension modules (`Logic.ard` imports `Meta`,
# `Algebra.Meta`, `Function.Meta`, ...) and then 156 modules load. So this cannot
# be trimmed by dropping an import: String, Array and Bool are all on the far
# side of the cliff and the generator needs all three.
#
# Worth noting for anyone who wants to attack it upstream (this machine builds
# the Arend CLI itself): the SOURCE-level import closure of `Data.Bool` is 12
# modules and of `Set` is 13, yet 156 load either way -- an order of magnitude
# more than the import graph asks for. Whether that is necessary or an eager
# loading policy is an Arend question, not ours, but it is where a 16 s
# per-invocation win would come from.
#
# This project's own 69 generated `src/Imported/*.ard` (19 MB) cost nothing at
# all, since unreachable modules are never parsed.
#
# So the fixed cost is per-INVOCATION and irreducible from here; the lever is to
# invoke Arend ONCE for many programs, which is what test/golden.py does (see its
# docstring) and what run.py does not.
#
# What clearing the cache buys is a class of silent bug: a stale .arc of a
# dependency makes the CLI generate code from sources that are no longer there
# (it has already produced two wrong conclusions), and a stale .arc of the PRINT
# module suppresses the `putStrLn` we harvest outright -- confirmed again here,
# a `--serialize` run followed by a second run harvested 0 lines.
#
# The project's `bin` dir is gitignored build output, so clearing it is safe;
# the arend-lib cache in ~/.arend is never touched.
#
# The printed text is delimited by the CLI's
#   --- Typechecking <DEF> ---
#   ...
#   --- Done (NNms) ---
# lines; everything before (library loading warnings) is dropped.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

[ $# -ge 1 ] || die "usage: extract-arend.sh <MODULE:DEF> [outfile]"
target=$1
out=${2-}

case $target in
  ExamplePrint:*) project="$AREND_EXAMPLES_PROJECT"; extra_l=(-L "$ROOT" -L "$AREND_LIBDIR") ;;
  *)              project="$AREND_PROJECT";          extra_l=() ;;
esac

require_tool "$JAVA" "set JAVA to a JDK's java"
if [ ! -f "$AREND_JAR" ]; then
  # An absent jar is a missing TOOLCHAIN, like an absent `java`: run.py records
  # skip-no-tool.
  warn "Arend CLI jar not found: $AREND_JAR (a development build is required)"
  exit "$MISSING_TOOL_EXIT"
fi
[ -f "$project/arend.yaml" ] || die "no arend.yaml in $project"

mkdir -p "$WORK_DIR"
log=$(mktemp "$WORK_DIR/extract-XXXXXX.log")
trap 'rm -f "$log"' EXIT

# In daemon mode (AREND_DAEMON=1, see lib.sh) the library positional must be
# omitted -- a daemon-served command reports `[ERROR] Module not found:
# arend.yaml` for it, which the error check below would read as a failure -- and
# the cache must not be cleared, the daemon owning that state.
if [ "$AREND_DAEMON" = 1 ]; then
  arend_args=("${extra_l[@]}" "$target")
else
  # No cache may satisfy any module of this run: a stale one of a DEPENDENCY hides
  # a source change, and a stale one of the target's own module skips the
  # `putStrLn` side effect we harvest. When the target lives in the examples
  # project, lambox-to-java's cache is a dependency of it too, so both are cleared.
  rm -rf "$project/bin"
  [ "$project" = "$AREND_PROJECT" ] || rm -rf "$AREND_PROJECT/bin"
  arend_args=("${extra_l[@]}" arend.yaml "$target")
fi

start=$(date +%s%N)
# The exit status is not a reliable success signal: the CLI also returns 1 when
# it merely failed to load some unrelated binary cache. The `--- Done ---`
# marker and the absence of [ERROR] lines are.
info "+ (cd $project && $JAVA $JAVA_STACK -jar $AREND_JAR ${arend_args[*]})"
(cd "$project" && "$JAVA" "$JAVA_STACK" -jar "$AREND_JAR" "${arend_args[@]}") >"$log" 2>&1 || true
info "extract $target took $(( ($(date +%s%N) - start) / 1000000 ))ms"

if grep -q '^\[ERROR\]' "$log"; then
  cat "$log" >&2
  die "Arend reported errors on $target"
fi

# `[WARN]`/`[INFO]` lines can land INSIDE the delimiters -- the daemon reports
# `[WARN] Slow typecheck (12.5s, threshold 5000ms)` while typechecking, which
# ended up as the last line of six generated Prog.java files and made every one
# of them fail to compile. Generated Java never starts a line with `[`, so
# dropping them is safe with or without the daemon.
text=$(sed -n '/^--- Typechecking /,/^--- Done (/p' "$log" | sed '1d;$d' | grep -vE '^\[(WARN|INFO)\]' || true)
[ -n "$text" ] || { cat "$log" >&2; die "no printed output found for $target"; }

if [ -n "$out" ]; then
  mkdir -p "$(dirname "$out")"
  printf '%s\n' "$text" >"$out"
  info "wrote $out"
else
  printf '%s\n' "$text"
fi

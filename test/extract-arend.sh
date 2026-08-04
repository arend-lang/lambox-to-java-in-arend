#!/usr/bin/env bash
# extract-arend.sh <MODULE:DEF> [outfile]
#
# Typechecks a single definition of the Arend project and prints what that
# definition printed (the ExamplePrint.ard definitions are `putStrLn <text>`,
# so typechecking one of them emits the generated artifact).
#
# The CLI is narrowed to one definition and deliberately never gets
# `--serialize`: a binary cache would suppress the print on the next run.
#
# The printed text is delimited by the CLI's
#   --- Typechecking <DEF> ---
#   ...
#   --- Done (NNms) ---
# lines; everything before (library loading warnings) is dropped.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/config.sh"

[ $# -ge 1 ] || die "usage: extract-arend.sh <MODULE:DEF> [outfile]"
target=$1
out=${2-}

require_tool "$JAVA" "set JAVA to a JDK's java"
[ -f "$AREND_JAR" ] || die "Arend CLI jar not found: $AREND_JAR (set AREND_JAR; a development build is required)"
[ -f "$AREND_PROJECT/arend.yaml" ] || die "no arend.yaml in $AREND_PROJECT (set AREND_PROJECT)"

mkdir -p "$WORK_DIR"
log=$(mktemp "$WORK_DIR/extract-XXXXXX.log")
trap 'rm -f "$log"' EXIT

start=$(date +%s%N)
# The exit status is not a reliable success signal: the CLI also returns 1 when
# it merely failed to load some unrelated binary cache. The `--- Done ---`
# marker and the absence of [ERROR] lines are.
(cd "$AREND_PROJECT" && "$JAVA" "$JAVA_STACK" -jar "$AREND_JAR" arend.yaml "$target") >"$log" 2>&1 || true
info "extract $target took $(( ($(date +%s%N) - start) / 1000000 ))ms"

if grep -q '^\[ERROR\]' "$log"; then
  cat "$log" >&2
  die "Arend reported errors on $target"
fi

text=$(sed -n '/^--- Typechecking /,/^--- Done (/p' "$log" | sed '1d;$d')
[ -n "$text" ] || { cat "$log" >&2; die "no printed output found for $target"; }

if [ -n "$out" ]; then
  mkdir -p "$(dirname "$out")"
  printf '%s\n' "$text" >"$out"
  info "wrote $out"
else
  printf '%s\n' "$text"
fi

#!/usr/bin/env bash
# The `handwritten` corpus: the programs that live in this repository, one
# directory each under corpora/handwritten/.
#
# A corpus script prints one TSV row per program on stdout and nothing else
# (`#` lines are comments run.py skips). The columns are fixed:
#
#   program  ast  expected  backends  runtime  xfail  note
#
# `xfail` is a REASON, or empty: a program known to fail records why here, and
# run.py still reports its real status.
#
# There is no logic here beyond reading each program's `meta` file, which is
# plain key=value data -- deliberately NOT sourced, so a program cannot smuggle
# code into the harness. A corpus whose upstream is absent prints no rows; this
# one's upstream is the repository itself, so it always has rows.
set -euo pipefail

CORPUS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TEST_DIR="$(cd "$CORPUS_DIR/.." && pwd)"

for meta in "$CORPUS_DIR"/handwritten/*/meta; do
  [ -f "$meta" ] || continue
  dir=${meta%/meta}
  expected= backends= runtime= xfail= note=
  while IFS='=' read -r key value; do
    case $key in
      expected) expected=$value ;;
      backends) backends=$value ;;
      runtime)  runtime=$value ;;
      xfail)    xfail=$value ;;
      note)     note=$value ;;
    esac
  done <"$meta"
  printf '%s\t%s\t%s\t%s\t%s\t%s\t%s\n' \
    "${dir##*/}" "${dir#"$TEST_DIR"/}/prog.ast" \
    "$expected" "$backends" "$runtime" "$xfail" "$note"
done

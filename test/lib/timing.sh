#!/usr/bin/env bash
# Wall-clock timing of one stage, plus a row in work/timings.tsv.
#
#   timed <case> <backend> <stage> -- cmd...
#
# The command's stdout/stderr are left untouched (so a stage can still produce
# an artifact on stdout); only the "took NNms" line goes to stderr.

timed() {
  local case_name=$1 backend=$2 stage=$3
  shift 3
  [ "${1-}" = "--" ] || die "timed: expected -- before the command"
  shift

  local start end ms status=0
  start=$(date +%s%N)
  "$@" || status=$?
  end=$(date +%s%N)
  ms=$(( (end - start) / 1000000 ))

  mkdir -p "$(dirname "$TIMINGS_TSV")"
  printf '%s\t%s\t%s\t%s\n' "$case_name" "$backend" "$stage" "$ms" >>"$TIMINGS_TSV"
  info "$case_name/$backend/$stage took ${ms}ms"
  return $status
}

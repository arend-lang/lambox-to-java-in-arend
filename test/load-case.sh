#!/usr/bin/env bash
# Sourced (not executed) by every backend script:
#
#   . "$(dirname "$0")/load-case.sh" <case>
#
# Brings in config.sh + lib/timing.sh and then the case's declarations
# (cases/<case>/case.sh, variables only). Defines CASE_NAME and CASE_DIR.

_here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
. "$_here/config.sh"
. "$_here/lib/timing.sh"

[ $# -ge 1 ] || die "usage: $(basename "$0") <case> [...]"
CASE_NAME=$1
CASE_DIR="$CASES_DIR/$CASE_NAME"
[ -f "$CASE_DIR/case.sh" ] || die "unknown case '$CASE_NAME' (no $CASE_DIR/case.sh)"
. "$CASE_DIR/case.sh"

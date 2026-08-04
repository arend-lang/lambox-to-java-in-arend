#!/usr/bin/env bash
# case-note.sh <case> -- print the case's NOTE (the expected result, for eyeballing).
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"

printf '%s\n' "${NOTE-}"

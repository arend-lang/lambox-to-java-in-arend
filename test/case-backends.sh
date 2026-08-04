#!/usr/bin/env bash
# case-backends.sh <case> -- print the backends the case declares, one per line.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"

for backend in ${BACKENDS-}; do printf '%s\n' "$backend"; done

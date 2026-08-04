#!/usr/bin/env bash
# build-java.sh <case>
#
# Produces work/<case>/java/Prog.java via the case's JAVA_PRODUCER and compiles
# it with javac. The generated class already has a `main` printing `__main()`.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/load-case.sh" "$@"

require_tool "$JAVAC" "set JAVAC (or JAVA) to a JDK"

dir=$(work_dir "$CASE_NAME" java)

timed "$CASE_NAME" java extract -- produce "${JAVA_PRODUCER-}" "$dir/Prog.java"
timed "$CASE_NAME" java compile -- "$JAVAC" -d "$dir" "$dir/Prog.java"

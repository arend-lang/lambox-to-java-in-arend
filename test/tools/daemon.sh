#!/usr/bin/env bash
# daemon.sh start|stop|status
#
# Runs an Arend CLI daemon for the compiler project, so `AREND_DAEMON=1` has
# something to talk to. With one running, a java `gen` costs ~1-2 s instead of
# ~18 s; see test/README.md for what that 18 s is and where the daemon does and
# does not help.
#
# Needs a CLI built WITH the daemon (not in 1.12 as released) -- `start` says so
# and exits 3, the harness' missing-toolchain code, if the jar has no `-d`.
#
# start does two things the daemon needs and will not do for you:
#
#   * exports JAVA_TOOL_OPTIONS=-Xss1g. Normalizing the generator over a program
#     is deep, and the daemon spawns its child JVM with no options of its own.
#   * clears `src/Imported`. Bootstrap typechecks the WHOLE library, and each
#     generated `Imported/<Module>.ard` typechecks by COMPILING its program --
#     69 of those at startup overflows the stack whatever -Xss says, the
#     overflow being on a thread -Xss does not govern. The gen stage rewrites
#     these modules anyway, so clearing them costs nothing but a re-import.
set -euo pipefail

. "$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)/lib.sh"

cmd=${1:-status}

require_tool "$JAVA" "set JAVA to a JDK's java"
[ -f "$AREND_JAR" ] || { warn "Arend CLI jar not found: $AREND_JAR"; exit "$MISSING_TOOL_EXIT"; }

arend() { (cd "$AREND_PROJECT" && "$JAVA" -jar "$AREND_JAR" "$@"); }

case $cmd in

start)
  # Captured, not piped: the CLI exits non-zero after printing help, which under
  # `pipefail` would make every jar look daemon-less.
  help=$("$JAVA" -jar "$AREND_JAR" --help 2>&1 || true)
  case $help in
    *--daemon*) ;;
    *) warn "this Arend CLI has no daemon ($AREND_JAR); build a branch that has one"
       exit "$MISSING_TOOL_EXIT" ;;
  esac
  count=$(find "$AREND_PROJECT/src/Imported" -name '*.ard' 2>/dev/null | wc -l)
  if [ "$count" -gt 0 ]; then
    info "clearing $count generated Imported module(s) -- bootstrap would compile every one"
    rm -f "$AREND_PROJECT"/src/Imported/*.ard
  fi
  rm -rf "$AREND_PROJECT/bin"
  info "starting daemon for $AREND_PROJECT (bootstrap typechecks the compiler, ~30 s)"
  JAVA_TOOL_OPTIONS=-Xss1g arend -d arend.yaml
  info "now run the harness with AREND_DAEMON=1"
  ;;

stop)   arend --daemon-stop arend.yaml ;;
status) arend --daemon-ping arend.yaml || true ;;

*) die "usage: daemon.sh start|stop|status" ;;
esac

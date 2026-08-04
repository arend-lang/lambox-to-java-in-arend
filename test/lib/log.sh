#!/usr/bin/env bash
# Tiny logging helpers. Everything goes to stderr so that a script's stdout
# stays a clean artifact (generated code, s-expression, program output).

info() { printf '[test] %s\n' "$*" >&2; }
warn() { printf '[test] WARNING: %s\n' "$*" >&2; }
die()  { printf '[test] ERROR: %s\n' "$*" >&2; exit 1; }

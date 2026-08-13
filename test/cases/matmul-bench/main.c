/* Minimal driver for the Peregrine-generated matmul.c: runs `body` and
 * prints the resulting primitive int. CertiRocq encodes a prim int n as the
 * odd machine word 2n+1 (OCaml-style), hence the >> 1. Expected: 2197000. */
#include <stdio.h>
#include "gc_stack.h"

extern value body(struct thread_info *);

int main(int argc, char *argv[]) {
  struct thread_info *tinfo = make_tinfo();
  value val = body(tinfo);
  printf("%lld\n", (long long) val >> 1);
  return 0;
}

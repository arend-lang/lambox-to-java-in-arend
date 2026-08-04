// Fixed runtime for the generated Java code (see ToJava.ard).
//
// This file is *not* generated: the compiler only emits the program-specific
// class `Prog`, which references the types below as `Rt.Fn`, `Rt.Data` and
// `Rt.BOX`. Compile it next to the generated `Prog.java`:
//   javac -d <dir> <dir>/Rt.java <dir>/Prog.java
//
// Design (matches the untyped λ□ encoding):
//   * untyped values     -> Object
//   * closures           -> Fn (anonymous inner classes, no invokedynamic)
//   * constructors       -> Data(tag, fields)
//   * erased proofs/types -> BOX
//
// Kept to plain loops/casts (no lambdas/streams/pattern-switch) per the
// classic-bytecode-only codegen style used by the generator.
public final class Rt {
  private Rt() {}

  public interface Fn {
    Object apply(Object x);
  }

  // `toString` overrides here are purely for making printed program output
  // human-readable (e.g. inspecting `System.out.println(__main())`): a
  // recursive, indented `tag(\n  field,\n  field\n)` tree, where flat leaves
  // like `0` print with no parens.
  public static final class Data {
    public final int tag;
    public final Object[] fields;

    public Data(int tag, Object[] fields) { this.tag = tag; this.fields = fields; }

    @Override public String toString() { return toString(0); }

    public String toString(int indent) {
      StringBuilder sb = new StringBuilder();
      sb.append(tag);
      if (fields.length == 0) return sb.toString();
      sb.append("(\n");
      for (int i = 0; i < fields.length; i++) {
        for (int j = 0; j < indent + 1; j++) sb.append("  ");
        Object f = fields[i];
        if (f instanceof Data) { sb.append(((Data) f).toString(indent + 1)); } else { sb.append(String.valueOf(f)); }
        if (i < fields.length - 1) sb.append(",");
        sb.append("\n");
      }
      for (int j = 0; j < indent; j++) sb.append("  ");
      sb.append(")");
      return sb.toString();
    }
  }

  // A compiled closure can't show anything structural, so it gets a fixed
  // placeholder instead of a raw hashcode.
  public static final Object BOX = new Object();

  // --- Ill-formed input ------------------------------------------------------
  //
  // Two λ□ nodes have no Java value: a `bvar` whose de Bruijn index exceeds the
  // enclosing binders (out of scope) and a `fvar` (locally-nameless free
  // variable) — a closed program produced by erasure contains neither. The
  // generator used to emit a commented `null` for them, which then either blew
  // up far away as a NullPointerException or, worse, propagated silently as a
  // value; it now emits a call of one of these, so the failure is immediate and
  // names the offending node (`path` is the generator's structural node id, see
  // `compileExpr` in ToJava.ard).
  public static Object unbound(int index, String path) {
    throw new IllegalStateException(
      "ill-formed lambda-box: de Bruijn index " + index + " is out of scope (node " + path + ")");
  }

  public static Object freeVar(String name, String path) {
    throw new IllegalStateException(
      "ill-formed lambda-box: free variable \"" + name + "\" has no Java counterpart (node " + path + ")");
  }

  // --- Primitive integer ops -------------------------------------------------
  //
  // Realization of the arity-2 λ□ axioms `prim_add_int`, `prim_mul_int`,
  // `prim_sub_int` and `prim_eqb_int` (see ExampleMatMul.ard). The C/OCaml
  // backends get these by remapping the axioms onto CertiRocq's
  // prim_int63_add/mul/sub/eqb via peregrine's `--attributes`; for Java the
  // generator emits a reference to the constants below (axiom table in
  // ToJava.ard) instead of a throwing stub.
  //
  // Both arguments are taken one at a time, since generated code is fully
  // curried: `((Fn)((Fn)PRIM_ADD_INT).apply(a)).apply(b)`.
  //
  // There are TWO families, one per int representation the generator can pick
  // (`JavaIntRepr` in ToJava.ard) — a program uses exactly one of them, and its
  // `prim` literals are of the matching type:
  //   * `PRIM_*_INT`  — java.math.BigInteger values: unbounded, never overflow,
  //     but boxed arithmetic and NO wraparound.
  //   * `PRIM_*_LONG` — java.lang.Long values, i.e. Java's built-in integers:
  //     much faster, wrap — but at 2^64 and signed, whereas λ□ ints are 63-bit
  //     with unsigned/cyclic (mod 2^63) arithmetic.
  //
  // KNOWN MISMATCH (documented, not fixed). λ□'s `tPrim primInt` payload is
  // int63 by definition of the language: MetaRocq
  // erasure/theories/EPrimitive.v — `primIntModel (i : PrimInt63.int)`;
  // lean-to-lambdabox — `PrimModel .primInt := BitVec 63`; Rocq refman
  // "Primitive objects / Primitive integers" (63-bit machine int, unsigned view
  // `Uint63`, signed view `Sint63`). Neither family below matches that, nor the
  // C runtime (CertiRocq prim_int63_add/mul/sub/eqb) or the OCaml one (unboxed
  // OCaml `int`, cf. ExtrOCamlInt63); they agree as long as values stay well
  // below 2^62, which holds for the current examples.
  // FUTURE WORK: a `PRIM_*_INT63` family normalizing mod 2^63 per `Uint63`,
  // selected by a third `JavaIntRepr` alternative.
  private static java.math.BigInteger num(Object x) { return (java.math.BigInteger) x; }

  private static long lng(Object x) { return ((Long) x).longValue(); }

  // eqb's result ABI: the two-constructor Bool inductive with no fields,
  // false = tag 0, true = tag 1 (matching the declared constructor order).
  public static final Data FALSE = new Data(0, new Object[]{});
  public static final Data TRUE = new Data(1, new Object[]{});

  public static final Fn PRIM_ADD_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).add(num(y)); } };
    }
  };

  public static final Fn PRIM_MUL_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).multiply(num(y)); } };
    }
  };

  public static final Fn PRIM_SUB_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).subtract(num(y)); } };
    }
  };

  public static final Fn PRIM_EQB_INT = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return num(x).equals(num(y)) ? TRUE : FALSE; } };
    }
  };

  public static final Fn PRIM_ADD_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Long.valueOf(lng(x) + lng(y)); } };
    }
  };

  public static final Fn PRIM_MUL_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Long.valueOf(lng(x) * lng(y)); } };
    }
  };

  public static final Fn PRIM_SUB_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return Long.valueOf(lng(x) - lng(y)); } };
    }
  };

  public static final Fn PRIM_EQB_LONG = new Fn() {
    public Object apply(final Object x) {
      return new Fn() { public Object apply(Object y) { return lng(x) == lng(y) ? TRUE : FALSE; } };
    }
  };
}

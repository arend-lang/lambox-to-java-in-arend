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
  //     much faster, wrap — but at 2^64, whereas λ□ ints are 63-bit.
  // Neither matches the C/OCaml int63 runtimes exactly (known, separately
  // tracked mismatch); they agree as long as values stay well below 2^62.
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

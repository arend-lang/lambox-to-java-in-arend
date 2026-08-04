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
}

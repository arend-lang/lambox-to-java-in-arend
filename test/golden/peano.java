public final class Prog {
  public static Object c___add(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Rt.Data dLLy0 = ((Rt.Data)(py0));
          return ((dLLy0.tag == 0) ? pLy0 : ((dLLy0.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
            return Fix.this.f0(w0);
          } })).apply(dLLy0.fields[0]))).apply(pLy0) }) : Rt.noBranch(dLLy0, "LLy0")));
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  // inductive c___Nat: erased; values use Data(tag, fields)
  public static Object body(){
    return ((Rt.Fn)(((Rt.Fn)(c___add())).apply(new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) })))).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }));
  }
}

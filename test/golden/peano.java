public final class Prog {
  public static Object c___add(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Rt.Data dLLy0 = ((Rt.Data)(py0));
          Object rLLy0;
          switch (dLLy0.tag) {
            case 0: {
              rLLy0 = pLy0;
              break;
            }
            case 1: {
              final Object g0b1LLy0 = dLLy0.fields[0];
              rLLy0 = new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(g0b1LLy0))).apply(pLy0) });
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rLLy0;
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  // inductive c___Nat: erased; values use Data(tag, fields)
  public static Object __main(){
    return ((Rt.Fn)(((Rt.Fn)(c___add())).apply(new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) })))).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }));
  }
  public static void main(String[] args){
    Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
      return __main();
    } });
  }
}

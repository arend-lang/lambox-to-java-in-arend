public final class Prog {
  public static Object c___ys(){
    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c___map())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c___double()))).apply(c___xs());
  }
  public static Object c___xs(){
    return new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }) }) }), new Rt.Data(0, new Object[]{  }) }) }) });
  }
  public static Object c___double(){
    class Fix {
      public Object f0(Object py0){
        final Object lLy0 = new Rt.Fn(){ public Object apply(Object pVLy0){
          return new Rt.Data(0, new Object[]{  });
        } };
        final Object lBLy0 = new Rt.Fn(){ public Object apply(Object pVBLy0){
          return new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
            return Fix.this.f0(w0);
          } })).apply(pVBLy0) }) });
        } };
        final Rt.Data dBBLy0 = ((Rt.Data)(py0));
        Object rBBLy0;
        switch (dBBLy0.tag) {
          case 0: {
            rBBLy0 = ((Rt.Fn)(lLy0)).apply(c__Unit__unit());
            break;
          }
          case 1: {
            final Object g0b1BBLy0 = dBBLy0.fields[0];
            rBBLy0 = ((Rt.Fn)(lBLy0)).apply(g0b1BBLy0);
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rBBLy0;
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  // inductive c___Nat_: erased; values use Data(tag, fields)
  public static Object c___map(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          return new Rt.Fn(){ public Object apply(Object pLLy0){
            return new Rt.Fn(){ public Object apply(Object pLLLy0){
              final Object lLLLLy0 = new Rt.Fn(){ public Object apply(Object pVLLLLy0){
                return new Rt.Data(0, new Object[]{  });
              } };
              final Object lBLLLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLLLy0){
                return new Rt.Fn(){ public Object apply(Object pLVBLLLLy0){
                  return new Rt.Data(1, new Object[]{ ((Rt.Fn)(pLLy0)).apply(pVBLLLLy0), ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                    return Fix.this.f0(w0);
                  } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLy0))).apply(pLVBLLLLy0) });
                } };
              } };
              final Rt.Data dBBLLLLy0 = ((Rt.Data)(pLLLy0));
              Object rBBLLLLy0;
              switch (dBBLLLLy0.tag) {
                case 0: {
                  rBBLLLLy0 = ((Rt.Fn)(lLLLLy0)).apply(c__Unit__unit());
                  break;
                }
                case 1: {
                  final Object g0b1BBLLLLy0 = dBBLLLLy0.fields[0];
                  final Object g1b1BBLLLLy0 = dBBLLLLy0.fields[1];
                  rBBLLLLy0 = ((Rt.Fn)(((Rt.Fn)(lBLLLLy0)).apply(g0b1BBLLLLy0))).apply(g1b1BBLLLLy0);
                  break;
                }
                default: {
                  throw new RuntimeException("no matching branch");
                }
              }
              return rBBLLLLy0;
            } };
          } };
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  // inductive c___List_: erased; values use Data(tag, fields)
  public static Object body(){
    return c___ys();
  }
}

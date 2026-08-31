public final class Prog {
  public static Object c___suite_triangle_foldl(){
    return ((Rt.Fn)(c___triangle_foldl())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___triangle_foldl(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List__foldl())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c__Nat__add()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(c__List__range())).apply(p));
    } };
  }
  public static Object c__List__range(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(c__List_range__loop())).apply(p))).apply(new Rt.Data(0, new Object[]{  }));
    } };
  }
  public static Object c__List_range__loop(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Object lLLy0 = new Rt.Fn(){ public Object apply(Object pVLLy0){
            return pVLLy0;
          } };
          final Object lBLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(pVBLLy0))).apply(new Rt.Data(1, new Object[]{ pVBLLy0, pLVBLLy0 }));
            } };
          } };
          final Object lBBLLy0 = py0;
          final Rt.Data dBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lBBLLy0))).apply(Long.valueOf(0L))));
          Object rBBBLLy0;
          switch (dBBBLLy0.tag) {
            case 0: {
              rBBBLLy0 = ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0BBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(lBLLy0)).apply(pFb0BBBLLy0))).apply(pLy0);
              } })).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__sub())).apply(lBBLLy0))).apply(Long.valueOf(1L)));
              break;
            }
            case 1: {
              rBBBLLy0 = ((Rt.Fn)(lLLy0)).apply(pLy0);
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rBBBLLy0;
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c__Nat__beq(){
    return Rt.PRIM_EQB_LONG;
  }
  public static Object c__Nat__sub(){
    return Rt.NAT_SUB_LONG;
  }
  // inductive c___Bool: erased; values use Data(tag, fields)
  public static Object c___instOfNatNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ p });
    } };
  }
  public static Object c__OfNat__ofNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          final Rt.Data dLLL = ((Rt.Data)(pLL));
          Object rLLL;
          switch (dLLL.tag) {
            case 0: {
              final Object g0b0LLL = dLLL.fields[0];
              rLLL = g0b0LLL;
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rLLL;
        } };
      } };
    } };
  }
  // inductive c___OfNat: erased; values use Data(tag, fields)
  public static Object c__Nat__add(){
    return Rt.PRIM_ADD_LONG;
  }
  public static Object c__List__foldl(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          return new Rt.Fn(){ public Object apply(Object pLLy0){
            return new Rt.Fn(){ public Object apply(Object pLLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLLLy0){
                final Object lLLLLLy0 = new Rt.Fn(){ public Object apply(Object pVLLLLLy0){
                  return pVLLLLLy0;
                } };
                final Object lBLLLLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLLLLy0){
                  return new Rt.Fn(){ public Object apply(Object pLVBLLLLLy0){
                    return new Rt.Fn(){ public Object apply(Object pLLVBLLLLLy0){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                        return Fix.this.f0(w0);
                      } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLy0))).apply(((Rt.Fn)(((Rt.Fn)(pLLy0)).apply(pVBLLLLLy0))).apply(pLVBLLLLLy0)))).apply(pLLVBLLLLLy0);
                    } };
                  } };
                } };
                final Rt.Data dBBLLLLLy0 = ((Rt.Data)(pLLLLy0));
                Object rBBLLLLLy0;
                switch (dBBLLLLLy0.tag) {
                  case 0: {
                    rBBLLLLLy0 = ((Rt.Fn)(lLLLLLy0)).apply(pLLLy0);
                    break;
                  }
                  case 1: {
                    final Object g0b1BBLLLLLy0 = dBBLLLLLy0.fields[0];
                    final Object g1b1BBLLLLLy0 = dBBLLLLLy0.fields[1];
                    rBBLLLLLy0 = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBLLLLLy0)).apply(pLLLy0))).apply(g0b1BBLLLLLy0))).apply(g1b1BBLLLLLy0);
                    break;
                  }
                  default: {
                    throw new RuntimeException("no matching branch");
                  }
                }
                return rBBLLLLLy0;
              } };
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
  // inductive c___List: erased; values use Data(tag, fields)
  public static Object __main(){
    return c___suite_triangle_foldl();
  }
  public static void main(String[] args){
    Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
      return __main();
    } });
  }
}

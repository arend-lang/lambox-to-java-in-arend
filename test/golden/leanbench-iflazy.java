public final class Prog {
  public static Object c___suite_iflazy(){
    return ((Rt.Fn)(c___iflazy())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___iflazy(){
    class Fix {
      public Object f0(Object py0){
        final Rt.Data dLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c___instDecidableEqNat())).apply(py0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))))));
        Object rLy0;
        switch (dLy0.tag) {
          case 0: {
            final Object g0b0Ly0 = dLy0.fields[0];
            rLy0 = ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HSub__hSub())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHSub())).apply(Rt.BOX))).apply(c___instSubNat())))).apply(py0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)))));
            break;
          }
          case 1: {
            final Object g0b1Ly0 = dLy0.fields[0];
            rLy0 = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(42L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(42L)));
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLy0;
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c___instSubNat(){
    return new Rt.Data(0, new Object[]{ c__Nat__sub() });
  }
  public static Object c__Nat__sub(){
    return Rt.NAT_SUB_LONG;
  }
  public static Object c___instHSub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Sub__sub())).apply(Rt.BOX))).apply(pL))).apply(pc0LL))).apply(pLc0LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Sub__sub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            rLL = g0b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  // inductive c___Sub: erased; values use Data(tag, fields)
  public static Object c__HSub__hSub(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            final Rt.Data dLLLL = ((Rt.Data)(pLLL));
            Object rLLLL;
            switch (dLLLL.tag) {
              case 0: {
                final Object g0b0LLLL = dLLLL.fields[0];
                rLLLL = g0b0LLLL;
                break;
              }
              default: {
                throw new RuntimeException("no matching branch");
              }
            }
            return rLLLL;
          } };
        } };
      } };
    } };
  }
  // inductive c___HSub: erased; values use Data(tag, fields)
  // inductive c___Decidable: erased; values use Data(tag, fields)
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
  public static Object c___instDecidableEqNat(){
    return c__Nat__decEq();
  }
  public static Object c__Nat__decEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object body(){
    return c___suite_iflazy();
  }
}

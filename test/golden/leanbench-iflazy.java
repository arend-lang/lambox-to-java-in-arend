public final class Prog {
  public static Object c___suite_iflazy(){
    return ((Rt.Fn)(c___iflazy())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___iflazy(){
    class Fix {
      public Object f0(Object py0){
        final Rt.Data dLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c___instDecidableEqNat())).apply(py0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))))));
        return ((dLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
          return Fix.this.f0(w0);
        } })).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HSub__hSub())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHSub())).apply(Rt.BOX))).apply(c___instSubNat())))).apply(py0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L))))) : ((dLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(42L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(42L))) : Rt.noBranch(dLy0, "Ly0")));
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
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
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
            return ((dLLLL.tag == 0) ? dLLLL.fields[0] : Rt.noBranch(dLLLL, "LLLL"));
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
          return ((dLLL.tag == 0) ? dLLL.fields[0] : Rt.noBranch(dLLL, "LLL"));
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

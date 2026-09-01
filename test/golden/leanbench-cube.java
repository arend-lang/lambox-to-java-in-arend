public final class Prog {
  public static Object c___suite_cube(){
    return ((Rt.Fn)(c___cube())).apply(c__Unit__unit());
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  public static Object c___cube(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HPow__hPow())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c___instHPow())).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instPowNat())).apply(Rt.BOX))).apply(c___instNatPowNat()))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(300L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(300L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(3L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(3L))));
    } };
  }
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
  public static Object c___instNatPowNat(){
    return new Rt.Data(0, new Object[]{ c__Nat__pow() });
  }
  public static Object c__Nat__pow(){
    return Rt.PRIM_POW_LONG;
  }
  public static Object c___instPowNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__NatPow__pow())).apply(Rt.BOX))).apply(pL))).apply(pc0LL))).apply(pLc0LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__NatPow__pow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___NatPow: erased; values use Data(tag, fields)
  public static Object c___instHPow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LLL){
            return new Rt.Fn(){ public Object apply(Object pLc0LLL){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pow__pow())).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLL))).apply(pc0LLL))).apply(pLc0LLL);
            } };
          } } });
        } };
      } };
    } };
  }
  public static Object c__Pow__pow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          final Rt.Data dLLL = ((Rt.Data)(pLL));
          return ((dLLL.tag == 0) ? dLLL.fields[0] : Rt.noBranch(dLLL, "LLL"));
        } };
      } };
    } };
  }
  // inductive c___Pow: erased; values use Data(tag, fields)
  public static Object c__HPow__hPow(){
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
  // inductive c___HPow: erased; values use Data(tag, fields)
  public static Object body(){
    return c___suite_cube();
  }
}

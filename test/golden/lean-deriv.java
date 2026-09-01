public final class Prog {
  public static Object c___suite_deriv(){
    return ((Rt.Fn)(c___deriv())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___deriv(){
    return new Rt.Fn(){ public Object apply(Object p){
      final Object lL = ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))) })))).apply(new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))) }));
      return ((Rt.Fn)(c__Deriv_Expr__count())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__nest())).apply(c__Deriv_Expr__deriv()))).apply(p))).apply(lL));
    } };
  }
  public static Object c__Deriv_Expr__deriv(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__d())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L)))))).apply(pL);
      } };
    } };
  }
  public static Object c__Deriv_Expr__d(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Object lLLy0 = new Rt.Fn(){ public Object apply(Object pVLLy0){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
          } };
          final Object lBLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLy0){
            final Rt.Data dLVBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c___instDecidableEqNat())).apply(py0))).apply(pVBLLy0)));
            return ((dLVBLLy0.tag == 0) ? new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) }) : ((dLVBLLy0.tag == 1) ? new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))) }) : Rt.noBranch(dLVBLLy0, "LVBLLy0")));
          } };
          final Object lBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__add())).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(py0))).apply(pVBBLLy0)))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(py0))).apply(pLVBBLLy0));
            } };
          } };
          final Object lBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__add())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(pVBBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(py0))).apply(pLVBBBLLy0))))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(pLVBBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(py0))).apply(pVBBBLLy0)));
            } };
          } };
          final Object lBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(pVBBBBLLy0))).apply(pLVBBBBLLy0)))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__add())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(pLVBBBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(py0))).apply(pVBBBBLLy0))))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(pVBBBBLLy0))).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Neg__neg())).apply(Rt.BOX))).apply(c__Int__instNegInt()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))) })))))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(c__Deriv_Expr__ln())).apply(pVBBBBLLy0)))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(py0))).apply(pLVBBBBLLy0))));
            } };
          } };
          final Object lBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBLLy0){
            return ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__mul())).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(py0))).apply(pVBBBBBLLy0)))).apply(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pow())).apply(pVBBBBBLLy0))).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Neg__neg())).apply(Rt.BOX))).apply(c__Int__instNegInt()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))) })));
          } };
          final Rt.Data dBBBBBBLLy0 = ((Rt.Data)(pLy0));
          return ((dBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(lLLy0)).apply(dBBBBBBLLy0.fields[0]) : ((dBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBLLy0)).apply(dBBBBBBLLy0.fields[0]) : ((dBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBLLy0)).apply(dBBBBBBLLy0.fields[0]))).apply(dBBBBBBLLy0.fields[1]) : ((dBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0)).apply(dBBBBBBLLy0.fields[0]))).apply(dBBBBBBLLy0.fields[1]) : ((dBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLLy0)).apply(dBBBBBBLLy0.fields[0]))).apply(dBBBBBBLLy0.fields[1]) : ((dBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBBBBBLLy0)).apply(dBBBBBBLLy0.fields[0]) : Rt.noBranch(dBBBBBBLLy0, "BBBBBBLLy0")))))));
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c__Deriv_Expr__ln(){
    return new Rt.Fn(){ public Object apply(Object p){
      final Object lL = new Rt.Fn(){ public Object apply(Object pVL){
        return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
      } };
      final Object lBL = new Rt.Fn(){ public Object apply(Object pVBL){
        return new Rt.Data(5, new Object[]{ pVBL });
      } };
      final Rt.Data dBBL = ((Rt.Data)(p));
      return ((dBBL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0BBL){
        final Rt.Data db0BBL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
        return ((db0BBL.tag == 0) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(0, new Object[]{ dBBL.fields[0] })) : ((db0BBL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lL)).apply(c__Unit__unit())))).apply(dBBL.fields[0]))).apply(Rt.BOX)))).apply(dBBL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0BBL, "b0BBL")));
      } })).apply(Rt.BOX) : ((dBBL.tag == 1) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(1, new Object[]{ dBBL.fields[0] })) : ((dBBL.tag == 2) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(2, new Object[]{ dBBL.fields[0], dBBL.fields[1] })) : ((dBBL.tag == 3) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(3, new Object[]{ dBBL.fields[0], dBBL.fields[1] })) : ((dBBL.tag == 4) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(4, new Object[]{ dBBL.fields[0], dBBL.fields[1] })) : ((dBBL.tag == 5) ? ((Rt.Fn)(lBL)).apply(new Rt.Data(5, new Object[]{ dBBL.fields[0] })) : Rt.noBranch(dBBL, "BBL")))))));
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  public static Object c__Int__instNegInt(){
    return new Rt.Data(0, new Object[]{ c__Int__neg() });
  }
  public static Object c__Int__neg(){
    return Rt.INT_NEG_LONG;
  }
  public static Object c__Neg__neg(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Neg: erased; values use Data(tag, fields)
  public static Object c__Deriv_Expr__mul(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Object lLLy0 = new Rt.Fn(){ public Object apply(Object pVLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVLLy0){
              return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(pVLLy0))).apply(pLVLLy0) });
            } };
          } };
          final Object lBLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLy0){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
          } };
          final Object lBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBLLy0){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
          } };
          final Object lBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBLLy0){
            return pVBBBLLy0;
          } };
          final Object lBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBLLy0){
            return pVBBBBLLy0;
          } };
          final Object lBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(new Rt.Data(0, new Object[]{ pLVBBBBBLLy0 })))).apply(pVBBBBBLLy0);
            } };
          } };
          final Object lBBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(pVBBBBBBLLy0))).apply(pLVBBBBBBLLy0) })))).apply(pLLVBBBBBBLLy0);
              } };
            } };
          } };
          final Object lBBBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(new Rt.Data(0, new Object[]{ pLVBBBBBBBLLy0 })))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(pVBBBBBBBLLy0))).apply(pLLVBBBBBBBLLy0));
              } };
            } };
          } };
          final Object lBBBBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBBLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(pVBBBBBBBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(pLVBBBBBBBBLLy0))).apply(pLLVBBBBBBBBLLy0));
              } };
            } };
          } };
          final Object lBBBBBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBBBLLy0){
              return new Rt.Data(3, new Object[]{ pVBBBBBBBBBLLy0, pLVBBBBBBBBBLLy0 });
            } };
          } };
          final Rt.Data dBBBBBBBBBBLLy0 = ((Rt.Data)(py0));
          return ((dBBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0BBBBBBBBBBLLy0){
            final Rt.Data db0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0BBBBBBBBBBLLy0){
              final Rt.Data db0b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b0BBBBBBBBBBLLy0){
                final Rt.Data db0b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
                return ((db0b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b0b0BBBBBBBBBBLLy0){
                  final Rt.Data db0b0b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                  return ((db0b0b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b0b0b0BBBBBBBBBBLLy0){
                    final Rt.Data db0b0b0b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                    return ((db0b0b0b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]) : ((db0b0b0b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b0b0b0BBBBBBBBBBLLy0){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                    } }))).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b0b0b0BBBBBBBBBBLLy0, "b0b0b0b0b0BBBBBBBBBBLLy0")));
                  } })).apply(Rt.BOX) : ((db0b0b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b0b0b0BBBBBBBBBBLLy0, "b0b0b0b0BBBBBBBBBBLLy0")));
                } })).apply(Rt.BOX) : ((db0b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db0b0b0BBBBBBBBBBLLy0.fields[0] })) : ((db0b0b0BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db0b0b0BBBBBBBBBBLLy0.fields[0], db0b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db0b0b0BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3b0b0b0BBBBBBBBBBLLy0){
                  final Rt.Data db3b0b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(db0b0b0BBBBBBBBBBLLy0.fields[0]));
                  return ((db3b0b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(db3b0b0b0BBBBBBBBBBLLy0.fields[0]))).apply(db0b0b0BBBBBBBBBBLLy0.fields[1]) : ((db3b0b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3b0b0b0BBBBBBBBBBLLy0.fields[0] }), db0b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3b0b0b0BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3b0b0b0BBBBBBBBBBLLy0.fields[0], db3b0b0b0BBBBBBBBBBLLy0.fields[1] }), db0b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3b0b0b0BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3b0b0b0BBBBBBBBBBLLy0.fields[0], db3b0b0b0BBBBBBBBBBLLy0.fields[1] }), db0b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3b0b0b0BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3b0b0b0BBBBBBBBBBLLy0.fields[0], db3b0b0b0BBBBBBBBBBLLy0.fields[1] }), db0b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3b0b0b0BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3b0b0b0BBBBBBBBBBLLy0.fields[0] }), db0b0b0BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3b0b0b0BBBBBBBBBBLLy0, "b3b0b0b0BBBBBBBBBBLLy0")))))));
                } })).apply(Rt.BOX) : ((db0b0b0BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db0b0b0BBBBBBBBBBLLy0.fields[0], db0b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db0b0b0BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db0b0b0BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db0b0b0BBBBBBBBBBLLy0, "b0b0b0BBBBBBBBBBLLy0")))))));
              } })).apply(Rt.BOX) : ((db0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0BBBBBBBBBBLLy0){
                final Rt.Data dAFFLAFFFb1b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0AFFLAFFFb1b0b0BBBBBBBBBBLLy0){
                  final Rt.Data db0AFFLAFFFb1b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                  return ((db0AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0){
                    final Rt.Data db0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                    return ((db0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]) : ((db0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                    } }))).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0, "b0b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0")));
                  } })).apply(Rt.BOX) : ((db0AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0AFFLAFFFb1b0b0BBBBBBBBBBLLy0, "b0AFFLAFFFb1b0b0BBBBBBBBBBLLy0")));
                } })).apply(Rt.BOX) : ((dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0] })) : ((dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0], dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3AFFLAFFFb1b0b0BBBBBBBBBBLLy0){
                  final Rt.Data db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0 = ((Rt.Data)(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0]));
                  return ((db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(0, new Object[]{ db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0] }), dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0] }), dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0], db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] }), dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0], db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] }), dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0], db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] }), dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0] }), dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3AFFLAFFFb1b0b0BBBBBBBBBBLLy0, "b3AFFLAFFFb1b0b0BBBBBBBBBBLLy0")))))));
                } })).apply(Rt.BOX) : ((dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0], dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[1] })) : ((dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dAFFLAFFFb1b0b0BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(dAFFLAFFFb1b0b0BBBBBBBBBBLLy0, "AFFLAFFFb1b0b0BBBBBBBBBBLLy0")))))))))).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
              } }))).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0BBBBBBBBBBLLy0, "b0b0BBBBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1b0BBBBBBBBBBLLy0){
              final Rt.Data dAFFAFFb1b0BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((dAFFAFFb1b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0AFFAFFb1b0BBBBBBBBBBLLy0){
                final Rt.Data db0AFFAFFb1b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                return ((db0AFFAFFb1b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0AFFAFFb1b0BBBBBBBBBBLLy0){
                  final Rt.Data db0b0AFFAFFb1b0BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                  return ((db0b0AFFAFFb1b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]) : ((db0b0AFFAFFb1b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0AFFAFFb1b0BBBBBBBBBBLLy0){
                    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                  } }))).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0AFFAFFb1b0BBBBBBBBBBLLy0, "b0b0AFFAFFb1b0BBBBBBBBBBLLy0")));
                } })).apply(Rt.BOX) : ((db0AFFAFFb1b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0AFFAFFb1b0BBBBBBBBBBLLy0, "b0AFFAFFb1b0BBBBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((dAFFAFFb1b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(1, new Object[]{ dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0] })) : ((dAFFAFFb1b0BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0], dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((dAFFAFFb1b0BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3AFFAFFb1b0BBBBBBBBBBLLy0){
                final Rt.Data db3AFFAFFb1b0BBBBBBBBBBLLy0 = ((Rt.Data)(dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0]));
                return ((db3AFFAFFb1b0BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(0, new Object[]{ db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[0] }), dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFAFFb1b0BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[0] }), dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFAFFb1b0BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[0], db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[1] }), dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFAFFb1b0BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[0], db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[1] }), dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFAFFb1b0BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[0], db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[1] }), dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((db3AFFAFFb1b0BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3AFFAFFb1b0BBBBBBBBBBLLy0.fields[0] }), dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3AFFAFFb1b0BBBBBBBBBBLLy0, "b3AFFAFFb1b0BBBBBBBBBBLLy0")))))));
              } })).apply(Rt.BOX) : ((dAFFAFFb1b0BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(4, new Object[]{ dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0], dAFFAFFb1b0BBBBBBBBBBLLy0.fields[1] })) : ((dAFFAFFb1b0BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(5, new Object[]{ dAFFAFFb1b0BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(dAFFAFFb1b0BBBBBBBBBBLLy0, "AFFAFFb1b0BBBBBBBBBBLLy0")))))))))).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
            } })).apply(Rt.BOX) : Rt.noBranch(db0BBBBBBBBBBLLy0, "b0BBBBBBBBBBLLy0")));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1BBBBBBBBBBLLy0){
            final Rt.Data db1BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db1BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b1BBBBBBBBBBLLy0){
              final Rt.Data db0b1BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b1BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b1BBBBBBBBBBLLy0){
                final Rt.Data db0b0b1BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0b1BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(db1BBBBBBBBBBLLy0.fields[0]) : ((db0b0b1BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b1BBBBBBBBBBLLy0){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] }))))).apply(db1BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                } }))).apply(db1BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b1BBBBBBBBBBLLy0, "b0b0b1BBBBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((db0b1BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] }))))).apply(db1BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db1BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b1BBBBBBBBBBLLy0, "b0b1BBBBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db1BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db1BBBBBBBBBBLLy0.fields[0] })) : ((db1BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db1BBBBBBBBBBLLy0.fields[0], db1BBBBBBBBBBLLy0.fields[1] })) : ((db1BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3b1BBBBBBBBBBLLy0){
              final Rt.Data db3b1BBBBBBBBBBLLy0 = ((Rt.Data)(db1BBBBBBBBBBLLy0.fields[0]));
              return ((db3b1BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(db3b1BBBBBBBBBBLLy0.fields[0]))).apply(db1BBBBBBBBBBLLy0.fields[1]) : ((db3b1BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3b1BBBBBBBBBBLLy0.fields[0] }), db1BBBBBBBBBBLLy0.fields[1] })) : ((db3b1BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3b1BBBBBBBBBBLLy0.fields[0], db3b1BBBBBBBBBBLLy0.fields[1] }), db1BBBBBBBBBBLLy0.fields[1] })) : ((db3b1BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3b1BBBBBBBBBBLLy0.fields[0], db3b1BBBBBBBBBBLLy0.fields[1] }), db1BBBBBBBBBBLLy0.fields[1] })) : ((db3b1BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3b1BBBBBBBBBBLLy0.fields[0], db3b1BBBBBBBBBBLLy0.fields[1] }), db1BBBBBBBBBBLLy0.fields[1] })) : ((db3b1BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3b1BBBBBBBBBBLLy0.fields[0] }), db1BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3b1BBBBBBBBBBLLy0, "b3b1BBBBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db1BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db1BBBBBBBBBBLLy0.fields[0], db1BBBBBBBBBBLLy0.fields[1] })) : ((db1BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db1BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db1BBBBBBBBBBLLy0, "b1BBBBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2BBBBBBBBBBLLy0){
            final Rt.Data db2BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db2BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b2BBBBBBBBBBLLy0){
              final Rt.Data db0b2BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b2BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b2BBBBBBBBBBLLy0){
                final Rt.Data db0b0b2BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0b2BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(db2BBBBBBBBBBLLy0.fields[0]) : ((db0b0b2BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b2BBBBBBBBBBLLy0){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] }))))).apply(db2BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                } }))).apply(db2BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b2BBBBBBBBBBLLy0, "b0b0b2BBBBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((db0b2BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] }))))).apply(db2BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db2BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b2BBBBBBBBBBLLy0, "b0b2BBBBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db2BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db2BBBBBBBBBBLLy0.fields[0] })) : ((db2BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db2BBBBBBBBBBLLy0.fields[0], db2BBBBBBBBBBLLy0.fields[1] })) : ((db2BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3b2BBBBBBBBBBLLy0){
              final Rt.Data db3b2BBBBBBBBBBLLy0 = ((Rt.Data)(db2BBBBBBBBBBLLy0.fields[0]));
              return ((db3b2BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(db3b2BBBBBBBBBBLLy0.fields[0]))).apply(db2BBBBBBBBBBLLy0.fields[1]) : ((db3b2BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3b2BBBBBBBBBBLLy0.fields[0] }), db2BBBBBBBBBBLLy0.fields[1] })) : ((db3b2BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3b2BBBBBBBBBBLLy0.fields[0], db3b2BBBBBBBBBBLLy0.fields[1] }), db2BBBBBBBBBBLLy0.fields[1] })) : ((db3b2BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3b2BBBBBBBBBBLLy0.fields[0], db3b2BBBBBBBBBBLLy0.fields[1] }), db2BBBBBBBBBBLLy0.fields[1] })) : ((db3b2BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3b2BBBBBBBBBBLLy0.fields[0], db3b2BBBBBBBBBBLLy0.fields[1] }), db2BBBBBBBBBBLLy0.fields[1] })) : ((db3b2BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3b2BBBBBBBBBBLLy0.fields[0] }), db2BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3b2BBBBBBBBBBLLy0, "b3b2BBBBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db2BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db2BBBBBBBBBBLLy0.fields[0], db2BBBBBBBBBBLLy0.fields[1] })) : ((db2BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db2BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db2BBBBBBBBBBLLy0, "b2BBBBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3BBBBBBBBBBLLy0){
            final Rt.Data db3BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db3BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b3BBBBBBBBBBLLy0){
              final Rt.Data db0b3BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b3BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b3BBBBBBBBBBLLy0){
                final Rt.Data db0b0b3BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0b3BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(db3BBBBBBBBBBLLy0.fields[0]) : ((db0b0b3BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b3BBBBBBBBBBLLy0){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] }))))).apply(db3BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                } }))).apply(db3BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b3BBBBBBBBBBLLy0, "b0b0b3BBBBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((db0b3BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] }))))).apply(db3BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db3BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b3BBBBBBBBBBLLy0, "b0b3BBBBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db3BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(1, new Object[]{ db3BBBBBBBBBBLLy0.fields[0] })) : ((db3BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(2, new Object[]{ db3BBBBBBBBBBLLy0.fields[0], db3BBBBBBBBBBLLy0.fields[1] })) : ((db3BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3b3BBBBBBBBBBLLy0){
              final Rt.Data db3b3BBBBBBBBBBLLy0 = ((Rt.Data)(db3BBBBBBBBBBLLy0.fields[0]));
              return ((db3b3BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(db3b3BBBBBBBBBBLLy0.fields[0]))).apply(db3BBBBBBBBBBLLy0.fields[1]) : ((db3b3BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3b3BBBBBBBBBBLLy0.fields[0] }), db3BBBBBBBBBBLLy0.fields[1] })) : ((db3b3BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3b3BBBBBBBBBBLLy0.fields[0], db3b3BBBBBBBBBBLLy0.fields[1] }), db3BBBBBBBBBBLLy0.fields[1] })) : ((db3b3BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3b3BBBBBBBBBBLLy0.fields[0], db3b3BBBBBBBBBBLLy0.fields[1] }), db3BBBBBBBBBBLLy0.fields[1] })) : ((db3b3BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3b3BBBBBBBBBBLLy0.fields[0], db3b3BBBBBBBBBBLLy0.fields[1] }), db3BBBBBBBBBBLLy0.fields[1] })) : ((db3b3BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3b3BBBBBBBBBBLLy0.fields[0] }), db3BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3b3BBBBBBBBBBLLy0, "b3b3BBBBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db3BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(4, new Object[]{ db3BBBBBBBBBBLLy0.fields[0], db3BBBBBBBBBBLLy0.fields[1] })) : ((db3BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBBLLy0)).apply(dBBBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(5, new Object[]{ db3BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db3BBBBBBBBBBLLy0, "b3BBBBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb4BBBBBBBBBBLLy0){
            final Rt.Data db4BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db4BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b4BBBBBBBBBBLLy0){
              final Rt.Data db0b4BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b4BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b4BBBBBBBBBBLLy0){
                final Rt.Data db0b0b4BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0b4BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(db4BBBBBBBBBBLLy0.fields[0]) : ((db0b0b4BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b4BBBBBBBBBBLLy0){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] }))))).apply(db4BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                } }))).apply(db4BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b4BBBBBBBBBBLLy0, "b0b0b4BBBBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((db0b4BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] }))))).apply(db4BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db4BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b4BBBBBBBBBBLLy0, "b0b4BBBBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db4BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db4BBBBBBBBBBLLy0.fields[0] })) : ((db4BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db4BBBBBBBBBBLLy0.fields[0], db4BBBBBBBBBBLLy0.fields[1] })) : ((db4BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3b4BBBBBBBBBBLLy0){
              final Rt.Data db3b4BBBBBBBBBBLLy0 = ((Rt.Data)(db4BBBBBBBBBBLLy0.fields[0]));
              return ((db3b4BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(db3b4BBBBBBBBBBLLy0.fields[0]))).apply(db4BBBBBBBBBBLLy0.fields[1]) : ((db3b4BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3b4BBBBBBBBBBLLy0.fields[0] }), db4BBBBBBBBBBLLy0.fields[1] })) : ((db3b4BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3b4BBBBBBBBBBLLy0.fields[0], db3b4BBBBBBBBBBLLy0.fields[1] }), db4BBBBBBBBBBLLy0.fields[1] })) : ((db3b4BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3b4BBBBBBBBBBLLy0.fields[0], db3b4BBBBBBBBBBLLy0.fields[1] }), db4BBBBBBBBBBLLy0.fields[1] })) : ((db3b4BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3b4BBBBBBBBBBLLy0.fields[0], db3b4BBBBBBBBBBLLy0.fields[1] }), db4BBBBBBBBBBLLy0.fields[1] })) : ((db3b4BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3b4BBBBBBBBBBLLy0.fields[0] }), db4BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3b4BBBBBBBBBBLLy0, "b3b4BBBBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db4BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db4BBBBBBBBBBLLy0.fields[0], db4BBBBBBBBBBLLy0.fields[1] })) : ((db4BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBBBLLy0.fields[0], dBBBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db4BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db4BBBBBBBBBBLLy0, "b4BBBBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb5BBBBBBBBBBLLy0){
            final Rt.Data db5BBBBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db5BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b5BBBBBBBBBBLLy0){
              final Rt.Data db0b5BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b5BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b5BBBBBBBBBBLLy0){
                final Rt.Data db0b0b5BBBBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5BBBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0b5BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(db5BBBBBBBBBBLLy0.fields[0]) : ((db0b0b5BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b5BBBBBBBBBBLLy0){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] }))))).apply(db5BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
                } }))).apply(db5BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b5BBBBBBBBBBLLy0, "b0b0b5BBBBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((db0b5BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] }))))).apply(db5BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db5BBBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b5BBBBBBBBBBLLy0, "b0b5BBBBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db5BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db5BBBBBBBBBBLLy0.fields[0] })) : ((db5BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db5BBBBBBBBBBLLy0.fields[0], db5BBBBBBBBBBLLy0.fields[1] })) : ((db5BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3b5BBBBBBBBBBLLy0){
              final Rt.Data db3b5BBBBBBBBBBLLy0 = ((Rt.Data)(db5BBBBBBBBBBLLy0.fields[0]));
              return ((db3b5BBBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(db3b5BBBBBBBBBBLLy0.fields[0]))).apply(db5BBBBBBBBBBLLy0.fields[1]) : ((db3b5BBBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(1, new Object[]{ db3b5BBBBBBBBBBLLy0.fields[0] }), db5BBBBBBBBBBLLy0.fields[1] })) : ((db3b5BBBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(2, new Object[]{ db3b5BBBBBBBBBBLLy0.fields[0], db3b5BBBBBBBBBBLLy0.fields[1] }), db5BBBBBBBBBBLLy0.fields[1] })) : ((db3b5BBBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(3, new Object[]{ db3b5BBBBBBBBBBLLy0.fields[0], db3b5BBBBBBBBBBLLy0.fields[1] }), db5BBBBBBBBBBLLy0.fields[1] })) : ((db3b5BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(4, new Object[]{ db3b5BBBBBBBBBBLLy0.fields[0], db3b5BBBBBBBBBBLLy0.fields[1] }), db5BBBBBBBBBBLLy0.fields[1] })) : ((db3b5BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ new Rt.Data(5, new Object[]{ db3b5BBBBBBBBBBLLy0.fields[0] }), db5BBBBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db3b5BBBBBBBBBBLLy0, "b3b5BBBBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db5BBBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db5BBBBBBBBBBLLy0.fields[0], db5BBBBBBBBBBLLy0.fields[1] })) : ((db5BBBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db5BBBBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db5BBBBBBBBBBLLy0, "b5BBBBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : Rt.noBranch(dBBBBBBBBBBLLy0, "BBBBBBBBBBLLy0")))))));
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c__Deriv_Expr__add(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Object lLLy0 = new Rt.Fn(){ public Object apply(Object pVLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVLLy0){
              return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c__Int__instAdd())))).apply(pVLLy0))).apply(pLVLLy0) });
            } };
          } };
          final Object lBLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLy0){
            return pVBLLy0;
          } };
          final Object lBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBLLy0){
            return pVBBLLy0;
          } };
          final Object lBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(new Rt.Data(0, new Object[]{ pLVBBBLLy0 })))).apply(pVBBBLLy0);
            } };
          } };
          final Object lBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c__Int__instAdd())))).apply(pVBBBBLLy0))).apply(pLVBBBBLLy0) })))).apply(pLLVBBBBLLy0);
              } };
            } };
          } };
          final Object lBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(new Rt.Data(0, new Object[]{ pLVBBBBBLLy0 })))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(pVBBBBBLLy0))).apply(pLLVBBBBBLLy0));
              } };
            } };
          } };
          final Object lBBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLVBBBBBBLLy0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(pVBBBBBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                  return Fix.this.f0(w0);
                } })).apply(pLVBBBBBBLLy0))).apply(pLLVBBBBBBLLy0));
              } };
            } };
          } };
          final Object lBBBBBBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBBBBBBLLy0){
              return new Rt.Data(2, new Object[]{ pVBBBBBBBLLy0, pLVBBBBBBBLLy0 });
            } };
          } };
          final Rt.Data dBBBBBBBBLLy0 = ((Rt.Data)(py0));
          return ((dBBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0BBBBBBBBLLy0){
            final Rt.Data db0BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0BBBBBBBBLLy0){
              final Rt.Data db0b0BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
              return ((db0b0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b0BBBBBBBBLLy0){
                final Rt.Data db0b0b0BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0b0BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                return ((db0b0b0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(db0b0BBBBBBBBLLy0.fields[0]) : ((db0b0b0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(db0b0BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db0b0BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b0b0BBBBBBBBLLy0, "b0b0b0BBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((db0b0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db0b0BBBBBBBBLLy0.fields[0] })) : ((db0b0BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2b0b0BBBBBBBBLLy0){
                final Rt.Data db2b0b0BBBBBBBBLLy0 = ((Rt.Data)(db0b0BBBBBBBBLLy0.fields[0]));
                return ((db2b0b0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(db2b0b0BBBBBBBBLLy0.fields[0]))).apply(db0b0BBBBBBBBLLy0.fields[1]) : ((db2b0b0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2b0b0BBBBBBBBLLy0.fields[0] }), db0b0BBBBBBBBLLy0.fields[1] })) : ((db2b0b0BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2b0b0BBBBBBBBLLy0.fields[0], db2b0b0BBBBBBBBLLy0.fields[1] }), db0b0BBBBBBBBLLy0.fields[1] })) : ((db2b0b0BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2b0b0BBBBBBBBLLy0.fields[0], db2b0b0BBBBBBBBLLy0.fields[1] }), db0b0BBBBBBBBLLy0.fields[1] })) : ((db2b0b0BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2b0b0BBBBBBBBLLy0.fields[0], db2b0b0BBBBBBBBLLy0.fields[1] }), db0b0BBBBBBBBLLy0.fields[1] })) : ((db2b0b0BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2b0b0BBBBBBBBLLy0.fields[0] }), db0b0BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2b0b0BBBBBBBBLLy0, "b2b0b0BBBBBBBBLLy0")))))));
              } })).apply(Rt.BOX) : ((db0b0BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db0b0BBBBBBBBLLy0.fields[0], db0b0BBBBBBBBLLy0.fields[1] })) : ((db0b0BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db0b0BBBBBBBBLLy0.fields[0], db0b0BBBBBBBBLLy0.fields[1] })) : ((db0b0BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(0, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db0b0BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db0b0BBBBBBBBLLy0, "b0b0BBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1b0BBBBBBBBLLy0){
              final Rt.Data dAFFAFFb1b0BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((dAFFAFFb1b0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0AFFAFFb1b0BBBBBBBBLLy0){
                final Rt.Data db0AFFAFFb1b0BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1b0BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
                return ((db0AFFAFFb1b0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(dAFFAFFb1b0BBBBBBBBLLy0.fields[0]) : ((db0AFFAFFb1b0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFAFFb1b0BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(dAFFAFFb1b0BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0AFFAFFb1b0BBBBBBBBLLy0, "b0AFFAFFb1b0BBBBBBBBLLy0")));
              } })).apply(Rt.BOX) : ((dAFFAFFb1b0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(1, new Object[]{ dAFFAFFb1b0BBBBBBBBLLy0.fields[0] })) : ((dAFFAFFb1b0BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2AFFAFFb1b0BBBBBBBBLLy0){
                final Rt.Data db2AFFAFFb1b0BBBBBBBBLLy0 = ((Rt.Data)(dAFFAFFb1b0BBBBBBBBLLy0.fields[0]));
                return ((db2AFFAFFb1b0BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(0, new Object[]{ db2AFFAFFb1b0BBBBBBBBLLy0.fields[0] }), dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((db2AFFAFFb1b0BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2AFFAFFb1b0BBBBBBBBLLy0.fields[0] }), dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((db2AFFAFFb1b0BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2AFFAFFb1b0BBBBBBBBLLy0.fields[0], db2AFFAFFb1b0BBBBBBBBLLy0.fields[1] }), dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((db2AFFAFFb1b0BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2AFFAFFb1b0BBBBBBBBLLy0.fields[0], db2AFFAFFb1b0BBBBBBBBLLy0.fields[1] }), dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((db2AFFAFFb1b0BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2AFFAFFb1b0BBBBBBBBLLy0.fields[0], db2AFFAFFb1b0BBBBBBBBLLy0.fields[1] }), dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((db2AFFAFFb1b0BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2AFFAFFb1b0BBBBBBBBLLy0.fields[0] }), dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2AFFAFFb1b0BBBBBBBBLLy0, "b2AFFAFFb1b0BBBBBBBBLLy0")))))));
              } })).apply(Rt.BOX) : ((dAFFAFFb1b0BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(3, new Object[]{ dAFFAFFb1b0BBBBBBBBLLy0.fields[0], dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((dAFFAFFb1b0BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(4, new Object[]{ dAFFAFFb1b0BBBBBBBBLLy0.fields[0], dAFFAFFb1b0BBBBBBBBLLy0.fields[1] })) : ((dAFFAFFb1b0BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(lBLLy0)).apply(new Rt.Data(5, new Object[]{ dAFFAFFb1b0BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(dAFFAFFb1b0BBBBBBBBLLy0, "AFFAFFb1b0BBBBBBBBLLy0")))))))))).apply(dBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(dBBBBBBBBLLy0.fields[0]))).apply(Rt.BOX);
            } })).apply(Rt.BOX) : Rt.noBranch(db0BBBBBBBBLLy0, "b0BBBBBBBBLLy0")));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1BBBBBBBBLLy0){
            final Rt.Data db1BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db1BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b1BBBBBBBBLLy0){
              final Rt.Data db0b1BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b1BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(db1BBBBBBBBLLy0.fields[0]) : ((db0b1BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] }))))).apply(db1BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db1BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b1BBBBBBBBLLy0, "b0b1BBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db1BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db1BBBBBBBBLLy0.fields[0] })) : ((db1BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2b1BBBBBBBBLLy0){
              final Rt.Data db2b1BBBBBBBBLLy0 = ((Rt.Data)(db1BBBBBBBBLLy0.fields[0]));
              return ((db2b1BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(db2b1BBBBBBBBLLy0.fields[0]))).apply(db1BBBBBBBBLLy0.fields[1]) : ((db2b1BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2b1BBBBBBBBLLy0.fields[0] }), db1BBBBBBBBLLy0.fields[1] })) : ((db2b1BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2b1BBBBBBBBLLy0.fields[0], db2b1BBBBBBBBLLy0.fields[1] }), db1BBBBBBBBLLy0.fields[1] })) : ((db2b1BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2b1BBBBBBBBLLy0.fields[0], db2b1BBBBBBBBLLy0.fields[1] }), db1BBBBBBBBLLy0.fields[1] })) : ((db2b1BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2b1BBBBBBBBLLy0.fields[0], db2b1BBBBBBBBLLy0.fields[1] }), db1BBBBBBBBLLy0.fields[1] })) : ((db2b1BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2b1BBBBBBBBLLy0.fields[0] }), db1BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2b1BBBBBBBBLLy0, "b2b1BBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db1BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db1BBBBBBBBLLy0.fields[0], db1BBBBBBBBLLy0.fields[1] })) : ((db1BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db1BBBBBBBBLLy0.fields[0], db1BBBBBBBBLLy0.fields[1] })) : ((db1BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(1, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db1BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db1BBBBBBBBLLy0, "b1BBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2BBBBBBBBLLy0){
            final Rt.Data db2BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db2BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b2BBBBBBBBLLy0){
              final Rt.Data db0b2BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b2BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(db2BBBBBBBBLLy0.fields[0]) : ((db0b2BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] }))))).apply(db2BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db2BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b2BBBBBBBBLLy0, "b0b2BBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db2BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(1, new Object[]{ db2BBBBBBBBLLy0.fields[0] })) : ((db2BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2b2BBBBBBBBLLy0){
              final Rt.Data db2b2BBBBBBBBLLy0 = ((Rt.Data)(db2BBBBBBBBLLy0.fields[0]));
              return ((db2b2BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(2, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(db2b2BBBBBBBBLLy0.fields[0]))).apply(db2BBBBBBBBLLy0.fields[1]) : ((db2b2BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2b2BBBBBBBBLLy0.fields[0] }), db2BBBBBBBBLLy0.fields[1] })) : ((db2b2BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2b2BBBBBBBBLLy0.fields[0], db2b2BBBBBBBBLLy0.fields[1] }), db2BBBBBBBBLLy0.fields[1] })) : ((db2b2BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2b2BBBBBBBBLLy0.fields[0], db2b2BBBBBBBBLLy0.fields[1] }), db2BBBBBBBBLLy0.fields[1] })) : ((db2b2BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2b2BBBBBBBBLLy0.fields[0], db2b2BBBBBBBBLLy0.fields[1] }), db2BBBBBBBBLLy0.fields[1] })) : ((db2b2BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2b2BBBBBBBBLLy0.fields[0] }), db2BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2b2BBBBBBBBLLy0, "b2b2BBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db2BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(3, new Object[]{ db2BBBBBBBBLLy0.fields[0], db2BBBBBBBBLLy0.fields[1] })) : ((db2BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(4, new Object[]{ db2BBBBBBBBLLy0.fields[0], db2BBBBBBBBLLy0.fields[1] })) : ((db2BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBBLLy0)).apply(dBBBBBBBBLLy0.fields[0]))).apply(dBBBBBBBBLLy0.fields[1]))).apply(new Rt.Data(5, new Object[]{ db2BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db2BBBBBBBBLLy0, "b2BBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3BBBBBBBBLLy0){
            final Rt.Data db3BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db3BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b3BBBBBBBBLLy0){
              final Rt.Data db0b3BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b3BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(db3BBBBBBBBLLy0.fields[0]) : ((db0b3BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] }))))).apply(db3BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db3BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b3BBBBBBBBLLy0, "b0b3BBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db3BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db3BBBBBBBBLLy0.fields[0] })) : ((db3BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2b3BBBBBBBBLLy0){
              final Rt.Data db2b3BBBBBBBBLLy0 = ((Rt.Data)(db3BBBBBBBBLLy0.fields[0]));
              return ((db2b3BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(db2b3BBBBBBBBLLy0.fields[0]))).apply(db3BBBBBBBBLLy0.fields[1]) : ((db2b3BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2b3BBBBBBBBLLy0.fields[0] }), db3BBBBBBBBLLy0.fields[1] })) : ((db2b3BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2b3BBBBBBBBLLy0.fields[0], db2b3BBBBBBBBLLy0.fields[1] }), db3BBBBBBBBLLy0.fields[1] })) : ((db2b3BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2b3BBBBBBBBLLy0.fields[0], db2b3BBBBBBBBLLy0.fields[1] }), db3BBBBBBBBLLy0.fields[1] })) : ((db2b3BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2b3BBBBBBBBLLy0.fields[0], db2b3BBBBBBBBLLy0.fields[1] }), db3BBBBBBBBLLy0.fields[1] })) : ((db2b3BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2b3BBBBBBBBLLy0.fields[0] }), db3BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2b3BBBBBBBBLLy0, "b2b3BBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db3BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db3BBBBBBBBLLy0.fields[0], db3BBBBBBBBLLy0.fields[1] })) : ((db3BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db3BBBBBBBBLLy0.fields[0], db3BBBBBBBBLLy0.fields[1] })) : ((db3BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(3, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db3BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db3BBBBBBBBLLy0, "b3BBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb4BBBBBBBBLLy0){
            final Rt.Data db4BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db4BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b4BBBBBBBBLLy0){
              final Rt.Data db0b4BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b4BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(db4BBBBBBBBLLy0.fields[0]) : ((db0b4BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] }))))).apply(db4BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db4BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b4BBBBBBBBLLy0, "b0b4BBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db4BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db4BBBBBBBBLLy0.fields[0] })) : ((db4BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2b4BBBBBBBBLLy0){
              final Rt.Data db2b4BBBBBBBBLLy0 = ((Rt.Data)(db4BBBBBBBBLLy0.fields[0]));
              return ((db2b4BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(db2b4BBBBBBBBLLy0.fields[0]))).apply(db4BBBBBBBBLLy0.fields[1]) : ((db2b4BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2b4BBBBBBBBLLy0.fields[0] }), db4BBBBBBBBLLy0.fields[1] })) : ((db2b4BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2b4BBBBBBBBLLy0.fields[0], db2b4BBBBBBBBLLy0.fields[1] }), db4BBBBBBBBLLy0.fields[1] })) : ((db2b4BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2b4BBBBBBBBLLy0.fields[0], db2b4BBBBBBBBLLy0.fields[1] }), db4BBBBBBBBLLy0.fields[1] })) : ((db2b4BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2b4BBBBBBBBLLy0.fields[0], db2b4BBBBBBBBLLy0.fields[1] }), db4BBBBBBBBLLy0.fields[1] })) : ((db2b4BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2b4BBBBBBBBLLy0.fields[0] }), db4BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2b4BBBBBBBBLLy0, "b2b4BBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db4BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db4BBBBBBBBLLy0.fields[0], db4BBBBBBBBLLy0.fields[1] })) : ((db4BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db4BBBBBBBBLLy0.fields[0], db4BBBBBBBBLLy0.fields[1] })) : ((db4BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(4, new Object[]{ dBBBBBBBBLLy0.fields[0], dBBBBBBBBLLy0.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db4BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db4BBBBBBBBLLy0, "b4BBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : ((dBBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb5BBBBBBBBLLy0){
            final Rt.Data db5BBBBBBBBLLy0 = ((Rt.Data)(pLy0));
            return ((db5BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b5BBBBBBBBLLy0){
              final Rt.Data db0b5BBBBBBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5BBBBBBBBLLy0.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b5BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(db5BBBBBBBBLLy0.fields[0]) : ((db0b5BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] }))))).apply(db5BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX)))).apply(db5BBBBBBBBLLy0.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b5BBBBBBBBLLy0, "b0b5BBBBBBBBLLy0")));
            } })).apply(Rt.BOX) : ((db5BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db5BBBBBBBBLLy0.fields[0] })) : ((db5BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2b5BBBBBBBBLLy0){
              final Rt.Data db2b5BBBBBBBBLLy0 = ((Rt.Data)(db5BBBBBBBBLLy0.fields[0]));
              return ((db2b5BBBBBBBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(db2b5BBBBBBBBLLy0.fields[0]))).apply(db5BBBBBBBBLLy0.fields[1]) : ((db2b5BBBBBBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(1, new Object[]{ db2b5BBBBBBBBLLy0.fields[0] }), db5BBBBBBBBLLy0.fields[1] })) : ((db2b5BBBBBBBBLLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(2, new Object[]{ db2b5BBBBBBBBLLy0.fields[0], db2b5BBBBBBBBLLy0.fields[1] }), db5BBBBBBBBLLy0.fields[1] })) : ((db2b5BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(3, new Object[]{ db2b5BBBBBBBBLLy0.fields[0], db2b5BBBBBBBBLLy0.fields[1] }), db5BBBBBBBBLLy0.fields[1] })) : ((db2b5BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(4, new Object[]{ db2b5BBBBBBBBLLy0.fields[0], db2b5BBBBBBBBLLy0.fields[1] }), db5BBBBBBBBLLy0.fields[1] })) : ((db2b5BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(2, new Object[]{ new Rt.Data(5, new Object[]{ db2b5BBBBBBBBLLy0.fields[0] }), db5BBBBBBBBLLy0.fields[1] })) : Rt.noBranch(db2b5BBBBBBBBLLy0, "b2b5BBBBBBBBLLy0")))))));
            } })).apply(Rt.BOX) : ((db5BBBBBBBBLLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db5BBBBBBBBLLy0.fields[0], db5BBBBBBBBLLy0.fields[1] })) : ((db5BBBBBBBBLLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db5BBBBBBBBLLy0.fields[0], db5BBBBBBBBLLy0.fields[1] })) : ((db5BBBBBBBBLLy0.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBBBBLLy0)).apply(new Rt.Data(5, new Object[]{ dBBBBBBBBLLy0.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db5BBBBBBBBLLy0.fields[0] })) : Rt.noBranch(db5BBBBBBBBLLy0, "b5BBBBBBBBLLy0")))))));
          } })).apply(Rt.BOX) : Rt.noBranch(dBBBBBBBBLLy0, "BBBBBBBBLLy0")))))));
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c__Int__instAdd(){
    return new Rt.Data(0, new Object[]{ c__Int__add() });
  }
  public static Object c__Int__add(){
    return Rt.INT_ADD_LONG;
  }
  public static Object c___instDecidableEqNat(){
    return c__Nat__decEq();
  }
  public static Object c__Nat__decEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object c__Deriv_Expr__nest(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__nestAux())).apply(pL))).apply(p))).apply(pL))).apply(pLL);
        } };
      } };
    } };
  }
  public static Object c__Deriv_Expr__nestAux(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          return new Rt.Fn(){ public Object apply(Object pLLy0){
            return new Rt.Fn(){ public Object apply(Object pLLLy0){
              final Object lLLLLy0 = new Rt.Fn(){ public Object apply(Object pVLLLLy0){
                return pVLLLLy0;
              } };
              final Object lBLLLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLLLy0){
                return new Rt.Fn(){ public Object apply(Object pLVBLLLLy0){
                  return new Rt.Fn(){ public Object apply(Object pLLVBLLLLy0){
                    return new Rt.Fn(){ public Object apply(Object pLLLVBLLLLy0){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                        return Fix.this.f0(w0);
                      } })).apply(py0))).apply(pLy0))).apply(pLVBLLLLy0))).apply(((Rt.Fn)(((Rt.Fn)(pLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HSub__hSub())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHSub())).apply(Rt.BOX))).apply(c___instSubNat())))).apply(py0))).apply(pVBLLLLy0)))).apply(pLLLVBLLLLy0));
                    } };
                  } };
                } };
              } };
              final Object lBBLLLLy0 = pLLy0;
              final Rt.Data dBBBLLLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lBBLLLLy0))).apply(Long.valueOf(0L))));
              return ((dBBBLLLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0BBBLLLLy0){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(lBLLLLy0)).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__add())).apply(pFb0BBBLLLLy0))).apply(Long.valueOf(1L))))).apply(pFb0BBBLLLLy0))).apply(Rt.BOX))).apply(pLLLy0);
              } })).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__sub())).apply(lBBLLLLy0))).apply(Long.valueOf(1L))) : ((dBBBLLLLy0.tag == 1) ? ((Rt.Fn)(lLLLLy0)).apply(pLLLy0) : Rt.noBranch(dBBBLLLLy0, "BBBLLLLy0")));
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
  public static Object c__Nat__beq(){
    return Rt.PRIM_EQB_LONG;
  }
  // inductive c___Nat: erased; values use Data(tag, fields)
  // inductive c___Bool: erased; values use Data(tag, fields)
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
  public static Object c__Deriv_Expr__count(){
    class Fix {
      public Object f0(Object py0){
        final Object lLy0 = new Rt.Fn(){ public Object apply(Object pVLy0){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)));
        } };
        final Object lBLy0 = new Rt.Fn(){ public Object apply(Object pVBLy0){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)));
        } };
        final Object lBBLy0 = new Rt.Fn(){ public Object apply(Object pVBBLy0){
          return new Rt.Fn(){ public Object apply(Object pLVBBLy0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c___instAddNat())))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(pVBBLy0)))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(pLVBBLy0));
          } };
        } };
        final Object lBBBLy0 = new Rt.Fn(){ public Object apply(Object pVBBBLy0){
          return new Rt.Fn(){ public Object apply(Object pLVBBBLy0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c___instAddNat())))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(pVBBBLy0)))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(pLVBBBLy0));
          } };
        } };
        final Object lBBBBLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBLy0){
          return new Rt.Fn(){ public Object apply(Object pLVBBBBLy0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HAdd__hAdd())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHAdd())).apply(Rt.BOX))).apply(c___instAddNat())))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(pVBBBBLy0)))).apply(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
              return Fix.this.f0(w0);
            } })).apply(pLVBBBBLy0));
          } };
        } };
        final Object lBBBBBLy0 = new Rt.Fn(){ public Object apply(Object pVBBBBBLy0){
          return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
            return Fix.this.f0(w0);
          } })).apply(pVBBBBBLy0);
        } };
        final Rt.Data dBBBBBBLy0 = ((Rt.Data)(py0));
        return ((dBBBBBBLy0.tag == 0) ? ((Rt.Fn)(lLy0)).apply(dBBBBBBLy0.fields[0]) : ((dBBBBBBLy0.tag == 1) ? ((Rt.Fn)(lBLy0)).apply(dBBBBBBLy0.fields[0]) : ((dBBBBBBLy0.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBLy0)).apply(dBBBBBBLy0.fields[0]))).apply(dBBBBBBLy0.fields[1]) : ((dBBBBBBLy0.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBLy0)).apply(dBBBBBBLy0.fields[0]))).apply(dBBBBBBLy0.fields[1]) : ((dBBBBBBLy0.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLy0)).apply(dBBBBBBLy0.fields[0]))).apply(dBBBBBBLy0.fields[1]) : ((dBBBBBBLy0.tag == 5) ? ((Rt.Fn)(lBBBBBLy0)).apply(dBBBBBBLy0.fields[0]) : Rt.noBranch(dBBBBBBLy0, "BBBBBBLy0")))))));
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c___instAddNat(){
    return new Rt.Data(0, new Object[]{ c__Nat__add() });
  }
  public static Object c__Nat__add(){
    return Rt.PRIM_ADD_LONG;
  }
  public static Object c___instHAdd(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Add__add())).apply(Rt.BOX))).apply(pL))).apply(pc0LL))).apply(pLc0LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Add__add(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Add: erased; values use Data(tag, fields)
  public static Object c__HAdd__hAdd(){
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
  // inductive c___HAdd: erased; values use Data(tag, fields)
  public static Object c___instOfNatNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ p });
    } };
  }
  public static Object c__Deriv_Expr__pow(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Object lLL = new Rt.Fn(){ public Object apply(Object pVLL){
          return new Rt.Fn(){ public Object apply(Object pLVLL){
            return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(c__Deriv_Expr__pown())).apply(pVLL))).apply(pLVLL) });
          } };
        } };
        final Object lBLL = new Rt.Fn(){ public Object apply(Object pVBLL){
          return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))) });
        } };
        final Object lBBLL = new Rt.Fn(){ public Object apply(Object pVBBLL){
          return pVBBLL;
        } };
        final Object lBBBLL = new Rt.Fn(){ public Object apply(Object pVBBBLL){
          return new Rt.Data(0, new Object[]{ ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))) });
        } };
        final Object lBBBBLL = new Rt.Fn(){ public Object apply(Object pVBBBBLL){
          return new Rt.Fn(){ public Object apply(Object pLVBBBBLL){
            return new Rt.Data(4, new Object[]{ pVBBBBLL, pLVBBBBLL });
          } };
        } };
        final Rt.Data dBBBBBLL = ((Rt.Data)(p));
        return ((dBBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0BBBBBLL){
          final Rt.Data db0BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dBBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
          return ((db0BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0BBBBBLL){
            final Rt.Data db0b0BBBBBLL = ((Rt.Data)(pL));
            return ((db0b0BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b0BBBBBLL){
              final Rt.Data db0b0b0BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0b0BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0b0b0BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b0b0BBBBBLL){
                final Rt.Data db0b0b0b0BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db0b0BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0b0b0BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLL)).apply(dBBBBBLL.fields[0]))).apply(db0b0BBBBBLL.fields[0]) : ((db0b0b0b0BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b0b0BBBBBLL){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(dBBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(db0b0BBBBBLL.fields[0]))).apply(Rt.BOX);
                } }))).apply(db0b0BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b0b0BBBBBLL, "b0b0b0b0BBBBBLL")));
              } })).apply(Rt.BOX) : ((db0b0b0BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(dBBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(db0b0BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db0b0BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b0b0BBBBBLL, "b0b0b0BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0b0BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db0b0BBBBBLL.fields[0] })) : ((db0b0BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db0b0BBBBBLL.fields[0], db0b0BBBBBLL.fields[1] })) : ((db0b0BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db0b0BBBBBLL.fields[0], db0b0BBBBBLL.fields[1] })) : ((db0b0BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db0b0BBBBBLL.fields[0], db0b0BBBBBLL.fields[1] })) : ((db0b0BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(0, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db0b0BBBBBLL.fields[0] })) : Rt.noBranch(db0b0BBBBBLL, "b0b0BBBBBLL")))))));
          } })).apply(Rt.BOX) : ((db0BBBBBLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1b0BBBBBLL){
            final Rt.Data dAFFAFFb1b0BBBBBLL = ((Rt.Data)(pL));
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((dAFFAFFb1b0BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0AFFAFFb1b0BBBBBLL){
              final Rt.Data db0AFFAFFb1b0BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1b0BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((db0AFFAFFb1b0BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0AFFAFFb1b0BBBBBLL){
                final Rt.Data db0b0AFFAFFb1b0BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(dAFFAFFb1b0BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
                return ((db0b0AFFAFFb1b0BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lLL)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(dAFFAFFb1b0BBBBBLL.fields[0]) : ((db0b0AFFAFFb1b0BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0AFFAFFb1b0BBBBBLL){
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))))).apply(dAFFAFFb1b0BBBBBLL.fields[0]))).apply(Rt.BOX);
                } }))).apply(dAFFAFFb1b0BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0AFFAFFb1b0BBBBBLL, "b0b0AFFAFFb1b0BBBBBLL")));
              } })).apply(Rt.BOX) : ((db0AFFAFFb1b0BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(lLL)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))))).apply(dAFFAFFb1b0BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(dAFFAFFb1b0BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0AFFAFFb1b0BBBBBLL, "b0AFFAFFb1b0BBBBBLL")));
            } })).apply(Rt.BOX) : ((dAFFAFFb1b0BBBBBLL.tag == 1) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(1, new Object[]{ dAFFAFFb1b0BBBBBLL.fields[0] })) : ((dAFFAFFb1b0BBBBBLL.tag == 2) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(2, new Object[]{ dAFFAFFb1b0BBBBBLL.fields[0], dAFFAFFb1b0BBBBBLL.fields[1] })) : ((dAFFAFFb1b0BBBBBLL.tag == 3) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(3, new Object[]{ dAFFAFFb1b0BBBBBLL.fields[0], dAFFAFFb1b0BBBBBLL.fields[1] })) : ((dAFFAFFb1b0BBBBBLL.tag == 4) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(4, new Object[]{ dAFFAFFb1b0BBBBBLL.fields[0], dAFFAFFb1b0BBBBBLL.fields[1] })) : ((dAFFAFFb1b0BBBBBLL.tag == 5) ? ((Rt.Fn)(lBBBLL)).apply(new Rt.Data(5, new Object[]{ dAFFAFFb1b0BBBBBLL.fields[0] })) : Rt.noBranch(dAFFAFFb1b0BBBBBLL, "AFFAFFb1b0BBBBBLL")))))))))).apply(dBBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(dBBBBBLL.fields[0]))).apply(Rt.BOX);
          } })).apply(Rt.BOX) : Rt.noBranch(db0BBBBBLL, "b0BBBBBLL")));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb1BBBBBLL){
          final Rt.Data db1BBBBBLL = ((Rt.Data)(pL));
          return ((db1BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b1BBBBBLL){
            final Rt.Data db0b1BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0b1BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b1BBBBBLL){
              final Rt.Data db0b0b1BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db1BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0b0b1BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(0, new Object[]{ db1BBBBBLL.fields[0] })) : ((db0b0b1BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b1BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db1BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db1BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b1BBBBBLL, "b0b0b1BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0b1BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db1BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db1BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b1BBBBBLL, "b0b1BBBBBLL")));
          } })).apply(Rt.BOX) : ((db1BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db1BBBBBLL.fields[0] })) : ((db1BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db1BBBBBLL.fields[0], db1BBBBBLL.fields[1] })) : ((db1BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db1BBBBBLL.fields[0], db1BBBBBLL.fields[1] })) : ((db1BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db1BBBBBLL.fields[0], db1BBBBBLL.fields[1] })) : ((db1BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(1, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db1BBBBBLL.fields[0] })) : Rt.noBranch(db1BBBBBLL, "b1BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 2) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb2BBBBBLL){
          final Rt.Data db2BBBBBLL = ((Rt.Data)(pL));
          return ((db2BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b2BBBBBLL){
            final Rt.Data db0b2BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0b2BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b2BBBBBLL){
              final Rt.Data db0b0b2BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db2BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0b0b2BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(0, new Object[]{ db2BBBBBLL.fields[0] })) : ((db0b0b2BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b2BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db2BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db2BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b2BBBBBLL, "b0b0b2BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0b2BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db2BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db2BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b2BBBBBLL, "b0b2BBBBBLL")));
          } })).apply(Rt.BOX) : ((db2BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db2BBBBBLL.fields[0] })) : ((db2BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db2BBBBBLL.fields[0], db2BBBBBLL.fields[1] })) : ((db2BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db2BBBBBLL.fields[0], db2BBBBBLL.fields[1] })) : ((db2BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db2BBBBBLL.fields[0], db2BBBBBLL.fields[1] })) : ((db2BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(2, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db2BBBBBLL.fields[0] })) : Rt.noBranch(db2BBBBBLL, "b2BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 3) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb3BBBBBLL){
          final Rt.Data db3BBBBBLL = ((Rt.Data)(pL));
          return ((db3BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b3BBBBBLL){
            final Rt.Data db0b3BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0b3BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b3BBBBBLL){
              final Rt.Data db0b0b3BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db3BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0b0b3BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(0, new Object[]{ db3BBBBBLL.fields[0] })) : ((db0b0b3BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b3BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db3BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db3BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b3BBBBBLL, "b0b0b3BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0b3BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db3BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db3BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b3BBBBBLL, "b0b3BBBBBLL")));
          } })).apply(Rt.BOX) : ((db3BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db3BBBBBLL.fields[0] })) : ((db3BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db3BBBBBLL.fields[0], db3BBBBBLL.fields[1] })) : ((db3BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db3BBBBBLL.fields[0], db3BBBBBLL.fields[1] })) : ((db3BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db3BBBBBLL.fields[0], db3BBBBBLL.fields[1] })) : ((db3BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(3, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db3BBBBBLL.fields[0] })) : Rt.noBranch(db3BBBBBLL, "b3BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 4) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb4BBBBBLL){
          final Rt.Data db4BBBBBLL = ((Rt.Data)(pL));
          return ((db4BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b4BBBBBLL){
            final Rt.Data db0b4BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0b4BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b4BBBBBLL){
              final Rt.Data db0b0b4BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db4BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0b0b4BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(0, new Object[]{ db4BBBBBLL.fields[0] })) : ((db0b0b4BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b4BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db4BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db4BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b4BBBBBLL, "b0b0b4BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0b4BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] }))))).apply(db4BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db4BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b4BBBBBLL, "b0b4BBBBBLL")));
          } })).apply(Rt.BOX) : ((db4BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(1, new Object[]{ db4BBBBBLL.fields[0] })) : ((db4BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(2, new Object[]{ db4BBBBBLL.fields[0], db4BBBBBLL.fields[1] })) : ((db4BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(3, new Object[]{ db4BBBBBLL.fields[0], db4BBBBBLL.fields[1] })) : ((db4BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(4, new Object[]{ db4BBBBBLL.fields[0], db4BBBBBLL.fields[1] })) : ((db4BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(4, new Object[]{ dBBBBBLL.fields[0], dBBBBBLL.fields[1] })))).apply(new Rt.Data(5, new Object[]{ db4BBBBBLL.fields[0] })) : Rt.noBranch(db4BBBBBLL, "b4BBBBBLL")))))));
        } })).apply(Rt.BOX) : ((dBBBBBLL.tag == 5) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb5BBBBBLL){
          final Rt.Data db5BBBBBLL = ((Rt.Data)(pL));
          return ((db5BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b5BBBBBLL){
            final Rt.Data db0b5BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
            return ((db0b5BBBBBLL.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0b0b5BBBBBLL){
              final Rt.Data db0b0b5BBBBBLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(db5BBBBBLL.fields[0]))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
              return ((db0b0b5BBBBBLL.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(0, new Object[]{ db5BBBBBLL.fields[0] })) : ((db0b0b5BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0b0b5BBBBBLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db5BBBBBLL.fields[0]))).apply(Rt.BOX);
              } }))).apply(db5BBBBBLL.fields[0]))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0b0b5BBBBBLL, "b0b0b5BBBBBLL")));
            } })).apply(Rt.BOX) : ((db0b5BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] }))))).apply(db5BBBBBLL.fields[0]))).apply(Rt.BOX)))).apply(db5BBBBBLL.fields[0]))).apply(Rt.BOX) : Rt.noBranch(db0b5BBBBBLL, "b0b5BBBBBLL")));
          } })).apply(Rt.BOX) : ((db5BBBBBLL.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(1, new Object[]{ db5BBBBBLL.fields[0] })) : ((db5BBBBBLL.tag == 2) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(2, new Object[]{ db5BBBBBLL.fields[0], db5BBBBBLL.fields[1] })) : ((db5BBBBBLL.tag == 3) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(3, new Object[]{ db5BBBBBLL.fields[0], db5BBBBBLL.fields[1] })) : ((db5BBBBBLL.tag == 4) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(4, new Object[]{ db5BBBBBLL.fields[0], db5BBBBBLL.fields[1] })) : ((db5BBBBBLL.tag == 5) ? ((Rt.Fn)(((Rt.Fn)(lBBBBLL)).apply(new Rt.Data(5, new Object[]{ dBBBBBLL.fields[0] })))).apply(new Rt.Data(5, new Object[]{ db5BBBBBLL.fields[0] })) : Rt.noBranch(db5BBBBBLL, "b5BBBBBLL")))))));
        } })).apply(Rt.BOX) : Rt.noBranch(dBBBBBLL, "BBBBBLL")))))));
      } };
    } };
  }
  public static Object c__Deriv_Expr__pown(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          final Object lLLy0 = new Rt.Fn(){ public Object apply(Object pVLLy0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)));
          } };
          final Object lBLLy0 = new Rt.Fn(){ public Object apply(Object pVBLLy0){
            return pVBLLy0;
          } };
          final Object lBBLLy0 = new Rt.Fn(){ public Object apply(Object pVBBLLy0){
            return new Rt.Fn(){ public Object apply(Object pLVBBLLy0){
              final Object lLLVBBLLy0 = ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                return Fix.this.f0(w0);
              } })).apply(pVBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HDiv__hDiv())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHDiv())).apply(Rt.BOX))).apply(c__Int__instDiv())))).apply(pLVBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(2L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(2L)))));
              final Rt.Data dABLLVBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMod__hMod())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMod())).apply(Rt.BOX))).apply(c__Int__instMod())))).apply(pLVBBLLy0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(2L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(2L))))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__HMul__hMul())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instHMul())).apply(Rt.BOX))).apply(c__Int__instMul())))).apply(lLLVBBLLy0))).apply(lLLVBBLLy0)))).apply(((dABLLVBBLLy0.tag == 0) ? pVBBLLy0 : ((dABLLVBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))) : Rt.noBranch(dABLLVBBLLy0, "ABLLVBBLLy0"))));
            } };
          } };
          final Rt.Data dBBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(pLy0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L))))));
          return ((dBBBLLy0.tag == 0) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object tb0BBBLLy0){
            final Rt.Data db0BBBLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Int__instDecidableEq())).apply(pLy0))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L))))));
            return ((db0BBBLLy0.tag == 0) ? ((Rt.Fn)(((Rt.Fn)(lBBLLy0)).apply(py0))).apply(pLy0) : ((db0BBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(new Rt.Fn(){ public Object apply(Object pAFFFb1b0BBBLLy0){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(1L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lBLLy0)).apply(py0)))).apply(pLy0))).apply(Rt.BOX);
            } }))).apply(pLy0))).apply(Rt.BOX))).apply(Rt.BOX) : Rt.noBranch(db0BBBLLy0, "b0BBBLLy0")));
          } })).apply(Rt.BOX) : ((dBBBLLy0.tag == 1) ? ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__ndrec())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNat())).apply(Long.valueOf(0L)))))).apply(Rt.BOX))).apply(((Rt.Fn)(lLLy0)).apply(py0)))).apply(pLy0))).apply(Rt.BOX)))).apply(pLy0))).apply(Rt.BOX) : Rt.noBranch(dBBBLLy0, "BBBLLy0")));
        } };
      }
    }
    final Fix z = new Fix();
    return new Rt.Fn(){ public Object apply(Object w0){
      return z.f0(w0);
    } };
  }
  public static Object c__Eq__ndrec(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Eq__rec())).apply(Rt.BOX))).apply(pL))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(Rt.BOX);
              } };
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c__Eq__rec(){
    return Rt.EQ_REC;
  }
  // inductive c___Decidable: erased; values use Data(tag, fields)
  public static Object c__Int__instMod(){
    return new Rt.Data(0, new Object[]{ c__Int__emod() });
  }
  public static Object c__Int__emod(){
    return Rt.INT_EMOD_LONG;
  }
  public static Object c___instHMod(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Mod__mod())).apply(Rt.BOX))).apply(pL))).apply(pc0LL))).apply(pLc0LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Mod__mod(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Mod: erased; values use Data(tag, fields)
  public static Object c__HMod__hMod(){
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
  // inductive c___HMod: erased; values use Data(tag, fields)
  public static Object c__Int__instDecidableEq(){
    return c__Int__decEq();
  }
  public static Object c__Int__decEq(){
    return Rt.INT_DEC_EQ_LONG;
  }
  public static Object c__Int__instMul(){
    return new Rt.Data(0, new Object[]{ c__Int__mul() });
  }
  public static Object c__Int__mul(){
    return Rt.INT_MUL_LONG;
  }
  public static Object c___instHMul(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Mul__mul())).apply(Rt.BOX))).apply(pL))).apply(pc0LL))).apply(pLc0LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Mul__mul(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Mul: erased; values use Data(tag, fields)
  public static Object c__HMul__hMul(){
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
  // inductive c___HMul: erased; values use Data(tag, fields)
  public static Object c__Int__instDiv(){
    return new Rt.Data(0, new Object[]{ c__Int__ediv() });
  }
  public static Object c__Int__ediv(){
    return Rt.INT_EDIV_LONG;
  }
  public static Object c___instHDiv(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Div__div())).apply(Rt.BOX))).apply(pL))).apply(pc0LL))).apply(pLc0LL);
          } };
        } } });
      } };
    } };
  }
  public static Object c__Div__div(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        return ((dLL.tag == 0) ? dLL.fields[0] : Rt.noBranch(dLL, "LL"));
      } };
    } };
  }
  // inductive c___Div: erased; values use Data(tag, fields)
  public static Object c__HDiv__hDiv(){
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
  // inductive c___HDiv: erased; values use Data(tag, fields)
  public static Object c___instOfNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ ((Rt.Fn)(c__Int__ofNat())).apply(p) });
    } };
  }
  // inductive c___Int: erased; values use Data(tag, fields)
  public static Object c__Int__negSucc(){
    return Rt.INT_NEG_SUCC_LONG;
  }
  public static Object c__Int__ofNat(){
    return Rt.INT_OF_NAT;
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
  // inductive c___Deriv_u46Expr: erased; values use Data(tag, fields)
  public static Object body(){
    return c___suite_deriv();
  }
}

public final class Prog {
  public static Object c_Map_Tests_Peregrine__ys(){
    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c_ListDef_Lists_Corelib__map())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c_Map_Tests_Peregrine__double()))).apply(c_Map_Tests_Peregrine__xs());
  }
  public static Object c_Map_Tests_Peregrine__xs(){
    return new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }), new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }) }) }) }), new Rt.Data(0, new Object[]{  }) }) }) });
  }
  public static Object c_Map_Tests_Peregrine__double(){
    return new Rt.Fn(){ public Object apply(Object p){
      class FixFL {
        public Object f0(Object py0FL){
          final Rt.Data dLy0FL = ((Rt.Data)(py0FL));
          Object rLy0FL;
          switch (dLy0FL.tag) {
            case 0: {
              rLy0FL = new Rt.Data(0, new Object[]{  });
              break;
            }
            case 1: {
              final Object g0b1Ly0FL = dLy0FL.fields[0];
              rLy0FL = new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
                return FixFL.this.f0(w0FL);
              } })).apply(g0b1Ly0FL) }) });
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rLy0FL;
        }
      }
      final FixFL zFL = new FixFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
        return zFL.f0(w0FL);
      } })).apply(p);
    } };
  }
  // inductive c_Datatypes_Init_Corelib__nat: erased; values use Data(tag, fields)
  public static Object c_ListDef_Lists_Corelib__map(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            class FixFLLLL {
              public Object f0(Object py0FLLLL){
                final Rt.Data dLy0FLLLL = ((Rt.Data)(py0FLLLL));
                Object rLy0FLLLL;
                switch (dLy0FLLLL.tag) {
                  case 0: {
                    rLy0FLLLL = new Rt.Data(0, new Object[]{  });
                    break;
                  }
                  case 1: {
                    final Object g0b1Ly0FLLLL = dLy0FLLLL.fields[0];
                    final Object g1b1Ly0FLLLL = dLy0FLLLL.fields[1];
                    rLy0FLLLL = new Rt.Data(1, new Object[]{ ((Rt.Fn)(pLL)).apply(g0b1Ly0FLLLL), ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FLLLL){
                      return FixFLLLL.this.f0(w0FLLLL);
                    } })).apply(g1b1Ly0FLLLL) });
                    break;
                  }
                  default: {
                    throw new RuntimeException("no matching branch");
                  }
                }
                return rLy0FLLLL;
              }
            }
            final FixFLLLL zFLLLL = new FixFLLLL();
            return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FLLLL){
              return zFLLLL.f0(w0FLLLL);
            } })).apply(pLLL);
          } };
        } };
      } };
    } };
  }
  // inductive c_Datatypes_Init_Corelib__list: erased; values use Data(tag, fields)
  public static Object body(){
    return c_Map_Tests_Peregrine__ys();
  }
}

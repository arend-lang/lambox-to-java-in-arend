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
          return ((dLy0FL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLy0FL.tag == 1) ? new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
            return FixFL.this.f0(w0FL);
          } })).apply(dLy0FL.fields[0]) }) }) : Rt.noBranch(dLy0FL, "Ly0FL")));
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
                return ((dLy0FLLLL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLy0FLLLL.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(pLL)).apply(dLy0FLLLL.fields[0]), ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FLLLL){
                  return FixFLLLL.this.f0(w0FLLLL);
                } })).apply(dLy0FLLLL.fields[1]) }) : Rt.noBranch(dLy0FLLLL, "Ly0FLLLL")));
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

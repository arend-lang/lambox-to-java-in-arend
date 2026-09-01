public final class Prog {
  public static Object c_Nat_Tests_Peregrine__thing(){
    return ((Rt.Fn)(((Rt.Fn)(c_Nat_Init_Corelib__add())).apply(new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) })))).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }));
  }
  public static Object c_Nat_Init_Corelib__add(){
    return new Rt.Fn(){ public Object apply(Object p){
      class FixFL {
        public Object f0(Object py0FL){
          return new Rt.Fn(){ public Object apply(Object pLy0FL){
            final Rt.Data dLLy0FL = ((Rt.Data)(py0FL));
            return ((dLLy0FL.tag == 0) ? pLy0FL : ((dLLy0FL.tag == 1) ? new Rt.Data(1, new Object[]{ ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
              return FixFL.this.f0(w0FL);
            } })).apply(dLLy0FL.fields[0]))).apply(pLy0FL) }) : Rt.noBranch(dLLy0FL, "LLy0FL")));
          } };
        }
      }
      final FixFL zFL = new FixFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
        return zFL.f0(w0FL);
      } })).apply(p);
    } };
  }
  // inductive c_Datatypes_Init_Corelib__nat: erased; values use Data(tag, fields)
  public static Object body(){
    return c_Nat_Tests_Peregrine__thing();
  }
}

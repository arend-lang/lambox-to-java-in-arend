public final class Prog {
  public static Object c_OddEven_Tests_Peregrine__test(){
    return ((Rt.Fn)(c_OddEven_Tests_Peregrine__odd())).apply(new Rt.Data(1, new Object[]{ new Rt.Data(1, new Object[]{ new Rt.Data(0, new Object[]{  }) }) }));
  }
  public static Object c_OddEven_Tests_Peregrine__odd(){
    return new Rt.Fn(){ public Object apply(Object p){
      class FixFL {
        public Object f0(Object py0FL){
          final Rt.Data dLy0FL = ((Rt.Data)(py0FL));
          return ((dLy0FL.tag == 0) ? new Rt.Data(0, new Object[]{  }) : ((dLy0FL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w1FL){
            return FixFL.this.f1(w1FL);
          } })).apply(dLy0FL.fields[0]) : Rt.noBranch(dLy0FL, "Ly0FL")));
        }
        public Object f1(Object py1FL){
          final Rt.Data dLy1FL = ((Rt.Data)(py1FL));
          return ((dLy1FL.tag == 0) ? new Rt.Data(1, new Object[]{  }) : ((dLy1FL.tag == 1) ? ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
            return FixFL.this.f0(w0FL);
          } })).apply(dLy1FL.fields[0]) : Rt.noBranch(dLy1FL, "Ly1FL")));
        }
      }
      final FixFL zFL = new FixFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
        return zFL.f0(w0FL);
      } })).apply(p);
    } };
  }
  // inductive c_OddEven_Tests_Peregrine__Bool: erased; values use Data(tag, fields)
  // inductive c_Datatypes_Init_Corelib__nat: erased; values use Data(tag, fields)
  public static Object body(){
    return c_OddEven_Tests_Peregrine__test();
  }
}

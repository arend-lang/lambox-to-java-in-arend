public final class Prog {
  public static Object c_Mutual_Tests_Peregrine__test(){
    return ((Rt.Fn)(c_Mutual_Tests_Peregrine__oddNat())).apply(new Rt.Data(0, new Object[]{ new Rt.Data(0, new Object[]{  }) }));
  }
  public static Object c_Mutual_Tests_Peregrine__oddNat(){
    return new Rt.Fn(){ public Object apply(Object p){
      class FixFL {
        public Object f0(Object py0FL){
          final Rt.Data dLy0FL = ((Rt.Data)(py0FL));
          Object rLy0FL;
          switch (dLy0FL.tag) {
            case 0: {
              final Object g0b0Ly0FL = dLy0FL.fields[0];
              rLy0FL = new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w1FL){
                return FixFL.this.f1(w1FL);
              } })).apply(g0b0Ly0FL) });
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rLy0FL;
        }
        public Object f1(Object py1FL){
          final Rt.Data dLy1FL = ((Rt.Data)(py1FL));
          Object rLy1FL;
          switch (dLy1FL.tag) {
            case 0: {
              rLy1FL = new Rt.Data(0, new Object[]{  });
              break;
            }
            case 1: {
              final Object g0b1Ly1FL = dLy1FL.fields[0];
              rLy1FL = new Rt.Data(1, new Object[]{ ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
                return FixFL.this.f0(w0FL);
              } })).apply(g0b1Ly1FL) });
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rLy1FL;
        }
      }
      final FixFL zFL = new FixFL();
      return ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0FL){
        return zFL.f0(w0FL);
      } })).apply(p);
    } };
  }
  // inductive c_Datatypes_Init_Corelib__nat: erased; values use Data(tag, fields)
  // inductive c_Mutual_Tests_Peregrine__Even: erased; values use Data(tag, fields)
  public static Object __main(){
    return c_Mutual_Tests_Peregrine__test();
  }
  public static void main(String[] args){
    Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
      return __main();
    } });
  }
}

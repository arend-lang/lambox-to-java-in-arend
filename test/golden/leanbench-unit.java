public final class Prog {
  public static Object c___suite_unit(){
    return ((Rt.Fn)(c___unit())).apply(c__Unit__unit());
  }
  public static Object c___unit(){
    return new Rt.Fn(){ public Object apply(Object p){
      return c__Unit__unit();
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  public static Object __main(){
    return c___suite_unit();
  }
  public static void main(String[] args){
    Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
      return __main();
    } });
  }
}

public final class Prog {
  public static Object c___suite_demo0(){
    return ((Rt.Fn)(c___demo0())).apply(c__Unit__unit());
  }
  public static Object c___demo0(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(1, new Object[]{ c__Unit__unit(), new Rt.Data(1, new Object[]{ c__Unit__unit(), new Rt.Data(1, new Object[]{ c__Unit__unit(), new Rt.Data(0, new Object[]{  }) }) }) });
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  // inductive c___List: erased; values use Data(tag, fields)
  public static Object __main(){
    return c___suite_demo0();
  }
  public static void main(String[] args){
    Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
      return __main();
    } });
  }
}

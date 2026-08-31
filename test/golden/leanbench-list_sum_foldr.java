public final class Prog {
  public static Object c___suite_list_sum_foldr(){
    return ((Rt.Fn)(c___list_sum_foldr())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(10L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(10L))));
  }
  public static Object c___list_sum_foldr(){
    return new Rt.Fn(){ public Object apply(Object p){
      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List__foldrTR())).apply(Rt.BOX))).apply(Rt.BOX))).apply(c__Nat__add()))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L)))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List__replicateTR())).apply(Rt.BOX))).apply(p))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(1L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(1L)))));
    } };
  }
  public static Object c__List__replicateTR(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__List_replicateTR__loop())).apply(Rt.BOX))).apply(pLL))).apply(pL))).apply(new Rt.Data(0, new Object[]{  }));
        } };
      } };
    } };
  }
  public static Object c__List_replicateTR__loop(){
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
                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                    return Fix.this.f0(w0);
                  } })).apply(Rt.BOX))).apply(pLy0))).apply(pVBLLLLy0))).apply(new Rt.Data(1, new Object[]{ pLy0, pLVBLLLLy0 }));
                } };
              } };
              final Object lBBLLLLy0 = pLLy0;
              final Rt.Data dBBBLLLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lBBLLLLy0))).apply(Long.valueOf(0L))));
              Object rBBBLLLLy0;
              switch (dBBBLLLLy0.tag) {
                case 0: {
                  rBBBLLLLy0 = ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0BBBLLLLy0){
                    return ((Rt.Fn)(((Rt.Fn)(lBLLLLy0)).apply(pFb0BBBLLLLy0))).apply(pLLLy0);
                  } })).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__sub())).apply(lBBLLLLy0))).apply(Long.valueOf(1L)));
                  break;
                }
                case 1: {
                  rBBBLLLLy0 = ((Rt.Fn)(lLLLLy0)).apply(pLLLy0);
                  break;
                }
                default: {
                  throw new RuntimeException("no matching branch");
                }
              }
              return rBBBLLLLy0;
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
  // inductive c___List: erased; values use Data(tag, fields)
  public static Object c__Nat__add(){
    return Rt.PRIM_ADD_LONG;
  }
  public static Object c__List__foldrTR(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array__foldr())).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLL))).apply(pLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__List__toArray())).apply(Rt.BOX))).apply(pLLLL)))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__List__toArray())).apply(Rt.BOX))).apply(pLLLL))))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__OfNat__ofNat())).apply(Rt.BOX))).apply(Long.valueOf(0L)))).apply(((Rt.Fn)(c___instOfNatNat())).apply(Long.valueOf(0L))));
            } };
          } };
        } };
      } };
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
          Object rLLL;
          switch (dLLL.tag) {
            case 0: {
              final Object g0b0LLL = dLLL.fields[0];
              rLLL = g0b0LLL;
              break;
            }
            default: {
              throw new RuntimeException("no matching branch");
            }
          }
          return rLLL;
        } };
      } };
    } };
  }
  // inductive c___OfNat: erased; values use Data(tag, fields)
  public static Object c__List__toArray(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return ((Rt.Fn)(((Rt.Fn)(c__Array__mk())).apply(Rt.BOX))).apply(pL);
      } };
    } };
  }
  // inductive c___Array: erased; values use Data(tag, fields)
  public static Object c__Array__mk(){
    return Rt.ARRAY_MK;
  }
  public static Object c__Array__foldr(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return new Rt.Fn(){ public Object apply(Object pLLLLLL){
                  return ((Rt.Fn)(((Rt.Fn)(c__Id__run())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array__foldrM())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(c__Id__instMonad()))).apply(new Rt.Fn(){ public Object apply(Object pAFFFFALLLLLLL){
                    return new Rt.Fn(){ public Object apply(Object pLAFFFFALLLLLLL){
                      return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(c__Id__instMonad()))))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pLL)).apply(pAFFFFALLLLLLL))).apply(pLAFFFFALLLLLLL));
                    } };
                  } }))).apply(pLLL))).apply(pLLLL))).apply(pLLLLL))).apply(pLLLLLL));
                } };
              } };
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c__Id__instMonad(){
    return new Rt.Data(0, new Object[]{ new Rt.Data(0, new Object[]{ new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0c0c0){
      return new Rt.Fn(){ public Object apply(Object pLc0c0c0){
        return new Rt.Fn(){ public Object apply(Object pLLc0c0c0){
          return new Rt.Fn(){ public Object apply(Object pLLLc0c0c0){
            return ((Rt.Fn)(pLLc0c0c0)).apply(pLLLc0c0c0);
          } };
        } };
      } };
    } }, new Rt.Fn(){ public Object apply(Object pc1c0c0){
      return new Rt.Fn(){ public Object apply(Object pLc1c0c0){
        return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Function__comp())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFAFLLc1c0c0){
          return new Rt.Fn(){ public Object apply(Object pLFFAFLLc1c0c0){
            return new Rt.Fn(){ public Object apply(Object pLLFFAFLLc1c0c0){
              return new Rt.Fn(){ public Object apply(Object pLLLFFAFLLc1c0c0){
                return ((Rt.Fn)(pLLFFAFLLc1c0c0)).apply(pLLLFFAFLLc1c0c0);
              } };
            } };
          } };
        } })).apply(Rt.BOX))).apply(Rt.BOX)))).apply(((Rt.Fn)(((Rt.Fn)(c__Function__const())).apply(Rt.BOX))).apply(Rt.BOX));
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0c1c0){
      return new Rt.Fn(){ public Object apply(Object pLc0c1c0){
        return pLc0c1c0;
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0c2c0){
      return new Rt.Fn(){ public Object apply(Object pLc0c2c0){
        return new Rt.Fn(){ public Object apply(Object pLLc0c2c0){
          return new Rt.Fn(){ public Object apply(Object pLLLc0c2c0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLLLLc0c2c0){
              return new Rt.Fn(){ public Object apply(Object pLFFFFLLLLc0c2c0){
                return new Rt.Fn(){ public Object apply(Object pLLFFFFLLLLc0c2c0){
                  return new Rt.Fn(){ public Object apply(Object pLLLFFFFLLLLc0c2c0){
                    return ((Rt.Fn)(pLLLFFFFLLLLc0c2c0)).apply(pLLFFFFLLLLc0c2c0);
                  } };
                } };
              } };
            } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLc0c2c0))).apply(new Rt.Fn(){ public Object apply(Object pALLLLc0c2c0){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLALLLLc0c2c0){
                return new Rt.Fn(){ public Object apply(Object pLFFFFLALLLLc0c2c0){
                  return new Rt.Fn(){ public Object apply(Object pLLFFFFLALLLLc0c2c0){
                    return new Rt.Fn(){ public Object apply(Object pLLLFFFFLALLLLc0c2c0){
                      return ((Rt.Fn)(pLLFFFFLALLLLc0c2c0)).apply(pLLLFFFFLALLLLc0c2c0);
                    } };
                  } };
                } };
              } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pALLLLc0c2c0))).apply(((Rt.Fn)(pLLLc0c2c0)).apply(c__Unit__unit()));
            } });
          } };
        } };
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0c3c0){
      return new Rt.Fn(){ public Object apply(Object pLc0c3c0){
        return new Rt.Fn(){ public Object apply(Object pLLc0c3c0){
          return new Rt.Fn(){ public Object apply(Object pLLLc0c3c0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLLLLc0c3c0){
              return new Rt.Fn(){ public Object apply(Object pLFFFFLLLLc0c3c0){
                return new Rt.Fn(){ public Object apply(Object pLLFFFFLLLLc0c3c0){
                  return new Rt.Fn(){ public Object apply(Object pLLLFFFFLLLLc0c3c0){
                    return ((Rt.Fn)(pLLLFFFFLLLLc0c3c0)).apply(pLLFFFFLLLLc0c3c0);
                  } };
                } };
              } };
            } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLc0c3c0))).apply(new Rt.Fn(){ public Object apply(Object pALLLLc0c3c0){
              return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLALLLLc0c3c0){
                return new Rt.Fn(){ public Object apply(Object pLFFFFLALLLLc0c3c0){
                  return new Rt.Fn(){ public Object apply(Object pLLFFFFLALLLLc0c3c0){
                    return new Rt.Fn(){ public Object apply(Object pLLLFFFFLALLLLc0c3c0){
                      return ((Rt.Fn)(pLLLFFFFLALLLLc0c3c0)).apply(pLLFFFFLALLLLc0c3c0);
                    } };
                  } };
                } };
              } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(pLLLc0c3c0)).apply(c__Unit__unit())))).apply(new Rt.Fn(){ public Object apply(Object pALALLLLc0c3c0){
                return ((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFLALALLLLc0c3c0){
                  return new Rt.Fn(){ public Object apply(Object pLFFLALALLLLc0c3c0){
                    return pLFFLALALLLLc0c3c0;
                  } };
                } })).apply(Rt.BOX))).apply(pALLLLc0c3c0);
              } });
            } });
          } };
        } };
      } };
    } } }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0c4c0){
      return new Rt.Fn(){ public Object apply(Object pLc0c4c0){
        return new Rt.Fn(){ public Object apply(Object pLLc0c4c0){
          return new Rt.Fn(){ public Object apply(Object pLLLc0c4c0){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFFFFLLLLc0c4c0){
              return new Rt.Fn(){ public Object apply(Object pLFFFFLLLLc0c4c0){
                return new Rt.Fn(){ public Object apply(Object pLLFFFFLLLLc0c4c0){
                  return new Rt.Fn(){ public Object apply(Object pLLLFFFFLLLLc0c4c0){
                    return ((Rt.Fn)(pLLLFFFFLLLLc0c4c0)).apply(pLLFFFFLLLLc0c4c0);
                  } };
                } };
              } };
            } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLc0c4c0))).apply(new Rt.Fn(){ public Object apply(Object pALLLLc0c4c0){
              return ((Rt.Fn)(pLLLc0c4c0)).apply(c__Unit__unit());
            } });
          } };
        } };
      } };
    } } }) }), new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0c1){
      return new Rt.Fn(){ public Object apply(Object pLc0c1){
        return new Rt.Fn(){ public Object apply(Object pLLc0c1){
          return new Rt.Fn(){ public Object apply(Object pLLLc0c1){
            return ((Rt.Fn)(pLLLc0c1)).apply(pLLc0c1);
          } };
        } };
      } };
    } } }) });
  }
  // inductive c___SeqRight: erased; values use Data(tag, fields)
  // inductive c___SeqLeft: erased; values use Data(tag, fields)
  // inductive c___Seq: erased; values use Data(tag, fields)
  public static Object c__Function__const(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return pLL;
          } };
        } };
      } };
    } };
  }
  public static Object c__Function__comp(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return ((Rt.Fn)(pLLL)).apply(((Rt.Fn)(pLLLL)).apply(pLLLLL));
              } };
            } };
          } };
        } };
      } };
    } };
  }
  // inductive c___Functor: erased; values use Data(tag, fields)
  public static Object c__Array__foldrM(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              return new Rt.Fn(){ public Object apply(Object pLLLLL){
                return new Rt.Fn(){ public Object apply(Object pLLLLLL){
                  return new Rt.Fn(){ public Object apply(Object pLLLLLLL){
                    return new Rt.Fn(){ public Object apply(Object pLLLLLLLL){
                      final Rt.Data dLLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__decLe())).apply(pLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(pLLLLLL))));
                      Object rLLLLLLLLL;
                      switch (dLLLLLLLLL.tag) {
                        case 0: {
                          final Object g0b0LLLLLLLLL = dLLLLLLLLL.fields[0];
                          final Rt.Data db0LLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__decLt())).apply(pLLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(pLLLLLL))));
                          Object rb0LLLLLLLLL;
                          switch (db0LLLLLLLLL.tag) {
                            case 0: {
                              final Object g0b0b0LLLLLLLLL = db0LLLLLLLLL.fields[0];
                              rb0LLLLLLLLL = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLL))))).apply(Rt.BOX))).apply(pLLLLL);
                              break;
                            }
                            case 1: {
                              final Object g0b1b0LLLLLLLLL = db0LLLLLLLLL.fields[0];
                              rb0LLLLLLLLL = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array_foldrM__fold())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(pLLLLLL))).apply(pLLLLLLLL))).apply(((Rt.Fn)(((Rt.Fn)(c__Array__size())).apply(Rt.BOX))).apply(pLLLLLL)))).apply(Rt.BOX))).apply(pLLLLL);
                              break;
                            }
                            default: {
                              throw new RuntimeException("no matching branch");
                            }
                          }
                          rLLLLLLLLL = rb0LLLLLLLLL;
                          break;
                        }
                        case 1: {
                          final Object g0b1LLLLLLLLL = dLLLLLLLLL.fields[0];
                          final Rt.Data db1LLLLLLLLL = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__decLt())).apply(pLLLLLLLL))).apply(pLLLLLLL)));
                          Object rb1LLLLLLLLL;
                          switch (db1LLLLLLLLL.tag) {
                            case 0: {
                              final Object g0b0b1LLLLLLLLL = db1LLLLLLLLL.fields[0];
                              rb1LLLLLLLLL = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLL))))).apply(Rt.BOX))).apply(pLLLLL);
                              break;
                            }
                            case 1: {
                              final Object g0b1b1LLLLLLLLL = db1LLLLLLLLL.fields[0];
                              rb1LLLLLLLLL = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array_foldrM__fold())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLL))).apply(pLLLL))).apply(pLLLLLL))).apply(pLLLLLLLL))).apply(pLLLLLLL))).apply(Rt.BOX))).apply(pLLLLL);
                              break;
                            }
                            default: {
                              throw new RuntimeException("no matching branch");
                            }
                          }
                          rLLLLLLLLL = rb1LLLLLLLLL;
                          break;
                        }
                        default: {
                          throw new RuntimeException("no matching branch");
                        }
                      }
                      return rLLLLLLLLL;
                    } };
                  } };
                } };
              } };
            } };
          } };
        } };
      } };
    } };
  }
  public static Object c__Array_foldrM__fold(){
    class Fix {
      public Object f0(Object py0){
        return new Rt.Fn(){ public Object apply(Object pLy0){
          return new Rt.Fn(){ public Object apply(Object pLLy0){
            return new Rt.Fn(){ public Object apply(Object pLLLy0){
              return new Rt.Fn(){ public Object apply(Object pLLLLy0){
                return new Rt.Fn(){ public Object apply(Object pLLLLLy0){
                  return new Rt.Fn(){ public Object apply(Object pLLLLLLy0){
                    return new Rt.Fn(){ public Object apply(Object pLLLLLLLy0){
                      return new Rt.Fn(){ public Object apply(Object pLLLLLLLLy0){
                        return new Rt.Fn(){ public Object apply(Object pLLLLLLLLLy0){
                          final Rt.Data dLLLLLLLLLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c___instDecidableEqBool())).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__BEq__beq())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c___instBEqOfDecidableEq())).apply(Rt.BOX))).apply(c___instDecidableEqNat())))).apply(pLLLLLLLy0))).apply(pLLLLLLy0)))).apply(new Rt.Data(1, new Object[]{  }))));
                          Object rLLLLLLLLLLy0;
                          switch (dLLLLLLLLLLy0.tag) {
                            case 0: {
                              final Object g0b0LLLLLLLLLLy0 = dLLLLLLLLLLy0.fields[0];
                              final Object lb0LLLLLLLLLLy0 = new Rt.Fn(){ public Object apply(Object pVb0LLLLLLLLLLy0){
                                return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLLy0))))).apply(Rt.BOX))).apply(pLLLLLLLLLy0);
                              } };
                              final Object lBb0LLLLLLLLLLy0 = new Rt.Fn(){ public Object apply(Object pVBb0LLLLLLLLLLy0){
                                return new Rt.Fn(){ public Object apply(Object pLVBb0LLLLLLLLLLy0){
                                  final Object lLLVBb0LLLLLLLLLLy0 = Rt.BOX;
                                  return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Bind__bind())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toBind())).apply(Rt.BOX))).apply(pLLLy0)))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pLLLLy0)).apply(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__GetElem__getElem())).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(((Rt.Fn)(c__Array__instGetElemNatLtSize())).apply(Rt.BOX)))).apply(pLLLLLy0))).apply(pVBb0LLLLLLLLLLy0))).apply(Rt.BOX)))).apply(pLLLLLLLLLy0)))).apply(new Rt.Fn(){ public Object apply(Object pABLLVBb0LLLLLLLLLLy0){
                                    return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(new Rt.Fn(){ public Object apply(Object w0){
                                      return Fix.this.f0(w0);
                                    } })).apply(Rt.BOX))).apply(Rt.BOX))).apply(Rt.BOX))).apply(pLLLy0))).apply(pLLLLy0))).apply(pLLLLLy0))).apply(pLLLLLLy0))).apply(pVBb0LLLLLLLLLLy0))).apply(Rt.BOX))).apply(pABLLVBb0LLLLLLLLLLy0);
                                  } });
                                } };
                              } };
                              final Object lFBBb0LLLLLLLLLLy0 = pLLLLLLLy0;
                              final Rt.Data dBFBBb0LLLLLLLLLLy0 = ((Rt.Data)(((Rt.Fn)(((Rt.Fn)(c__Nat__beq())).apply(lFBBb0LLLLLLLLLLy0))).apply(Long.valueOf(0L))));
                              Object rBFBBb0LLLLLLLLLLy0;
                              switch (dBFBBb0LLLLLLLLLLy0.tag) {
                                case 0: {
                                  rBFBBb0LLLLLLLLLLy0 = ((Rt.Fn)(new Rt.Fn(){ public Object apply(Object pFb0BFBBb0LLLLLLLLLLy0){
                                    return new Rt.Fn(){ public Object apply(Object pLFb0BFBBb0LLLLLLLLLLy0){
                                      return ((Rt.Fn)(((Rt.Fn)(lBb0LLLLLLLLLLy0)).apply(pFb0BFBBb0LLLLLLLLLLy0))).apply(Rt.BOX);
                                    } };
                                  } })).apply(((Rt.Fn)(((Rt.Fn)(c__Nat__sub())).apply(lFBBb0LLLLLLLLLLy0))).apply(Long.valueOf(1L)));
                                  break;
                                }
                                case 1: {
                                  rBFBBb0LLLLLLLLLLy0 = new Rt.Fn(){ public Object apply(Object pb1BFBBb0LLLLLLLLLLy0){
                                    return ((Rt.Fn)(lb0LLLLLLLLLLy0)).apply(Rt.BOX);
                                  } };
                                  break;
                                }
                                default: {
                                  throw new RuntimeException("no matching branch");
                                }
                              }
                              rLLLLLLLLLLy0 = ((Rt.Fn)(rBFBBb0LLLLLLLLLLy0)).apply(Rt.BOX);
                              break;
                            }
                            case 1: {
                              final Object g0b1LLLLLLLLLLy0 = dLLLLLLLLLLy0.fields[0];
                              rLLLLLLLLLLy0 = ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Pure__pure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Applicative__toPure())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(c__Monad__toApplicative())).apply(Rt.BOX))).apply(pLLLy0))))).apply(Rt.BOX))).apply(pLLLLLLLLLy0);
                              break;
                            }
                            default: {
                              throw new RuntimeException("no matching branch");
                            }
                          }
                          return rLLLLLLLLLLy0;
                        } };
                      } };
                    } };
                  } };
                } };
              } };
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
  public static Object c__Nat__sub(){
    return Rt.NAT_SUB_LONG;
  }
  public static Object c__Array__instGetElemNatLtSize(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0L){
        return new Rt.Fn(){ public Object apply(Object pLc0L){
          return new Rt.Fn(){ public Object apply(Object pLLc0L){
            return ((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(((Rt.Fn)(c__Array__getInternal())).apply(Rt.BOX))).apply(pc0L))).apply(pLc0L))).apply(Rt.BOX);
          } };
        } };
      } } });
    } };
  }
  public static Object c__Array__getInternal(){
    return Rt.ARRAY_GET_INTERNAL;
  }
  public static Object c__GetElem__getElem(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Fn(){ public Object apply(Object pLL){
          return new Rt.Fn(){ public Object apply(Object pLLL){
            return new Rt.Fn(){ public Object apply(Object pLLLL){
              final Rt.Data dLLLLL = ((Rt.Data)(pLLLL));
              Object rLLLLL;
              switch (dLLLLL.tag) {
                case 0: {
                  final Object g0b0LLLLL = dLLLLL.fields[0];
                  rLLLLL = g0b0LLLLL;
                  break;
                }
                default: {
                  throw new RuntimeException("no matching branch");
                }
              }
              return rLLLLL;
            } };
          } };
        } };
      } };
    } };
  }
  // inductive c___GetElem: erased; values use Data(tag, fields)
  public static Object c__Monad__toBind(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            final Object g1b0LL = dLL.fields[1];
            rLL = g1b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  public static Object c__Bind__bind(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            rLL = g0b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  // inductive c___Bind: erased; values use Data(tag, fields)
  public static Object c___instDecidableEqNat(){
    return c__Nat__decEq();
  }
  public static Object c__Nat__decEq(){
    return Rt.PRIM_DEC_EQ_LONG;
  }
  public static Object c___instBEqOfDecidableEq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return new Rt.Data(0, new Object[]{ new Rt.Fn(){ public Object apply(Object pc0LL){
          return new Rt.Fn(){ public Object apply(Object pLc0LL){
            return ((Rt.Fn)(((Rt.Fn)(c__Decidable__decide())).apply(Rt.BOX))).apply(((Rt.Fn)(((Rt.Fn)(pL)).apply(pc0LL))).apply(pLc0LL));
          } };
        } } });
      } };
    } };
  }
  public static Object c__Decidable__decide(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            rLL = new Rt.Data(0, new Object[]{  });
            break;
          }
          case 1: {
            final Object g0b1LL = dLL.fields[0];
            rLL = new Rt.Data(1, new Object[]{  });
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  public static Object c__BEq__beq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            rLL = g0b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  // inductive c___BEq: erased; values use Data(tag, fields)
  public static Object c___instDecidableEqBool(){
    return c__Bool__decEq();
  }
  public static Object c__Bool__decEq(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Object lLL = new Rt.Fn(){ public Object apply(Object pVLL){
          return new Rt.Data(1, new Object[]{ Rt.BOX });
        } };
        final Object lBLL = new Rt.Fn(){ public Object apply(Object pVBLL){
          return new Rt.Data(0, new Object[]{ Rt.BOX });
        } };
        final Object lBBLL = new Rt.Fn(){ public Object apply(Object pVBBLL){
          return new Rt.Data(0, new Object[]{ Rt.BOX });
        } };
        final Object lBBBLL = new Rt.Fn(){ public Object apply(Object pVBBBLL){
          return new Rt.Data(1, new Object[]{ Rt.BOX });
        } };
        final Rt.Data dBBBBLL = ((Rt.Data)(p));
        Object rBBBBLL;
        switch (dBBBBLL.tag) {
          case 0: {
            final Rt.Data db0BBBBLL = ((Rt.Data)(pL));
            Object rb0BBBBLL;
            switch (db0BBBBLL.tag) {
              case 0: {
                rb0BBBBLL = ((Rt.Fn)(lLL)).apply(c__Unit__unit());
                break;
              }
              case 1: {
                rb0BBBBLL = ((Rt.Fn)(lBLL)).apply(c__Unit__unit());
                break;
              }
              default: {
                throw new RuntimeException("no matching branch");
              }
            }
            rBBBBLL = rb0BBBBLL;
            break;
          }
          case 1: {
            final Rt.Data db1BBBBLL = ((Rt.Data)(pL));
            Object rb1BBBBLL;
            switch (db1BBBBLL.tag) {
              case 0: {
                rb1BBBBLL = ((Rt.Fn)(lBBLL)).apply(c__Unit__unit());
                break;
              }
              case 1: {
                rb1BBBBLL = ((Rt.Fn)(lBBBLL)).apply(c__Unit__unit());
                break;
              }
              default: {
                throw new RuntimeException("no matching branch");
              }
            }
            rBBBBLL = rb1BBBBLL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rBBBBLL;
      } };
    } };
  }
  public static Object c__Unit__unit(){
    return new Rt.Data(0, new Object[]{  });
  }
  // inductive c___PUnit: erased; values use Data(tag, fields)
  // inductive c___Bool: erased; values use Data(tag, fields)
  public static Object c__Monad__toApplicative(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            final Object g1b0LL = dLL.fields[1];
            rLL = g0b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  // inductive c___Monad: erased; values use Data(tag, fields)
  public static Object c__Applicative__toPure(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            final Object g1b0LL = dLL.fields[1];
            final Object g2b0LL = dLL.fields[2];
            final Object g3b0LL = dLL.fields[3];
            final Object g4b0LL = dLL.fields[4];
            rLL = g1b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  // inductive c___Applicative: erased; values use Data(tag, fields)
  public static Object c__Pure__pure(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        final Rt.Data dLL = ((Rt.Data)(pL));
        Object rLL;
        switch (dLL.tag) {
          case 0: {
            final Object g0b0LL = dLL.fields[0];
            rLL = g0b0LL;
            break;
          }
          default: {
            throw new RuntimeException("no matching branch");
          }
        }
        return rLL;
      } };
    } };
  }
  // inductive c___Pure: erased; values use Data(tag, fields)
  public static Object c__Nat__decLt(){
    return Rt.PRIM_DEC_LT_LONG;
  }
  // inductive c___Decidable: erased; values use Data(tag, fields)
  public static Object c__Array__size(){
    return Rt.ARRAY_SIZE_LONG;
  }
  public static Object c__Nat__decLe(){
    return Rt.PRIM_DEC_LE_LONG;
  }
  public static Object c__Id__run(){
    return new Rt.Fn(){ public Object apply(Object p){
      return new Rt.Fn(){ public Object apply(Object pL){
        return pL;
      } };
    } };
  }
  public static Object __main(){
    return c___suite_list_sum_foldr();
  }
  public static void main(String[] args){
    Rt.runMain(new Rt.Fn(){ public Object apply(Object ignored){
      return __main();
    } });
  }
}

package sandbox;


import com.sun.tools.javac.util.List;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class NestedClassDemo {
    public static void main(String[] args) {
        TopLevelOuter.StaticNested nestedObj = new TopLevelOuter.StaticNested();
        nestedObj.getStaticOuterState();

        new TopLevelOuter().new Nested();
        System.out.println(
            new TopLevelOuter().outherMethod().toString()
        );

        reusableM( // HOF High Order Function
            new TopLevelOuter.Todo(){ // closure
                @Override
                public String todo() {
                    return "890";

                }
            }
        );
        reusableM(()->"null");

        reusableM2(new TopLevelOuter.Todo2() { // HOF High Order Function
                       @Override
                       public String todo(String arg) {
                           return null;

                       }
              }
        );
        reusableM2( ( String arg ) -> {return "string: " + arg;});
        reusableM2( ( arg ) -> {return "string: " + arg;});
        reusableM2( arg -> "string: " + arg);

        //Stream API
        //(1,2,3,4).stream();
        List.of(1,2,3,4).stream();

    }

    private static void reusableM(TopLevelOuter.Todo todo){
        System.out.println(todo.todo());
    }

    private static void reusableM2(TopLevelOuter.Todo2 todo){
        System.out.println(todo.todo("Aaa"));
    }

}


class TopLevelOuter{
    private static String staticState = "abc";
    private String instanceState = "def";

    protected static class StaticNested{
        public void getStaticOuterState(){
            System.out.println(staticState);
        }
    }

    protected class Nested{
        public void getOuterState(){
            System.out.println(TopLevelOuter.this.instanceState);
        }
    }

    public Object outherMethod(){
        class localNested{
            public void uselessMethod(){

            }

            @Override
            public String toString() {
                return "localNested{}";
            }
        }
        return new localNested();
    }

    public Object outherMethod2(){
        return new Object(){
            @Override
            public String toString() {
                return "$classname{}";
            }
        };
    }

    interface Todo{
        String todo();
    }

@FunctionalInterface
    interface Todo2{
        String todo(String arg);
    }

}

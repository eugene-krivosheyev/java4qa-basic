package sandbox;

public class SwitchAndCyclesDemo {
    public strictfp static void main(String[] args) {
        //region if/switch
        if (fun1()) {

        } else if (fun2()) {

        } else {

        }

        int age = 30;
        switch (age) {
            case 20: {
                System.out.println("too yang!");
                break;
            }
            case 30:
                System.out.println("good enough");
                break;
            case 40:
                System.out.println("too yang!");
                break;
            default:
                System.out.println("default");

        }
        //endregion

        //region cycles
        for(int counter = 0, i = 0; counter < 10 & i>0; counter++, i--){
            System.out.println(counter);
        }

        do {

        } while (isAlways());

        while (isAlways()){

        }

        //foreach  used for iteration over list, collection, maps etc.
        for (String current : args ) {
            System.out.println(current);
        }

        //endregion

        //region nested cycles
        outher: while (isAlways()){
            if(condition()) break;  // -> 63
            if(condition()) continue; // -> 53

            inner: do{
                if(condition()) break outher;
                if(condition()) continue outher;
                doIterateInputStrings(args);
            } while (isAlways());
        }
        //endregion
    }

    private static boolean condition() {
        return false;
    }

    private static void doIterateInputStrings(String[] args) {
        for (String current : args ) {
            System.out.println(current);
        }
    }

    private static boolean isAlways() {
        return true;
    }

    private static boolean fun2() {
        return false;
    }

    private static boolean fun1() {
        return false;
    }

    private static void methodWithParam(int param) {
        if (param > 0) {
            //logic return false;
        } else {
            throw new IllegalArgumentException("param must be positive! Having: " + param);
        }
    }

    // Guard clauses
    private static void refactMethodWithParam(int param) {
        if (param <= 0) throw new IllegalArgumentException("param must be positive! Having: " + param);
        // body
    }
}
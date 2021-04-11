package demo;

public class SwitchAndCycleDemo {
    public static void main(String[] args) {
        //region if
        if (f1()) {

        } else if(f2()) {

        } else {

        }

        int age = 30;
        switch(age) {
            case 20: {
                System.out.println("молодой еще!");
                break;
            }
            case 30:
                System.out.println("уже норм"); break;
            case 40:
                System.out.println("уже поздно"); break;
        }

        switch (1) {
            default: break;
            case 2: break;
        }
        //endregion

        //region cycles
        //for(;;) {}
        for (int counter = 0, i = 1; counter < 10 & i < 2; counter++, i--) {
            System.out.println(counter);
        }

        do {

        } while (always());

        while (always()) {

        }

        //foreach -> iteartion over arrays and Collections
        for(String current : args) {
            System.out.println(current);
        }
        //endregion

        //region nested
        outer: while (always()) {
            if (condition()) break; // -> 61
            if (condition()) continue; // -> 53
            //...

            inner: do {
                if (condition()) break outer; // -> 65
                if (condition()) continue outer; // ->

                doIterateCollection();
            } while (always());
            //..
        }
        //endregion
    }

    private static boolean condition() {
        return false;
    }

    private static void doIterateCollection() {

    }

    private static boolean always() {
        return 1 == 1;
    }

    private static boolean f2() {
        return false;
    }

    private static boolean f1() {
        return false;
    }

    private static void methodWithParam(int param) {
        if (param > 0) {
            // main flow
        } else if (param < 0) {
            throw new IllegalArgumentException("param must be positive");
        } else if (param < 0) {
            throw new IllegalArgumentException("param must be positive");
        }
    }

    // Guard Clauses
    private static void refactoredMethodWithParam(int param) {
        if (param <= 0) throw new IllegalArgumentException("param must be positive");
        if (param <= 0) throw new IllegalArgumentException("param must be positive");
        if (param <= 0) throw new IllegalArgumentException("param must be positive");

        // main flow
    }
}

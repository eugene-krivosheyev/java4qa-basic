package demo;

public class ProcedureReuseDemo {
    public static void main(String[] args) {
        //region before
        if (condition()) {
            m1(0);
        } else {
            m2(0);
        }
        //endregion

        //region after
        if (condition()) {
            m(0, Byte.MAX_VALUE, "case1");
        } else {
            m(0, Integer.MAX_VALUE, "case2");
        }
        //endregion
    }

    //region before
    private static void m1(int param) {
        if (param >= Byte.MAX_VALUE) {
            //1
            //2
            //3
        }
        //4-1: subProcedure1()
    }

    private static void m2(int param) {
        if (param >= Integer.MAX_VALUE) {
            //1
            //2
            //3
        }
        //4-2: subProcedure2()
    }
    //endregion

    //region after
    private static void m(int param, int limit, String condition) {
        if (param >= limit) {
            //1
            //2
            //3
        }

        // OCP
        if ("case1".equals(condition)) {
            //4-1: subProcedure1()
        } else if ("case2".equals(condition)) {
            //4-2: subProcedure2()
        }
    }
    //endregion


    private static boolean condition() {
        return false;
    }
}

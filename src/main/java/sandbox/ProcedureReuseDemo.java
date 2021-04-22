package sandbox;

public class ProcedureReuseDemo {
    public static void main(String[] args){

        if(condition()){
            m(0, Byte.MAX_VALUE);
        } else{
            m(0, Integer.MAX_VALUE);
        }

    }

    private static boolean condition() {
        return true;
    }

    private static void m1(int param){

        if (param  >= Byte.MAX_VALUE) {

        }
    }

    private static void m2(byte param){
        if (param  >= Integer.MAX_VALUE) {

        }

    }

    private static void m(Object param, int limit){
        if ((int)param  >= limit) {

        }

    }
}

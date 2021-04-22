package sandbox;

import java.util.Arrays;

public class OperatorsDemo {
    public static void main(String[] args){
        //region typ cast operators
        byte var1 = 0;
        int var2 = Byte.MAX_VALUE;
        var1 = (byte)var2;
        System.out.println(var1);
        //endregion

        //region NON primitives
        Object obj = new String("a");
        if(obj instanceof String) {
            System.out.println((String)obj);
        }

        //endregion

        //region arithmetics ops
        byte b1 = 1,b2 = 3;
        double v = b1 / (double) b2;
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(v);
        System.out.println("");
        //endregion

        //region bitwise ops
        int v1 = 2, v2 = 2, v3 = -1;
        System.out.println(v1);
        System.out.println(v1 & v2);
        System.out.println(v1 | v2);
        System.out.println(v1 ^ v2);
        System.out.println(v1 << 1);
        System.out.println(v2 >> 1);
        System.out.println(v3 >>> 1); //signed shift
        System.out.println(v3 << 1);

        //endregion

        //region ++++ str+++
        System.out.println(1 + 1);
        System.out.println("1" + 1 );
        System.out.println(1 + 2 + "3" + 4 + 5 );
        //endregion

        //region logical
        boolean boo1 = true, boo2 = false;
        System.out.println(boo1 & boo2);
        System.out.println(boo1 | boo2);
        System.out.println(!boo1 );
        System.out.println(!boo2 );
        if ( m1() || m2()){

        }
        //endregion

        //region logic operations
        Boolean wrB = true;
        System.out.println("<<<<<<<<<<<< Logic ops >>>>>>>>>>");
        System.out.println(wrB == null); // == != > < >= <=

        //endregion

        //region references
        System.out.println("<<<<<<<<<<<< References and Objects >>>>>>>>>>");
        Object obj1; // reference id | hash
        obj1 = new Object();
        Object obj2 = new Object();

        final String isSame = obj1 == obj2 ? "same":"different";

        System.out.println(obj1 != obj2);
        System.out.println(obj1.equals(obj2));
        System.out.println(isSame);
        //endregion
    }

    private static boolean m1() {
        return false;
    }

    private static boolean m2() {
        return true;
    }


}

package demo;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region typing operators
        int var1 = Byte.MAX_VALUE + 130;
        byte var2 = (byte) var1;
        System.out.println(var2);

        //NON-PRIMITIVES!!!
        Object obj = new Integer(1); //polymorphism
        if (obj instanceof String) {
            String result = (String) obj; // -> ClassCastException
        }
        //endregion

        //region Arithmetics operators
        byte b1 = 1, b2 = 3;
        System.out.println( b1 / b2 ); // целочисленный!
        int x = b1 + b2;
        System.out.println(x);
        long l = 1 + 1L;

        System.out.println(1./0.);
        System.out.println(0./0.);
        //endregion

        //region Bitwise
        int v1 = 1, v2 = 2, v3 = -1;
        System.out.println( ~v1 );
        System.out.println( v1 & v2);
        System.out.println( v1 | v2);
        System.out.println( v1 ^ v2);
        System.out.println( v1 << 1);
        System.out.println( v3 >> 1);
        System.out.println( v3 >>> 1);
        //endregion

        System.out.println(1 + 1);
        System.out.println(1 + "1"); // concat
        System.out.println( 1 + 2 + "3" + 4 * 5);

        //region Logical
        boolean boo1 = true, boo2 = false;
        System.out.println( boo1 | boo2 ); // | & !
        if ( m1() || m2() ) { // lazy

        }
        //fopen("file") or die("gggg");
        Integer iiii = 2;
        Boolean wrBool = null; // new Boolean(true);

        System.out.println( 1 == 1 ); // == != > < >= <=
        if ( wrBool | true ) { // new Boolean(null)

        }

        Object obj1; // reference: id | hash
        obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1 != obj2); // = =
        System.out.println( obj1.equals(obj2) ); // = = =

        final String isSame = obj1 == obj2 ? "same" : "different objects";
        //endregion
    }

    private static boolean m2() {
        return true;
    }

    private static boolean m1() {
        return false;
    }
}

package demo;

//import javax.xml.ws.soap.Addressing;
import java.math.BigDecimal;
//import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.util.Collections.emptyList;
import static java.util.Optional.of;

public strictfp class OperatorsDemo {
    public strictfp static void main(String[] args) {
        //region Type operators
        byte b = 0;
        int i = b; //implicit type casting

        i = Byte.MAX_VALUE + 1;
        b = (byte) i; //unary operator
        System.out.println(b);

        Object object = new Integer("1"); // polymorphism
        if (object instanceof String) {
            System.out.println(( (String) object )); // ClassCastException
        }
        //endregion

        Object obj = new Object();
        String s = "abc"; // new String("abc)
        Integer integer = 1; // new Integer(1)
        int[] array = {1,2,3}; //
        Optional maybe = of("125.7.8.6:666"); // Factory Method
        final List<Object> objects = emptyList();

        //region Arithmetics
        // + - * / %
        System.out.println( 1/3 );

        byte b1 = 1, b2 = 2;
        int i1 = b1 + b2;
        long l = i1 + 1L;
        double v = l + 1.;

        System.out.println( 1 + 2 + "3" + 4 + 5 );

        System.out.println(0./0.);
        System.out.println(POSITIVE_INFINITY == POSITIVE_INFINITY);
        System.out.println(POSITIVE_INFINITY + 1 == POSITIVE_INFINITY);
        System.out.println(NaN == NaN);
        System.out.println(NaN + 1 < NaN);
        //endregion

        //region FP pre loss
        // IEEE 754: 2e3
        System.out.println(.1 + .2);
        BigDecimal bd;
        //endregion

        //region Bitwise
        int ii1 = 1, ii2 = -2;
        System.out.println( ii1 | ii2 );
        System.out.println( ii1 & ii2 );
        System.out.println( ii1 ^ ii2 ); // XOR
        System.out.println( ~ii1 ); // !

        System.out.println( ii1 << 1 ); // *2
        System.out.println( ii2 >> 1 ); // div 2
        System.out.println( ii2 >>> 1 );
        //endregion

        //region Logical operators + сравнения
        boolean bb1 = true, bb2 = false;
        //eager
        System.out.println( bb1 & bb2 ); // *
        System.out.println( bb1 | bb2 ); // +
        System.out.println( !bb2 );
        //lazy
        System.out.println( first() && second() ); // +
        System.out.println( first() || second() ); // +
        // fopen('file') or die();

        System.out.println( 1 == 1 ); // = =
        System.out.println( 1 != 1 ); // ! =
        System.out.println(1 >= 1); // > =
        System.out.println(1 <= 1); // < =

        Object var = new Object();
        System.out.println(var);


        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println( o1 == o2 ); // same?
        System.out.println( o1.equals(o2) );
        //endregion

        //region ternary
        final Object result = check() ? get1Option() : 3;
        //endregion
    }

    private static boolean check() {
        return 1 == 2;
    }

    private static String get1Option() {
        return "equals";
    }

    private static boolean first() {
        return false;
    }
    private static boolean second() {
        return false;
    }
}

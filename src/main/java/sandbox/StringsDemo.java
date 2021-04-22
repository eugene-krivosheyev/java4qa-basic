package sandbox;

import java.util.Arrays;
import java.util.Locale;

public class StringsDemo {
    public static void main(String... args) {  //strange but good enough
        String str1 = "abc"; // new String(); + interning with String pool/cash
        String str2 = "abc"; // new String();
        System.out.println(str1 == str2);
        System.out.println(str1.toUpperCase() + str1);

        StringBuffer sbf = new StringBuffer("abc"); // synchronized
        StringBuilder sbl = new StringBuilder("abc"); // thread unsafe
        sbf.reverse();
        System.out.println(sbf + " | " + sbl);



    }
}
package demo;

import java.util.Locale;

public class StringsDemo {
    public static void main(String[] args) {
        String str1 = "abc"; //new String(); + intern() with String pool
        String str2 = "abc"; //new String();
//        str1.intern();

        System.out.println( str1 == str2  );

        str1.toUpperCase(); // error!!!!
        System.out.println(str1.toUpperCase());

        StringBuffer sbf = new StringBuffer("abc"); //synchronized
        StringBuilder sbr = new StringBuilder("abc"); //thread-unsafe

        System.out.println("a" + "b" + "c" + "d");
        new StringBuffer("a")
                .append("b")
                .append("c")
                .append("d");
        String.format("%s%s%s%s", "a","b","c","d");
    }
}

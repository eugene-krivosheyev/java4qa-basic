package datatypes;

public class PrimitivesDemo {
    public static void main(String[] args) {

        //region
        char c = 'a';
        int charCode = c;
        System.out.println(charCode);
        //endregion

        //region wrapper
        short s = Short.MAX_VALUE;
        System.out.println("parseInt test: " + Integer.parseInt("39") + Integer.parseInt("11"));
        Integer x = Integer.parseInt("39") + Integer.parseInt("11");
        System.out.println(x);
        //endregion

        //region type overflow

        //endregion
    }
}

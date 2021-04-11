package demo;

import java.math.BigInteger;

public strictfp  class PrimitivesDemo {
    public strictfp static void main(String[] args) {
        //region целочисленные
        byte b = -0b1; //--0..255-- ^ -127..128 //IEEE 754
        short s = 022354; // 2 bytes:
        int i = 0xABCDEF; // 4 bytes
        System.out.println(9_999_999_999_999L); // 8 bytes
        //endregion

        //region с плавающей точкой
        //IEEE 754
        float f = 0.f; // 32 bit
        double d = -2e200; // 64 bit
        //endregion

        //region char
//        char c = '\uABCD'; // 2 bytes: unsigned
        char c = '\b'; // 2 bytes: unsigned
        int charCode = c;
        System.out.println(">>> " + c + ".");
        //l10n and i18n
        //endregion

        //region logic
        //#DEFINE true false //счастливой отладки, упыри!!!
        boolean boo = true | false;
        //if/switch | for/while/do
        //endregion

        //region wrappers
        //region boxing/unboxing
        Integer ii = new Integer(2);
        int bb = ii.intValue();
        //endregion
        //region autoboxing/autounboxing
        Integer iii = 2; //new Integer(2)
        int bbb = iii; //iii.intValue()

        Integer counter = 0;
        while(isTrue()) {
            counter++; //performance issue!!!
        }
        //endregion


        System.out.println(Short.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        //endregion

        //region Types Overflow
        byte overflowCounter = Byte.MIN_VALUE; //-128..127
        for (int n = 0; n < 258; n++) {
            overflowCounter++;
        }
        System.out.println("+++++++ " + overflowCounter);
        //endregion
    }

    private static boolean isTrue() {
        return false;
    }
}

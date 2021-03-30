package com.acme.dbo.txlog;

import java.util.HashMap;

public class Facade {

    static HashMap<String,String>  PrefixMessage = new HashMap<String,String>();
    static HashMap<String,String>  PostfixMessage = new HashMap<String,String>();
    static int Buffer;
    static String StrBuffer;
    static byte Seq = 0;
    static byte StrSeq = 0;
     static {

        PrefixMessage.put("Primitive", "primitive: ");
        PrefixMessage.put("Char", "char: ");
        PrefixMessage.put("String", "string: ");
        PrefixMessage.put("Reference", "reference: ");
        PrefixMessage.put("Primitive array", "primitives array: ");
        PrefixMessage.put("Primitive matrix", "primitives matrix: ");


        PostfixMessage.put("Primitive array", "");
        PostfixMessage.put("Primitive matrix", "");
        PostfixMessage.put("Primitive", "");
        PostfixMessage.put("Char", "");
        PostfixMessage.put("String", "");
        PostfixMessage.put("Reference", "");
    }
    public static void flush() {
        printMessage(decorate(PrefixMessage.get("Primitive"), Buffer, PostfixMessage.get("Primitive")));
        Seq = 0;
        Buffer = 0;
    }

    private static void printMessage(Object RichMessage) {
        System.out.println(RichMessage);
    }

    private static Object decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }

    public static void log(int message) {
        if ( message == Integer.MAX_VALUE | Buffer == Integer.MAX_VALUE)
        {
            flush();
        }
        if(Seq != 0){
            Buffer = Buffer + message;
        } else {
            Buffer = message;
        }
        Seq++;
    }

    public static void log(byte message) {
        if ( message == Byte.MAX_VALUE | Buffer == Byte.MAX_VALUE)
        {
            flush();
        }
        if(Seq != 0){
            Buffer = Buffer + message;
        } else {
            Buffer = message;
        }
        Seq++;
    }


    public static void log(char message) {
        printMessage(decorate(PrefixMessage.get("Char"), message, PostfixMessage.get("Char")));
    }

    public static void log(String message) {
        if(Seq != 0){
            flush();
        }
        printMessage(decorate(PrefixMessage.get("String"), message, PostfixMessage.get("String")));
    }

    public static void log(String... message) {
        if(Seq != 0){
            flush();
        }
        String tmp= "";

        for (String i:message) {
            tmp = tmp + "\n" + i;
        }
        printMessage(decorate(PrefixMessage.get("String"), tmp, PostfixMessage.get("String")));
    }

    public static void log(boolean message) {
        printMessage(decorate(PrefixMessage.get("Primitive"), message, PostfixMessage.get("Primitive")));
    }

    public static void log(int[] message) {
        String tmp = "{";
        int length = message.length;
        for (int i =0; i < length; i++){
            if (i !=(length-1)) tmp = tmp + message[i] + ", ";
            else tmp = tmp + message[i];
        }

        tmp = tmp + "}";
        printMessage(decorate(PrefixMessage.get("Primitive array"), tmp, PostfixMessage.get("Primitive array")));
    }

    public static void log(int[][] message) {
        String tmp = "{\n";
        int length = message.length;
        for (int j =0; j < length; j++) {
            tmp = tmp + "{";
            for (int i = 0; i < length; i++) {
                if (i != (length - 1)) tmp = tmp + message[j][i] + ", ";
                else tmp = tmp + message[j][i];
            }
            tmp = tmp + "}\n";
        }
        tmp = tmp + "}";
        printMessage(decorate(PrefixMessage.get("Primitive matrix"), tmp, PostfixMessage.get("Primitive matrix")));
    }

    public static void log(Object message) {
        printMessage(decorate(PrefixMessage.get("Reference"), message, PostfixMessage.get("Reference")));
    }
}

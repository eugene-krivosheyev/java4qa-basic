package com.acme.dbo.txlog;

import java.util.HashMap;

public class Facade {

    static HashMap<String,String>  PrefixMessage = new HashMap<String,String>();
    static HashMap<String,String>  PostfixMessage = new HashMap<String,String>();
    static Object Buffer=null;

    static {

        PrefixMessage.put("Primitive", "primitive: ");
        PrefixMessage.put("Char", "char: ");
        PrefixMessage.put("String", "string: ");
        PrefixMessage.put("Reference", "reference: ");

        PostfixMessage.put("Primitive", "");
        PostfixMessage.put("Char", "");
        PostfixMessage.put("String", "");
        PostfixMessage.put("Reference", "");
    }

    public static void flush(){
        printMessage(decorate(PrefixMessage.get("Primitive"), Buffer, PostfixMessage.get("Primitive")));
        setBuffer(null);
    }

    public static void setBuffer(Object message){
        Buffer = message;
    }
    private static void printMessage(Object RichMessage) {
        System.out.println(RichMessage);
    }

    private static Object decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }

    public static void log(int message) {
       if (Buffer instanceof Integer) {
           setBuffer(message);
        } else if (Buffer != null){
           flush();
       } else {
           setBuffer(message);
       }
    }

    public static void log(byte message) {
        printMessage(decorate(PrefixMessage.get("Primitive"), message, PostfixMessage.get("Primitive")));
    }

    public static void log(char message) {
        printMessage(decorate(PrefixMessage.get("Char"), message, PostfixMessage.get("Char")));
    }

    public static void log(String message) {
        printMessage(decorate(PrefixMessage.get("String"), message, PostfixMessage.get("String")));
    }

    public static void log(boolean message) {
        printMessage(decorate(PrefixMessage.get("Primitive"), message, PostfixMessage.get("Primitive")));
    }

    public static void log(Object message) {
        printMessage(decorate(PrefixMessage.get("Reference"), message, PostfixMessage.get("Reference")));
    }
}

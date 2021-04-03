package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }
    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String stringLine) {
        System.out.println("string: " + stringLine);
    }

    public static void log(boolean booleanValue) {
        System.out.println("primitive: " + booleanValue);
    }

    public static void log(Object object) {
        System.out.println("reference: " + object);
    }
}

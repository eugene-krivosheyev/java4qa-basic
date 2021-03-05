package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(boolean b) {
        System.out.println("primitive: " + b);
    }

    public static void log(Object o) {
        System.out.println("reference: " + o);
    }
}

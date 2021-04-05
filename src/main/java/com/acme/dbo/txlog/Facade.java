package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive:";
    public static final String CHAR_PREFIX = "char:";
    public static final String STRING_PREFIX = "string:";
    public static final String REFERENCE_PREFIX = "reference:";

    public static void log(int message) {
        logWithPrefix(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        logWithPrefix(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        logWithPrefix(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        logWithPrefix(STRING_PREFIX, message);
    }

    public static void log(Object message) {
        logWithPrefix(REFERENCE_PREFIX, message);
    }

    public static void log(Boolean message) {
        logWithPrefix(PRIMITIVE_PREFIX, message);
    }

    private static void logWithPrefix(String prefix, Object obj) {
        System.out.println(prefix + " " + obj);
    }
}

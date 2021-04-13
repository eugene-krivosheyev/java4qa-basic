package com.acme.dbo.txlog;

public class OutputDecorator {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void logOutput(int message) {

        System.out.println(PRIMITIVE_PREFIX +message);
    }

    public static void logOutput(byte message) {

        System.out.println(PRIMITIVE_PREFIX +message);
    }

    public static void logOutput(char message) {

        System.out.println(CHAR_PREFIX +message);
    }
    public static void logOutput(String message) {

        System.out.println(STRING_PREFIX +message);
    }
    public static void logOutput(boolean message) {

        System.out.println(PRIMITIVE_PREFIX +message);
    }

    public static void logOutput(Object message) {

        System.out.println(REFERENCE_PREFIX +message);
    }
}

package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static Object previousLine = new Object();
    private static int stringSum = 1;

    public static void log(Integer message) {
        if ((previousLine instanceof Integer) && (!message.equals(Integer.MAX_VALUE))) {
            Integer sum = (Integer) previousLine + message;
            print(decorate(PRIMITIVE_PREFIX, sum, PRIMITIVE_POSTFIX));
        } else {
            print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
            previousLine = message;
        }

        stringSum = 1;
    }

    public static void log(byte message) {
        print(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
        stringSum = 1;
    }

    public static void log(String message) {
        if (previousLine instanceof String & previousLine.equals(message)) {
            String summMessage = message + " (x" + ++stringSum + ")";
            print(decorate(STRING_PREFIX, summMessage, STRING_POSTFIX));
        } else {
            print(decorate(STRING_PREFIX, message, STRING_POSTFIX));
            previousLine = message;
            stringSum = 1;
        }
    }

    public static void log(Character message) {
        print(decorate(CHAR_PREFIX, message, STRING_POSTFIX));
        stringSum = 1;
    }

    public static void log(Boolean message) {
        print(decorate(PRIMITIVE_PREFIX, message, ""));
        stringSum = 1;
    }

    public static void log(Object message) {
        print(decorate(REFERENCE_PREFIX, message, ""));
        stringSum = 1;
    }


    private static void print(Object message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix + "\n";
    }
}

package com.acme.dbo.txlog;

import java.lang.reflect.Type;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string prefix: ";
    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";

    private static Type lastType;

    private static long accumulator;

    private static String lastString;

    public static void flush() {
        if (lastType == null) {
            return;
        }

        if (lastType == Byte.class || lastType == Integer.class) {
            print(decorate(PRIMITIVE_PREFIX, accumulator, PRIMITIVE_POSTFIX));
        } else if (lastType == String.class) {
            flushString();
        }

        accumulator = 0;
        lastString = null;
    }

    public static void log(Integer message) {
        updateLastType(Integer.class);

        loggingDigitalValue(message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void log(byte message) {
        updateLastType(Byte.class);

        loggingDigitalValue(message, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    public static void log(String message) {
        updateLastType(String.class);

        if (lastString == null) {
            lastString = message;
        } else if (!lastString.equals(message)) {
            flush();
            lastString = message;
        }
        accumulator += 1;
    }

    public static void log(Object message) {
        updateLastType(message.getClass());

        print(decorate("", message, ""));
    }

    private static void updateLastType(Type typeName) {
        if (lastType != null && !lastType.equals(typeName)) {
            flush();
        }

        lastType = typeName;
    }

    private static void loggingDigitalValue(long value, long maxValue, long minValue) {
        long result = accumulator + value;

        if (result > maxValue) {
            flush();
        } else if (result < minValue) {
            flush();
        }

        accumulator += value;
    }

    private static void flushString() {
        String message = "";

        if (accumulator <= 1) {
            message = lastString;
        } else {
            message = lastString + " (x" + accumulator +")";
        }

        print(decorate(STRING_PREFIX, message, STRING_POSTFIX));
    }

    private static void print(Object message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        return prefix + message + postfix;
    }
}

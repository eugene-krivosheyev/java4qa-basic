package com.acme.dbo.txlog;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    public static final String PRIMITIVE_POSTFIX = "";
    public static final String CHAR_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String REFERENCE_POSTFIX = "";
    private static final String PRIMITIVES_ARRAY_POSTFIX = "";
    private static final String PRIMITIVES_MATRIX_POSTFIX = "";

    private static final String INTEGER_TYPE = "Integer";
    private static final String STRING_TYPE = "String";
    private static final String BYTE_TYPE = "Byte";
    public static final String REFERENCE_TYPE = "Reference";

    private static int intAccumulator = 0;
    private static String strAccumulator = "";
    private static int strAccumulatorCount = 0;
    private static byte byteAccumulator = 0;

    private static String prevType = "";

    public static void log(char message) {
        flush();
        printMessage(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(boolean message) {
        flush();
        printMessage(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        String currType = "";
        if (message instanceof String) {
            currType = STRING_TYPE;
            accumulate((String) message);
        } else if (message instanceof Byte) {
            currType = BYTE_TYPE;
            accumulate((Byte) message);
        } else if (message instanceof Integer) {
            currType = INTEGER_TYPE;
            accumulate((Integer) message);
        } else {
            currType = REFERENCE_TYPE;
            flush();
            printMessage(decorate(REFERENCE_PREFIX, message, REFERENCE_POSTFIX));
        }
        if (!currType.equals(prevType)) {
            flush();
        }
        prevType = currType;
    }

    public static void log(int[] messages) {
        flush();
        printMessage(decorate(PRIMITIVES_ARRAY_PREFIX, messages, PRIMITIVES_ARRAY_POSTFIX));
    }

    public static void log(int[][] messages) {
        flush();
        printMessage(decorate(PRIMITIVES_MATRIX_PREFIX, messages, PRIMITIVES_MATRIX_POSTFIX));
    }

    public static void log(Object... messages) {
        flush();
        for (Object message : messages) {
            log(message);
        }
    }

    public static void flush() {
        if (STRING_TYPE.equals(prevType)) {
            printMessage(decorate(STRING_PREFIX, strAccumulatorWithCount(), STRING_POSTFIX));
            strAccumulator = "";
            strAccumulatorCount = 0;
        } else if (INTEGER_TYPE.equals(prevType)) {
            printMessage(decorate(PRIMITIVE_PREFIX, intAccumulator, PRIMITIVE_POSTFIX));
            intAccumulator = 0;
        } else if (BYTE_TYPE.equals(prevType)) {
            printMessage(decorate(PRIMITIVE_PREFIX, byteAccumulator, PRIMITIVE_POSTFIX));
            byteAccumulator = 0;
        }
        prevType = "";
    }

    private static String strAccumulatorWithCount() {
        if (strAccumulatorCount > 1) {
            return strAccumulator + " (x" + strAccumulatorCount + ")";
        }
        return strAccumulator;
    }

    private static void accumulate(String message) {
        if (!message.equals(strAccumulator)) {
            flush();
            strAccumulatorCount = 0;
            strAccumulator = message;
        }
        strAccumulatorCount++;
    }

    private static void accumulate(int message) {
        if ((isOverflow(intAccumulator, message, intAccumulator + message))) {
            flush();
        }
        intAccumulator += message;
    }

    private static void accumulate(byte message) {
        if (isOverflow(message, byteAccumulator, (byte) (byteAccumulator + message))) {
            flush();
        }
        byteAccumulator += message;
    }

    private static boolean isOverflow(int a, int b, int sum) {
        return (a > 0 && b > sum) || (a < 0 && b < sum);
    }

    private static String decorate(String prefix, Object message, String postfix) {
        String messageAsString;
        if (message instanceof int[][]) {
            messageAsString = intMatrixAsString((int[][]) message);
        } else if (message instanceof int[]) {
            messageAsString = intArrayAsString((int[]) message);
        } else {
            messageAsString = message.toString();
        }
        return prefix + messageAsString + postfix;
    }

    private static String intMatrixAsString(int[][] message) {
        StringBuilder decoratedMatrix = new StringBuilder();
        String sep = System.lineSeparator();
        decoratedMatrix.append("{").append(sep);
        for (int[] array : message) {
            decoratedMatrix.append(intArrayAsString(array)).append(sep);
        }
        decoratedMatrix.append("}");
        return decoratedMatrix.toString();
    }

    private static String intArrayAsString(int[] message) {
        List<String> list = new ArrayList<>();
        for (int i : message) {
            list.add(String.valueOf(i));
        }
        return "{" + String.join(", ", list) + "}";
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}

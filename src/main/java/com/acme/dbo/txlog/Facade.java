package com.acme.dbo.txlog;

import static java.lang.Math.abs;

public class Facade {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static final String PRIMITIVES_ARRAY = "primitives array: ";
    public static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    public static final int INTEGER_TYPE = 1;
    public static final int BYTE_TYPE = 2;
    public static final int STRING_TYPE = 3;
    public static int lastType;
    public static String lastString;
    public static int accumulator;

    public static void typeOverFlowHandling(int message, int limit, String option) {
        if (abs(message) >= limit) {
            printToConsole(PRIMITIVE, limit);
        } else {
            switch (option) {
                case "Integer":
                    accumulator += message;
                    printToConsole(PRIMITIVE, accumulator);
                    break;
                case "Byte":
                    printToConsole(PRIMITIVE, message);
            }
        }
    }

    public static void log(int message) {
        if (lastType != INTEGER_TYPE) {
            flush();
        }
        typeOverFlowHandling(message, Integer.MAX_VALUE, "Integer");
        lastType = INTEGER_TYPE;
    }

    public static void log(byte message) {
        if (lastType != BYTE_TYPE) {
            flush();
        }
        typeOverFlowHandling(message, Byte.MAX_VALUE, "Byte");
        lastType = BYTE_TYPE;
    }

    public static void log(boolean message) {
        printToConsole(PRIMITIVE, message);
    }

    public static void log(char message) {
        printToConsole(CHAR, message);
    }

    public static void log(String message) {
        if ((lastType != STRING_TYPE) || (lastString != null && !message.equals(lastString))) {
            flush();
        }
        lastType = STRING_TYPE;
        lastString = message;
        accumulator++;
    }

    public static void log(Object message) {
        printToConsole(REFERENCE, message);
    }

    public static void printToConsole(String prefix, Object message) {
        System.out.println(prefix + message);
    }

    public static void flush() {
        switch (lastType) {
            case INTEGER_TYPE:
            case BYTE_TYPE:
                break;
            case STRING_TYPE:
                printToConsole(STRING, lastString + (accumulator == 1 ? "" : " (x" + accumulator + ")"));
                break;
        }
        accumulator = 0;
    }

    public static void log(int message, int... messages) {
        log(message);
        for (int i : messages) {
            log(i);
        }
    }

    public static void log(String... message) {
        for (String s : message) {
            log(s);
        }
    }

    public static void log(int[] message) {
        printToConsole(PRIMITIVES_ARRAY, decoratedIntArray(message));
    }

    public static void log(int[][] message) {
        printToConsole(PRIMITIVES_MATRIX, decoratedIntMatrix(message));
    }

    private static StringBuilder decoratedIntArray(int[] message) {
        int lastIndex = message.length - 1;
        StringBuilder stringBuilderOfIntArray = new StringBuilder("{");
        for (int i = 0; i < lastIndex; i++) {
            stringBuilderOfIntArray.append(message[i]);
            stringBuilderOfIntArray.append(", ");
        }
        stringBuilderOfIntArray.append(message[lastIndex]);
        return stringBuilderOfIntArray.append("}");
    }

    private static StringBuilder decoratedIntMatrix(int[][] message) {
        StringBuilder stringBuilderOfIntMatrix = new StringBuilder("{" + System.lineSeparator());
        for (int[] ints : message) {
            stringBuilderOfIntMatrix.append(decoratedIntArray(ints));
            stringBuilderOfIntMatrix.append(System.lineSeparator());
        }
        return stringBuilderOfIntMatrix.append("}");
    }
}
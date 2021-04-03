/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;


import java.util.Arrays;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String ARRAY_PREFIX = "primitives array: ";
    public static final String MATRIX_PREFIX = "primitives matrix: ";
    private static String currentType = null;
    private static String stringMessageBody = null;
    private static Integer duplicateMessageCount = null;
    private static Integer numberAccumulator = null;


    public static void log(int message) {
        accumulator(message, "Integer");
    }

    public static void log(byte message) {
        accumulator(message, "Byte");
    }

    public static void log(String message) {
        accumulator(message, "String");
    }

    public static void log(int[] message) {
        accumulator(message, "int[]");
    }

    public static void log(int[][] message) {
        accumulator(message, "int[][]");
    }



    private static void stringAccumulatorStrategy(String message) {
        if (stringMessageBody != null && stringMessageBody.equals(message)) {
            duplicateMessageCount++;
            return;
        }
        flush();
        stringMessageBody = message;
        duplicateMessageCount = 1;

    }

    private static void arrayStrategy(int[] message) {
        String result = Arrays.toString(message);
        arrayOutputStrategy(ARRAY_PREFIX, result);
    }

    private static void arrayStrategy(int[][] message) {
        StringBuilder result = new StringBuilder();
        result.append("{\r\n");
        for (int[] elem: message) {
            result.append(Arrays.toString(elem));
            result.append("\r\n");
        }
        result.append("}");

        String endMessage = result.toString();
        arrayOutputStrategy(MATRIX_PREFIX, endMessage);

    }

    private static void numberAccumulatorStrategy(Number message) {
        int maxValue = 0;
        int logMessage = message.intValue();

        if (message instanceof Integer) {
            maxValue = Integer.MAX_VALUE;
        }
        if (message instanceof Byte) {
            maxValue = Byte.MAX_VALUE;
        }

        if (message.intValue() == maxValue) {
            flush();
            numberAccumulator = logMessage;
            flush();
            return;
        }

        if (numberAccumulator == null) {
            numberAccumulator = logMessage;

        } else {
            numberAccumulator += logMessage;
        }
    }

    private static void accumulator(Object message, String type) {
        if (!type.equals(currentType)) {
            currentType = type;
            flush();
        }
        if (type.equals("String")) {
            stringAccumulatorStrategy((String) message);
        }
        if (type.equals("Byte") || type.equals("Integer")) {
            numberAccumulatorStrategy((Number) message);
        }
        if (type.equals("int[]")) {
            arrayStrategy((int[]) message);
        }
        if (type.equals("int[][]")) {
            arrayStrategy((int[][]) message);
        }
    }

    public static void flush() {
        stringOutputStrategy();
        numberOutputStrategy();
        stringMessageBody = null;
        duplicateMessageCount = null;
        numberAccumulator = null;
    }

    public static void stringOutputStrategy() {
        String postfix = "";
        if (stringMessageBody != null) {
            if (duplicateMessageCount > 1) {
                postfix = " (x" + duplicateMessageCount + ")";
            }
            logToConsole(STRING_PREFIX, stringMessageBody + postfix);
        }
    }

    public static void numberOutputStrategy() {
        if (numberAccumulator != null) {
            logToConsole(PRIMITIVE_PREFIX, numberAccumulator.toString());
        }
    }

    public static void arrayOutputStrategy(String prefix, String message) {
        message = message.replace('[', '{').replace(']', '}');
        logToConsole(prefix, message);
    }



    private static void logToConsole(String prefix, String message) {
        System.out.println(prefix + message);
    }
}
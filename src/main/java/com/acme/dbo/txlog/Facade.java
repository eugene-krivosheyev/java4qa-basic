package com.acme.dbo.txlog;

import java.lang.reflect.Array;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String OBJECT_PREFIX = "reference: ";
    public static final String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";
    public static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    public static final String OPENING_BRACKET = "{";

    private static final String PRIMITIVE_POSTFIX = "";
    private static final String STRING_POSTFIX = "";
    private static final String CHAR_POSTFIX = "";
    private static final String OBJECT_POSTFIX = "";
    private static final String CLOSING_BRACKET = "}";

    private static Object prevValue = null;
    private static int numberOfStrings = 1;

    private static void printMessage(Object message) {
        System.out.println(message);
    }

    private static void logNotAcc(Object message) {
        flush();
        printMessage(message);
    }

    private static void logAccNumber(Number message, Number maxValue, Number minValue) {
        if (prevValue != null && prevValue.getClass().getName().equals(message.getClass().getName())) {
            if (!message.equals(maxValue) && !message.equals(minValue)) {
               switch(message.getClass().getName()) {
                   case "java.lang.Integer": {
                       prevValue = (int)prevValue + (int)message;
                       break;
                   }
                   case "java.lang.Byte": {
                       prevValue = (byte)prevValue + (byte)message;
                       break;
                   }
               }
            } else {
                logNotAcc(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
            }
        } else {
            updatePrevValue(message);
        }
    }

    private static String decorate(String stringPrefix, Object message, String stringPostfix) {
        return stringPrefix + message + stringPostfix;
    }

    private static String[] getPrefixAndPostfix(Object message) {
        String[] res = new String[2];
        switch (message.getClass().getName()) {
            case "java.lang.Byte":
            case "java.lang.Integer":
            case "java.lang.Boolean": {
                res[0] = PRIMITIVE_PREFIX;
                res[1] = PRIMITIVE_POSTFIX;
                break;
            }
            case "java.lang.Character": {
                res[0] = CHAR_PREFIX;
                res[1] = CHAR_POSTFIX;
                break;
            }
            case "java.lang.String": {
                res[0] = STRING_PREFIX;
                res[1] = STRING_POSTFIX;
                break;
            }
            default: {
                res[0] = OBJECT_PREFIX;
                res[1] = OBJECT_POSTFIX;
                break;
            }
        }
        return res;
    }

    public static void log(byte message) {
        logAccNumber(message, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    public static void log(int message) {
        logAccNumber(message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void log(char message) {
        logNotAcc(decorate(CHAR_PREFIX, message, CHAR_POSTFIX));
    }

    public static void log(String message) {
        if (prevValue instanceof String && prevValue == message) {
            numberOfStrings += 1;
        } else {
            updatePrevValue(message);
        }
    }

    public static void log(boolean message) {
        logNotAcc(decorate(PRIMITIVE_PREFIX, message, PRIMITIVE_POSTFIX));
    }

    public static void log(Object message) {
        logNotAcc(decorate(OBJECT_PREFIX, message, OBJECT_POSTFIX));
    }

    public static String getStringFromArray(int[] messages) {
        String resultMessage = "";
        for (int i = 0; i < messages.length; i++) {
            if (i != 0) {
                resultMessage += ", ";
            }
            int message = messages[i];
            resultMessage += message;
        }
        return resultMessage;
    }

    public static void log(int[] messages) {
        logNotAcc(decorate(PRIMITIVES_ARRAY_PREFIX + OPENING_BRACKET, getStringFromArray(messages), CLOSING_BRACKET));
    }

    public static void log(int[][] matrix) {
        printMessage(PRIMITIVES_MATRIX_PREFIX + OPENING_BRACKET);
        for (int[] row: matrix) {
            logNotAcc(decorate(OPENING_BRACKET, getStringFromArray(row), CLOSING_BRACKET));
        }
        printMessage(CLOSING_BRACKET);
    }

    public static void log(String... messages) {
        for (String message: messages) {
            log(message);
        }
    }

    private static void updatePrevValue(Object message) {
        flush();
        prevValue = message;
    }

    public static void flush() {
        if (prevValue != null) {
            String[] prefixAndPostfix = getPrefixAndPostfix(prevValue);
            if (prevValue instanceof String && numberOfStrings != 1) {
                printMessage(decorate(prefixAndPostfix[0], prevValue + " (x" + numberOfStrings + ")", prefixAndPostfix[1]));
            } else {
                printMessage(decorate(prefixAndPostfix[0], prevValue, prefixAndPostfix[1]));
            }
            prevValue = null;
            numberOfStrings = 1;
        }
    }
}

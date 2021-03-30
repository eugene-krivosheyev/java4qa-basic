package com.acme.dbo.txlog;

import org.w3c.dom.ls.LSOutput;

public class Facade {
    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String REFERENCE_PREFIX = "reference: ";

    private static boolean intSeq;
    private static int intSum;
    private static boolean byteSeq;
    private static byte byteSum;
    private static int stringCounter;
    private static String lastString;
    private static String typeState = "none";

    public static void log(int message) {
        if (!typeState.equals("int")) {
            flush();
        }
        if ((long) intSum + message >= Integer.MAX_VALUE) {
            flush();
        }
        collect(message);
    }

    public static void log(byte message) {
        if (!typeState.equals("byte")) {
            flush();
        }

        if (byteSum + message >= Byte.MAX_VALUE || byteSum + message < 0) {
            System.out.println(">>" + byteSum);
            System.out.println(">>" + message);
            flush();
        }
        collect(message);
    }

    public static void log(char message) {
        printMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        if (!typeState.equals("string")) {
            flush();
        }

        if (lastString != null && !lastString.equals(message)) {
            flush();
        }
        lastString = message;
        collect();
    }

    public static void log(boolean message) {
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        printMessage(decorate(REFERENCE_PREFIX, message));
    }

    private static void printMessage(Object message) {
        System.out.println(message);
    }

    private static String decorate(String prefix, Object message) {
        return prefix + message;
    }

    private static void collect(int message) {
        intSeq = true;
        intSum += message;
        typeState = "int";
    }

    private static void collect(byte message) {
        byteSeq = true;
        byteSum += message;
        typeState = "byte";
    }

    private static void collect() {
        stringCounter++;
        typeState = "string";
    }

    public static void flush() {
        if (intSeq) {
            printMessage(decorate(PRIMITIVE_PREFIX, intSum));
            intSeq = false;
            intSum = 0;
        }

        if (byteSeq) {
            printMessage(decorate(PRIMITIVE_PREFIX, byteSum));
            byteSeq = false;
            byteSum = 0;
        }

        if (lastString != null) {
            if (stringCounter > 0) {
                printMessage(
                        decorate(
                                STRING_PREFIX,lastString + (stringCounter > 1 ? String.format(" (x%s)", stringCounter) : ""))
                );
                stringCounter = 0;
            }
            lastString = "none";
        }
    }

}

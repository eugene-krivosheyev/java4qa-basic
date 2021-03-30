package com.acme.dbo.txlog;

public class Facade {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static Integer intMessagesAccumulated = null;
    private static String stringMesssagesAccumulated = null;
    private static Integer byteMessagesAccumulated = null;
    private static Integer duplicatedStringMessagesCounter = 0;

    public static void log(int message) {
        if (intMessagesAccumulated == null || ((long) intMessagesAccumulated + (long) message > Integer.MAX_VALUE)) {
            flush();
            intMessagesAccumulated = message;
        } else {
            intMessagesAccumulated += message;
        }
    }

    public static void log(char message) {
        flush();
        printMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        if (stringMesssagesAccumulated == null) {
            stringMesssagesAccumulated = message;
        } else {
            if (!stringMesssagesAccumulated.equals(message)) {
                flush();
                stringMesssagesAccumulated = message;
            }
        }
        duplicatedStringMessagesCounter++;
    }

    public static void log(byte message) {
        if (byteMessagesAccumulated == null || (byteMessagesAccumulated + message > Byte.MAX_VALUE)) {
            flush();
            byteMessagesAccumulated = Integer.valueOf(message);
        } else {
            byteMessagesAccumulated += message;
        }
    }

    public static void log(boolean message) {
        flush();
        printMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        flush();
        printMessage(decorate(REFERENCE_PREFIX, message));
    }

    public static void flush() {
        if (ifIntCurrentState(intMessagesAccumulated)) {
            if (intMessagesAccumulated == Integer.MAX_VALUE) {
                printMessage(decorate(PRIMITIVE_PREFIX, "Integer.MAX_VALUE"));
            } else {
                printMessage(decorate(PRIMITIVE_PREFIX, intMessagesAccumulated));
            }
        }

        if (ifByteCurrentState(byteMessagesAccumulated)) {
            if (byteMessagesAccumulated == Byte.MAX_VALUE) {
                printMessage(decorate(PRIMITIVE_PREFIX, "Byte.MAX_VALUE"));
            } else {
                printMessage(decorate(PRIMITIVE_PREFIX, byteMessagesAccumulated));
            }
        }

        if (ifStringCurrentState(duplicatedStringMessagesCounter)) {
            if (duplicatedStringMessagesCounter == 1) {
                printMessage(decorate(STRING_PREFIX, stringMesssagesAccumulated));
            } else {
                printMessage(decorate(STRING_PREFIX, stringMesssagesAccumulated + " (x" + duplicatedStringMessagesCounter + ")"));
            }

        }
        intMessagesAccumulated = null;
        byteMessagesAccumulated = null;
        duplicatedStringMessagesCounter = 0;
    }


    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String decorate(String stringPrefix, Object message) {
        return stringPrefix + message;
    }

    private static boolean ifIntCurrentState(Integer intMessagesAccumulated) {
        return intMessagesAccumulated != null;
    }

    private static boolean ifStringCurrentState(Integer stringMessagesRepeatCounter) {
        return stringMessagesRepeatCounter != 0;
    }

    private static boolean ifByteCurrentState(Integer byteMessagesAccumulated) {
        return byteMessagesAccumulated != null;
    }
}

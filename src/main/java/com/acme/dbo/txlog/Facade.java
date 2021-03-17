package com.acme.dbo.txlog;

//import java.io.IOException;

public class Facade {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX      = "char: ";
    public static final String STRING_PREFIX    = "string: ";
    public static final String REFERENCE_STRING = "reference: ";

    //region log methods
    public static void log(int message) {
        if (message >= 0)
            { printMessage(PRIMITIVE_PREFIX + message); }
        else
            throw new IllegalArgumentException("Message is less than 0.");
    }

    public static void log(byte message) {
        printMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        printMessage(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        printMessage(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        printMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printMessage(REFERENCE_STRING + message);
    }
    //endregion

    private static void printMessage(Object message) {

        System.out.println(message);
    }
}

/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;

/**
 * Facade
 * @author kjghdkfjghdkfjhg
 * @since 1.0
 */

public class Facade {
    public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: @";
    public static final String FORMAT_PATTER = "%s %s %s";

    /**
     * message != null
     */
    //@Contract(!null -> !null)
    public static void log(/* @NotNull */ int message) { //formal arg
        printToConsole(PREFIX_PRIMITIVE + message + '\n');
    }

    public static void log(char message) {
        printToConsole(PREFIX_CHAR + message);
    }

    public static void log(byte message) {
        printToConsole(PREFIX_PRIMITIVE + message);
    }

    public static void log(String message) {
        printToConsole(PREFIX_STRING + message);
    }

    public static void log(boolean message) {
        printToConsole(PREFIX_PRIMITIVE + message + '\n');
    }

    public static void log(Object message) {
        printToConsole(PREFIX_REFERENCE + message + '\n');;
    }

    public static void log(String message1, String message2) {

    }

    /*
    private static String decorate(String prefix, Object msg, String postfix) {
        return System.out.printf(FORMAT_PATTER, prefix, msg, postfix);
    }
     */

    private static void printToConsole(String message) {
        System.out.print(message);
    }
}
// single-line

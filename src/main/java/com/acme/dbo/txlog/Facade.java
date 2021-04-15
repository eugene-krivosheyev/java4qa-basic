/**
 * jkgjdhkgjhdfkgjdhfk
 */
package com.acme.dbo.txlog;


import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class Facade {
    private static final LogController logController = new LogController(new ConsolePrinter());

    public static void log(char message) {
        logController.log(new CharMessage(message));
    }

    public static void log(int message) {
        logController.log(new IntMessage(message));
    }

    public static void log(boolean message) {
        logController.log(new BooleanMessage(message));
    }

    public static void log(byte message) {
        logController.log(new ByteMessage(message));
    }

    public static void log(String message) {
        logController.log(new StringMessage(message));
    }

    public static void log(String... message) {
        logController.log(new StringArrayMessage(message));
    }

    public static void log(Object message) {
        logController.log(new ObjectMessage(message));
    }

    public static void log(int... message) {
        logController.log(new IntArrayMessage(message));
    }

    public static void log(int[][] message) {
        logController.log(new IntMatrixMessage(message));
    }

    public static void flush() {
        logController.flush();
    }
}

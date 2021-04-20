package com.acme.dbo.txlog;

import com.acme.dbo.txlog.controller.LoggerController;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class Facade {

    private static final LoggerController logger = new LoggerController(new ConsolePrinter());

    public static void log(int message) {
        logger.log(new IntMessage(message));
    }

    public static void log(byte message) {
        logger.log(new ByteMessage(message));
    }

    public static void log(char message) {
        logger.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        logger.log(new BooleanMessage(message));
    }

    public static void log(String message) {
        logger.log(new StringMessage(message));
    }

    public static void log(String... messages) {
        for (String message: messages) {
            log(message);
        }
    }

    public static void log(int[] intArrayMessage) {
        logger.log(new IntArrayMessage(intArrayMessage));
    }

    public static void log(int[][] intMatrix) {
        logger.log(new IntArrayMatrixMessage(intMatrix));
    }

    public static void log(Object message) {
        logger.log(new ObjectMessage(message));
    }

    public static void flush() {
        logger.flush();
    }

}

package com.acme.dbo.txlog;

import com.acme.dbo.txlog.domain.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class LoggerFacade {
    private static LoggerController controller = new LoggerController(new ConsolePrinter());

    public static void log (byte message){
        controller.log(new ByteMessage(message));
    }
    public static void log (int message){
        controller.log(new IntMessage(message));
    }

    public static void log (char message){
        controller.log(new CharMessage(message));
    }

    public static void log (String message){
        controller.log(new StringMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int[] message) {
        controller.log(new ArrayMessage(message));
    }

    public static void log(int[][] message) {
        controller.log(new MatrixMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(String... messages) {
        for (String message: messages) {
            log(message);
        }
    }

    public static void log(int firstMessage, int... messages) {
        log(firstMessage);
        for (int message: messages) {
            log(message);
        }
    }

    public static void flush(){
        controller.flush();
    }

}

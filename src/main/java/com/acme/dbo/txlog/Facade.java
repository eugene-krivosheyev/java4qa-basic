package com.acme.dbo.txlog;

public class Facade {

    private static LoggerService loggerService = new LoggerService(
            new ConsoleLogger()
    );

    public static void log(int message) {
       loggerService.log(new IntMessage(message));
    }

    public static void log(String message) {
       loggerService.log(new StringMessage(message));
    }

    public static void log(byte message) {
        loggerService.log(new ByteMessage(message));
    }

    public static void log(char message) {
        loggerService.log(new CharMessage(message));
    }

    public static void log(int[] message) {
        loggerService.log(new ArrayIntegerMessage(message));
    }

    public static void log(int[][] message) {
        loggerService.log(new MatrixIntegerMessage(message));
    }

    public static void log(String ...message) {
        for (String string: message) {
            loggerService.log(new StringMessage(string));
        }
    }

    public static void log(boolean message) {
        loggerService.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        loggerService.log(new ReferenceMessage(message));
    }

    public static void close() {
        loggerService.close();
    }



}

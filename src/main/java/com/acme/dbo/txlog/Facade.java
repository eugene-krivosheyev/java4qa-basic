package com.acme.dbo.txlog;

import com.acme.dbo.txlog.controller.LoggerController;
import com.acme.dbo.txlog.filter.SeverityMessageFilter;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;

import static com.acme.dbo.txlog.SeverityLevel.ERROR;
import static com.acme.dbo.txlog.SeverityLevel.INFO;
import static java.lang.System.*;

public class Facade {

    public static LoggerController lc = new LoggerController(new ConsolePrinter(),new SeverityMessageFilter(ERROR));

    public static void log(int message) {
        lc.log(new IntMessage(message), INFO);
    }

    public static void log(byte message) {
        lc.log(new ByteMessage(message), INFO);
    }

    public static void log(char message) {
        lc.log(new CharMessage(message),INFO);
    }

    public static void log(String message) {
        lc.log(new StringMessage(message), INFO);
    }

    public static void log(boolean message) {
        lc.log(new BoolMessage(message), INFO);
    }

    public static void log(Object message) {
        lc.log(new RefMessage(message), INFO);
    }

    public static void log(int[] message) {
        lc.log(new IntArrayMessage(message), INFO);
    }

    public static void log(int[][] message) {
        lc.log(new IntMatrixMessage(message), INFO);
    }

    public static void log(String... message) {
        String stringAccum = "";
        for (String current:message) {
            stringAccum = stringAccum + current + "\n";
            lc.log(new StringMessage(stringAccum), INFO);
            lc.flush();
            lc.log(new StringMessage(", "), INFO);
            lc.flush();
        }

    }

    public static void log(long... message) {
        int numericAccum = 0;

        for (int i = 0; i < message.length; i++) {
            numericAccum = numericAccum + (int) message[i];
            lc.log(new IntMessage(numericAccum), INFO);
            lc.flush();
            lc.log(new StringMessage(", "), INFO);
            lc.flush();
        }

    }

    public static void flush( ) {
        lc.flush();
    }


}

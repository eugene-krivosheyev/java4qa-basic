package com.acme.dbo.txlog.facade;

import com.acme.dbo.txlog.controller.LoggerController;
import com.acme.dbo.txlog.message.BooleanDecoratingMessage;
import com.acme.dbo.txlog.message.CharDecoratingMessage;
import com.acme.dbo.txlog.message.IntArrayDecoratingMessage;
import com.acme.dbo.txlog.message.IntMatrixDecoratingMessage;
import com.acme.dbo.txlog.message.IntMultimatrixDecoratingMessage;
import com.acme.dbo.txlog.message.ReferenceDecoratingMessage;
import com.acme.dbo.txlog.message.accumulating.ByteDecoratingMessage;
import com.acme.dbo.txlog.message.accumulating.IntDecoratingMessage;
import com.acme.dbo.txlog.message.accumulating.StringDecoratingMessage;
import com.acme.dbo.txlog.printer.ConsolePrinter;

import java.util.stream.Stream;

public class Facade {

    private static final LoggerController loggerController = new LoggerController(new ConsolePrinter());

    public static void log(final int message) {
        loggerController.log(new IntDecoratingMessage(message));
    }

    public static void log(final byte message) {
        loggerController.log(new ByteDecoratingMessage(message));
    }

    public static void log(final int... message) {
        loggerController.log(new IntArrayDecoratingMessage(message));
    }

    public static void log(final int[][] message) {
        loggerController.log(new IntMatrixDecoratingMessage(message));
    }

    public static void log(final int[][][][] message) {
        loggerController.log(new IntMultimatrixDecoratingMessage(message));
    }

    public static void log(final boolean message) {
        loggerController.log(new BooleanDecoratingMessage(message));
    }

    public static void log(final char message) {
        loggerController.log(new CharDecoratingMessage(message));
    }

    public static void log(final String... message) {
        Stream.of(message).forEach(Facade::log);
    }

    public static void log(final String message) {
        loggerController.log(new StringDecoratingMessage(message));
    }

    public static void log(final Object message) {
        loggerController.log(new ReferenceDecoratingMessage(message));
    }

    public static void flush() {
        loggerController.flush();
    }
}

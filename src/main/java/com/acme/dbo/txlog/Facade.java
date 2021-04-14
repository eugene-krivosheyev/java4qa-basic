package com.acme.dbo.txlog;

import com.acme.dbo.txlog.controller.LoggerController;
import com.acme.dbo.txlog.filter.SeverityLevelMessageFilter;
import com.acme.dbo.txlog.filter.SeverityLevel;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class Facade {
    private static final LoggerController controller = new LoggerController(
            new ConsolePrinter(),
            new SeverityLevelMessageFilter(SeverityLevel.DEBUG)
    );

    public static void log(int message) {
        controller.log(new IntMessage(message), SeverityLevel.INFO);
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message), SeverityLevel.INFO);
    }

    public static void log(char message) {
        controller.log(new CharMessage(message), SeverityLevel.INFO);
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message), SeverityLevel.INFO);
    }

    public static void log(String message) {
        controller.log(new StringMessage(message), SeverityLevel.INFO);
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message), SeverityLevel.INFO);
    }

    public static void flush() {
        controller.log(new EmptyMessage(), SeverityLevel.INFO);
    }
}

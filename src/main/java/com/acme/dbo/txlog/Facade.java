package com.acme.dbo.txlog;

import com.acme.dbo.txlog.logger.*;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.*;

public class Facade {

    private static LoggerController logger = new SimpleLogger(new ConsolePrinter());

    public static void log(int message) {
        logger.log(new IntMessage(message));
    }

    public static void log(byte message) {
        logger.log(new ByteMessage(message));
    }

    public static void log(char message) {
        logger.log(new CharMessage(message));
    }

    public static void log(String message) {
        logger.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        logger.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        logger.log(new ObjectMessage(message));
    }
}

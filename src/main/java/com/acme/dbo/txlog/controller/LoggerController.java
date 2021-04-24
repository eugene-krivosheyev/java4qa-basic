package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.DecoratingMessage;
import com.acme.dbo.txlog.printer.Printer;

public class LoggerController {

    private final Printer printer;

    private DecoratingMessage lastMessage;

    public LoggerController(final Printer printer) {
        this.printer = printer;
    }

    public void log(final DecoratingMessage message) {
        if (lastMessage == null) {
            lastMessage = message;
            return;
        }

        DecoratingMessage accumulatedMessage = lastMessage.accumulate(message);
        if (accumulatedMessage == message) {
            printer.print(lastMessage.getDecoratedMessage());
        }

        lastMessage = accumulatedMessage;
    }

    public void flush() {
        if (lastMessage != null) {
            printer.print(lastMessage.getDecoratedMessage());
            lastMessage = null;
        }
    }
}

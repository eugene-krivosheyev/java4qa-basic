package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.filter.MessageFilter;
import com.acme.dbo.txlog.filter.SeverityLevel;
import com.acme.dbo.txlog.message.EmptyMessage;
import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.printer.Printer;

public class LoggerController {
    private final Printer printer;
    private final MessageFilter messageFilter;

    private Message currentMessage = new EmptyMessage();

    public LoggerController(Printer printer, MessageFilter messageFilter) {
        this.printer = printer;
        this.messageFilter = messageFilter;
    }

    public void log(Message message, SeverityLevel logLevel) {
        if (message == null || !messageFilter.filter(message, logLevel)) {
            return;
        }

        if (message.equals(currentMessage)) {
            final boolean canAccumulate = currentMessage.accumulate(message);
            if (!canAccumulate) {
                printer.print(currentMessage.getDecoratedMessage());
                printer.print(message.getDecoratedMessage());
            }
        } else {
            printer.print(currentMessage.getDecoratedMessage());
            currentMessage = message;
        }
    }
}

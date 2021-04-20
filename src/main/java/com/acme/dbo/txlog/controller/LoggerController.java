package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.printer.Printer;

import static  com.acme.dbo.txlog.controller.AccumulatorState.*;


public class LoggerController {
    private Message currentValue;
    private Printer printer;

    public LoggerController(Printer printer) {
        this.printer = printer;
        this.currentValue = new NullMessage();
    }

    public void log(Message message) {
        if (!(currentValue.getStatus() == message.getStatus()) || !(currentValue.isAccumulatable(message))) {
            flush();
        }
        currentValue = currentValue.accumulate(message);
    }

    public void flush() {
        if (!(currentValue.getStatus() == NONE)) {
            printer.print(currentValue.toString());
        }
        currentValue = new NullMessage();

    }

}

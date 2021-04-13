package com.acme.dbo.txlog.logger;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.printer.Printer;

public class SimpleLogger implements LoggerController {
    private Printer printer;

    public SimpleLogger(Printer printer){
        this.printer = printer;
    }

    @Override
    public void log(Message message) {
        printer.print(message.getDecorateBody());
    }
}

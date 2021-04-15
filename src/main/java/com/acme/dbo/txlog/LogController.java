package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.message.NullMessage;
import com.acme.dbo.txlog.printer.Printer;

public class LogController {
    private final Printer printer;
    private Message currentState = new NullMessage();

    public LogController(Printer printer) {
        this.printer = printer;
    }

    public void log(Message message) {
        if (this.currentState.equalType(message)) { //Optional
            currentState = currentState.accumulate(message);
            if (currentState.getMessageIfCurrentMessageFlushedAfterAccumulation()!=null) {
                printer.print(currentState
                        .getMessageIfCurrentMessageFlushedAfterAccumulation()
                        .getDecoratedMessage()
                );
            } ;
        } else {
            flush();
            currentState = message;
        }
    }

    public void flush() {
        printer.print(currentState.getDecoratedMessage());
        currentState = new NullMessage();
    }
}

package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.message.NullMessage;
import com.acme.dbo.txlog.printers.Printer;

public class LoggerController {

    private Message currentStateValue = new NullMessage();
    private Printer printer;

    LoggerController(Printer printer) {
        this.printer = printer;
    }


    public void log(Message message) {
        if (currentStateValue instanceof NullMessage) {
            currentStateValue = message;
            if (message.immediatelyFlushable()) {
                flush();
            }
        } else {
            if (message.immediatelyFlushable()) {
                flush();
                currentStateValue = message;
                flush();
            } else if (!(currentStateValue.getClass() == message.getClass()) || !currentStateValue.accumulatableWith(message)) {
                flush();
                currentStateValue = message;
            } else {
                currentStateValue = currentStateValue.accumulate(message);
            }
        }

    }

    public void flush() {
        if (!(currentStateValue instanceof NullMessage)) {     //1st msg
            printer.print(currentStateValue.getDecoratedBody());
        }
        currentStateValue = new NullMessage();
    }

}



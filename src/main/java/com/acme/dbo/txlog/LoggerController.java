package com.acme.dbo.txlog;

import com.acme.dbo.txlog.domain.Message;
import com.acme.dbo.txlog.domain.NullMessage;
import com.acme.dbo.txlog.printer.Printer;

public class LoggerController {

    private Message currentStateValue = new NullMessage();
    private Printer printer;

    LoggerController(Printer printer){
        this.printer = printer;
    }

    public void log(Message newMessage) {
        if (newMessage.shouldFlush(currentStateValue)) { //accum
            flush();
            currentStateValue = newMessage;
        } else { //flush
            currentStateValue = currentStateValue.accumulate(newMessage);
        }
    }

    public void flush() {
        printer.print(currentStateValue.toString());
        currentStateValue = new NullMessage();
    }
}

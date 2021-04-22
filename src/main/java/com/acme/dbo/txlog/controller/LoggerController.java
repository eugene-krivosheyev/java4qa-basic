package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.SeverityLevel;
import com.acme.dbo.txlog.message.DecoratingMessage;
import com.acme.dbo.txlog.filter.MessageFilter;
import com.acme.dbo.txlog.printer.Printer;

/**
 *  Code reuse : responsibility delegation, inheritance, frameworks
 *  also generic programming, HOF high level functions
 */

public class LoggerController extends ValidatingController {
    private final Printer printer;
    private final MessageFilter filter;

    public static DecoratingMessage getAccumMsg() {
        return accumMsg;
    }

    public static void setAccumMsg(DecoratingMessage accumMsg) {
        LoggerController.accumMsg = accumMsg;
    }

    private static DecoratingMessage accumMsg;

    /**
     * Constructor DI:
     * @param printer
     * @param filter
     */
    public LoggerController(Printer printer, MessageFilter filter) {
        this.printer = printer;
        this.filter = filter;
    }

    public void log(DecoratingMessage message, SeverityLevel severity){
        super.log(message, severity);
        if (filter.filter(message, severity)){
            if (accumMsg == null) {
                accumMsg = message;
            } else {
                accumMsg.accumulate(message);
            }
        }
    }

    public void flush(){
        if (accumMsg != null) printer.print(accumMsg.getDecoratedMessage());
        accumMsg = null;
    }

}

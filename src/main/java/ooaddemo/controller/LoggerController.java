package ooaddemo.controller;

import ooaddemo.SeverityLevel;
import ooaddemo.filter.MessageFilter;
import ooaddemo.message.DecoratingMessage;
import ooaddemo.printer.Printer;

/**
 *  Code reuse : responsibility delegation, inheritance, frameworks
 *  also generic programming, HOF high level functions
 */

public class LoggerController extends ValidatingController {
    private final Printer printer;
    private final MessageFilter filter;

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
            printer.print(message.getDecoratedMessage());
        }
    }

}

package ooaddemo.controller;

import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.MessageFilter;
import ooaddemo.message.DecoratingMessage;
import ooaddemo.printer.Printer;

/**
 * Code reuse := responsibility delegation | inheritance | frameworks | generic progr | HOF
 */
public class LoggerController extends ValidatingController {
    private final Printer printer;
    private final MessageFilter filter;

    /**
     * Constructor DI
     */
    public LoggerController(Printer printer, MessageFilter filter) {
        this.printer = printer;
        this.filter = filter;
    }

    @Override
    public void log(DecoratingMessage message, SeverityLevel severity) {
        super.log(message, severity);

        if (filter.filter(message, severity)) {
            printer.print(message.getDecoratedMessage());
        }
    }
}

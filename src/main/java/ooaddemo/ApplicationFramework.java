package ooaddemo;

import ooaddemo.controller.LoggerController;
import ooaddemo.domain.SeverityLevel;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.message.StringMessage;
import ooaddemo.printer.FilePrinter;

/**
 * Application builder
 */
public class ApplicationFramework {
    public static void main(String[] args) {
        //region DI Framework
        final LoggerController loggerController = new LoggerController(
                new FilePrinter("log.txt"), // -> config.xml
                new SeverityMessageFilter(SeverityLevel.WARNING) // -> config.xml
        );
        //endregion

        //region Request Cycle
        /*
        while (true) {
            getRemoteRequest(); //HTTP
            loggerController.log(...);
            sendResponse(); //HTTP
        }
         */
        //endregion
        loggerController.log(new StringMessage("message"), SeverityLevel.ERROR);
    }
}

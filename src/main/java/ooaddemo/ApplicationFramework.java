package ooaddemo;

import ooaddemo.controller.LoggerController;
import ooaddemo.filter.SeverityMessageFilter;
import ooaddemo.printer.FilePrinter;

public class ApplicationFramework {
    public static void main(String... args){
        //region DI framework

        final LoggerController loggerController= new LoggerController(
          new FilePrinter("log.txt"),  // --> config.xml
          new SeverityMessageFilter(SeverityLevel.WARNING) // --> config.xml
        );
        //endregion
        // region request cycle

        /*
        while (true){
            getRemoteRequest(); //HTML
            loggerController.log();
            sendResponse(); //HTML
        }
        */

        //endregion
    }
}

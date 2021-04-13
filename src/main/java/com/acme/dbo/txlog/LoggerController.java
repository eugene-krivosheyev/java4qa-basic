package com.acme.dbo.txlog;

public class LoggerController {
    private Logger logger;

    LoggerController(Logger logger){
        this.logger=logger;
    }

    public void log(Message message){
        logger.log(message);
    }
}

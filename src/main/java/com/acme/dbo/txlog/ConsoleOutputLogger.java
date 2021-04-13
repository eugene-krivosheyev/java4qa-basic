package com.acme.dbo.txlog;

public class ConsoleOutputLogger implements Logger {

    @Override
    public void log(Message message) {
       System.out.println(message.getDecoratedBody()) ;
    }
}

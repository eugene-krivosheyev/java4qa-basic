package com.acme.dbo.txlog;

public class ConsoleLogger implements Logger {
    public void log(Message message) {
        System.out.println(message.getDecoratedBody());
    }
}

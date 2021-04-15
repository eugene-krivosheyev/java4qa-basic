package com.acme.dbo.txlog.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Object message) {
        System.out.println(message);
    }
}

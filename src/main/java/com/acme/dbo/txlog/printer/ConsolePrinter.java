package com.acme.dbo.txlog.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        if (message != null) {
            System.out.println(message);
        }
    }
}

package com.acme.dbo.txlog.printers;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String body){
        System.out.println(body);
    }
}

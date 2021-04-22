package ooaddemo.printer;

import java.io.Serializable;

public class ConsolePrinter implements Printer, Serializable { // IS-A // multiple inheritance

    @Override // optional directive
    public void print(String message) {
        System.out.println("to console" + message);
    }
}

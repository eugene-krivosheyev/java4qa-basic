package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.message.ByteMessage;
import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class LoggerController {
    private static ConsolePrinter printer = new ConsolePrinter();

    public static IntMessage intState = new IntMessage();
    public static StringMessage stringState = new StringMessage();
    public static ByteMessage byteState = new ByteMessage();
    public static Types currentType;

    public enum Types {
        INT,
        BYTE,
        STRING,
    }

    public void log(final IntMessage message) {
        if (currentType != Types.INT) {
            flush(currentType);
        }
        currentType = Types.INT;
        intState.accumulateState(message);
        printer.print(intState.getDecoratedMessage());
    }

    public void log(StringMessage message) {
        if (currentType != Types.STRING
                || !message.getBody().equals(stringState.getBody())) {
            flush(currentType);
        }
        currentType = Types.STRING;
        stringState.accumulateState(message);
    }

    public void log(ByteMessage message) {
        if (currentType != Types.BYTE) {
            flush(currentType);
        }
        currentType = Types.BYTE;
        byteState.accumulateState(message);
        printer.print(byteState.getDecoratedMessage());
    }

    public static void flush(Types type) {
        if (type == null) {
            return;
        }
        switch (type) {
            case INT:
                    intState.flush();
                break;
            case BYTE:
                    byteState.flush();
                break;
            case STRING:
                    printer.print(stringState.getDecoratedMessage());
                    stringState.flush();
                break;
            default:
                break;
        }
    }
}

package com.acme.dbo.txlog.message;

public class CharMessage implements Message {
    private final char message;

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return "char: " + message;
    }
}

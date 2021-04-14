package com.acme.dbo.txlog.message;

public class ReferenceMessage implements Message {
    private final Object message;

    public ReferenceMessage(Object message) {
        this.message = message;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return "reference: " + message;
    }
}

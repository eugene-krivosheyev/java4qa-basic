package com.acme.dbo.txlog.message;

public class EmptyMessage implements Message {
    public EmptyMessage() {
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}

package com.acme.dbo.txlog.message;

public class NullMessage implements Message {
    @Override
    public boolean equalType(Message message) {
        return true;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }

    @Override
    public Message getMessageIfCurrentMessageFlushedAfterAccumulation() {
        return null;
    }
}

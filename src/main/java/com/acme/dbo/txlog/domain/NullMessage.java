package com.acme.dbo.txlog.domain;

public class NullMessage extends AbstractMessage{
    @Override
    public Message accumulate(Message newMessage) {
        return newMessage;
    }

    @Override
    public boolean shouldFlush(Message newMessage) { return false; }

    @Override
    public String toString() {
        return null;
    }
}

package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class NullMessage extends AbstractMessage implements Message{
    public NullMessage() {
        this.status = AccumulatorState.NONE;
    }

    @Override
    public Object getValue() {
        return new Object();
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public NullMessage getDefaultMessage() {
        return new NullMessage();
    }

    public String toString() {
        return "";
    }
}

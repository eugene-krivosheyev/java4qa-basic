package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

abstract class AbstractMessage implements Message {
    protected Object value;
    protected String DECORATION_PREFIX;
    protected String DECORATION_POSTFIX;
    protected AccumulatorState status = AccumulatorState.NONE;

    public Object getValue() {
        return value;
    }

    public AccumulatorState getStatus() {
        return status;
    }

    public String toString() {
        return DECORATION_PREFIX + value + DECORATION_POSTFIX;
    }

    public boolean isAccumulatable (Message message) {
        return false;
    }

    public abstract Message accumulate(Message message);

    public abstract AbstractMessage getDefaultMessage();


}

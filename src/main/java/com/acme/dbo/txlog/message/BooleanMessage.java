package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class BooleanMessage  extends  AbstractMessage implements Message {
    public BooleanMessage(boolean value) {
        this.value = value;
        this.DECORATION_PREFIX = "primitive: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.BOOL;
    }

    public BooleanMessage() {
        this(false);
    }

    @Override
    public BooleanMessage accumulate(Message message) {
        return new BooleanMessage((boolean) message.getValue());
    }

    @Override
    public BooleanMessage getDefaultMessage() {
        return new BooleanMessage();
    }

}

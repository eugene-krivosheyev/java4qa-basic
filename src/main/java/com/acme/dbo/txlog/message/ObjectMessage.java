package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class ObjectMessage extends AbstractMessage implements Message {

    public ObjectMessage(Object value) {
        this.value = value;
        this.DECORATION_PREFIX = "reference: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.OBJ;
    }

    public ObjectMessage() {
        this(new Object());
    }

    @Override
    public ObjectMessage accumulate(Message message) {
        return new ObjectMessage(message.getValue());
    }

    @Override
    public ObjectMessage getDefaultMessage() {
        return new ObjectMessage();
    }
}

package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.controller.AccumulatorState;

public class IntMessage extends AbstractMessage implements Message {

    public IntMessage(int value) {
        this.value = value;
        this.DECORATION_PREFIX = "primitive: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.INT;
    }

    public IntMessage() {
        this(0);
    }

    @Override
    public IntMessage getDefaultMessage() {
        return new IntMessage();
    }

    @Override
    public IntMessage accumulate(Message message) {
        return new IntMessage((int) value + (int) message.getValue());
    }
    @Override
    public boolean isAccumulatable (Message testMessage) {
        if (testMessage.getStatus() == status) {
            return (long) (Integer) value + (Integer) testMessage.getValue() <= Integer.MAX_VALUE;
        } else {
            return false;
        }
    }
}

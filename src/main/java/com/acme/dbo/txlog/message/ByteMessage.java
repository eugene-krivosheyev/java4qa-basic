package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class ByteMessage extends AbstractMessage implements Message{

    public ByteMessage(byte value) {
        this.value = value;
        this.DECORATION_PREFIX = "primitive: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.BYTE;
    }

    public ByteMessage() {
        this((byte) 0);
    }

    @Override
    public ByteMessage accumulate(Message message) {
        return new ByteMessage((byte) ((byte) message.getValue() + (byte) value));
    }

    @Override
    public ByteMessage getDefaultMessage() {
        return new ByteMessage();
    }

    @Override
    public boolean isAccumulatable (Message testMessage) {
        if (testMessage.getStatus() == status) {
            return (long) ((Byte) value).intValue() + (Byte) testMessage.getValue() <= Byte.MAX_VALUE;
        } else return false;
    }

}

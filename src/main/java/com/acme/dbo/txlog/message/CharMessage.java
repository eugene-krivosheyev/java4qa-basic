package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class CharMessage extends AbstractMessage implements Message {

    public CharMessage(char value) {
        this.value = value;
        this.DECORATION_PREFIX = "char: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.CHAR;
    }

    public CharMessage() {
        this((char) 0);
    }

    @Override
    public CharMessage accumulate(Message message) {
        return new CharMessage((char) ((char) value + (char) message.getValue()));
    }

    @Override
    public CharMessage getDefaultMessage() {
        return new CharMessage();
    }
}

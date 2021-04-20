package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.controller.AccumulatorState;

public class StringMessage extends AbstractMessage implements Message {

    private final int repeatCounter;

    public StringMessage(String value) {
        this(value, 1);
    }

    public StringMessage() {
        this("");
    }

    private StringMessage(String value, int repeateCounter) {
        this.value = value;
        this.repeatCounter = repeateCounter;
        this.DECORATION_PREFIX = "string: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.STRING;
    }

    @Override
    public StringMessage getDefaultMessage() {
        return new StringMessage();
    }

    public boolean isAccumulatable(Message message) {
        return this.value.equals(message.getValue());
    }

    public StringMessage accumulate(Message message) {
        if (value.equals(message.getValue())) {
            return new StringMessage(value.toString(), repeatCounter + 1);
        } else {
            return new StringMessage(message.getValue().toString(), 1);
        }
    }
    @Override
    public String toString() {
        if (repeatCounter > 1) {
            return DECORATION_PREFIX + value + " (x" + repeatCounter + ")" + DECORATION_POSTFIX;
        } else {
            return DECORATION_PREFIX + value + DECORATION_POSTFIX;
        }
    }
}

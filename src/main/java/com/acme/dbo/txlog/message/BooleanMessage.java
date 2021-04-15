package com.acme.dbo.txlog.message;

public class BooleanMessage extends AbstractMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final boolean body;

    public BooleanMessage(boolean body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public BooleanMessage accumulate(Message message) {
        return (BooleanMessage) message;
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + body + PRIMITIVE_POSTFIX;
    }
}

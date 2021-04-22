package com.acme.dbo.txlog.message;

public class BoolMessage implements DecoratingMessage {
    private boolean body;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String PRIMITIVE_POSTFIX = "";

    public boolean getBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }

    public BoolMessage(boolean body) {
        this.body = body;
    }

    public BoolMessage accumulate(BoolMessage message) {
        body = message.getBody() && body;
        return this;
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + body + PRIMITIVE_POSTFIX;
    }

    @Override
    public void flush() {
        body = false;
    }

    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return this.accumulate((BoolMessage) message);
    }
}


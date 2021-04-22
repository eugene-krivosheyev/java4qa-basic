package com.acme.dbo.txlog.message;

public class RefMessage implements DecoratingMessage {
    private Object body;
    private static final String REF_PREFIX = "reference: ";
    private static final String REF_POSTFIX = "";

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public RefMessage(Object body) {
        this.body = body;
    }

    public RefMessage accumulate(RefMessage message) {
        body = message.getBody();
        return this;
    }

    @Override
    public String getDecoratedMessage() {
        return REF_PREFIX + body + REF_POSTFIX;
    }

    @Override
    public void flush() {
        body = null;
    }

    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return this.accumulate((RefMessage) message);
    }
}

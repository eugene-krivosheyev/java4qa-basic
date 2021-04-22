package com.acme.dbo.txlog.message;

public class IntMessage implements DecoratingMessage {
    private int body;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String PRIMITIVE_POSTFIX = "";

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public IntMessage(int body) {
        this.body = body;
    }

    public IntMessage accumulate(IntMessage message){
        body = body + message.getBody();
        return this;
    }

    @Override
    public String getDecoratedMessage() {
            return PRIMITIVE_PREFIX + body + PRIMITIVE_POSTFIX;
    }
    @Override
    public void flush() {
        body = 0;
    }
    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return this.accumulate((IntMessage) message);
    }

}

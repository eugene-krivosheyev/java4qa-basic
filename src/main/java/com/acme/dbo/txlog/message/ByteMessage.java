package com.acme.dbo.txlog.message;

public class ByteMessage implements DecoratingMessage {
    private byte body;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String PRIMITIVE_POSTFIX = "";

    public byte getBody() {
        return body;
    }

    public void setBody(byte body) {
        this.body = body;
    }

    public ByteMessage(byte body) {
        this.body = body;
    }

    public ByteMessage accumulate(ByteMessage message){
        body = (byte) (body + message.getBody());
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
        return this.accumulate((ByteMessage) message);
    }

}

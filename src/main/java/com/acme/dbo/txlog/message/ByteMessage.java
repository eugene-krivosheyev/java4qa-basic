package com.acme.dbo.txlog.message;

public class ByteMessage extends AbstractMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final byte body;

    public ByteMessage(byte body) {
        this.body = body;
    }

    public byte getBody() {
        return body;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public ByteMessage accumulate(Message message) {
        if (!(message instanceof ByteMessage)) throw new IllegalArgumentException("Message");
        ByteMessage newMessage = (ByteMessage) message;
        if (this.body + newMessage.body > Byte.MAX_VALUE) {
            newMessage.messageSavedAfterAccumulation = this;
            return newMessage;
        } else {
            return new ByteMessage((byte) (this.getBody() + newMessage.getBody()));
        }
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + body + PRIMITIVE_POSTFIX;
    }
}

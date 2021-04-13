package com.acme.dbo.txlog.domain;

public class ByteMessage extends AbstractMessage {
    private byte body;

    {
        prefix = "primitive: ";
    }

    public ByteMessage(byte message) {
        body = message;
    }

    public String toString() {
        return getPrefix() + getBody().toString();
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new ByteMessage((byte) (body + ((ByteMessage) newMessage).getBody()));
    }

    public Byte getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) {
        if (!(newMessage instanceof ByteMessage)) {return true;}
        byte newBody = ((ByteMessage) newMessage).getBody();
        byte result = (byte) (body + newBody);
        if ((result > 0 & body < 0 & newBody < 0) || (result < 0 & body > 0 & newBody > 0)) {
            return true;
        } else {
            return false;
        }
    }
}

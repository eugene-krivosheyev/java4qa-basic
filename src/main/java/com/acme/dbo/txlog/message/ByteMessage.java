package com.acme.dbo.txlog.message;

public class ByteMessage {
    private byte body;

    public ByteMessage() {
        body = (byte) 0;
    }

    public ByteMessage(byte body) {
        this.body = body;
    }

    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

    public void accumulateState(final ByteMessage message) {
        int accumulateValue = body + message.getBody();
        if(accumulateValue >= Byte.MAX_VALUE) {
            accumulateValue = Byte.MAX_VALUE;
        }
        body = (byte) accumulateValue;
    }

    public void flush() {
        body = (byte) 0;
    }

    public byte getBody() {
        return this.body;
    }
}

package com.acme.dbo.txlog.message;

public class ByteMessage implements Message{
    private byte body;

    public ByteMessage(byte message) {
        this.body = message;
    }

    @Override
    public String getDecorateBody(){
        return "primitive: " + body;
    }
}

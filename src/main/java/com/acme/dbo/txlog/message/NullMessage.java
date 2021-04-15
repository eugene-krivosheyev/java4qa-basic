package com.acme.dbo.txlog.message;

public class NullMessage implements Message {
    private int body;

    public NullMessage() {
    }

    public Message accumulate (Message message){
        return null;
    }

    @Override
    public String getDecoratedBody() {
        return null;
    }
}

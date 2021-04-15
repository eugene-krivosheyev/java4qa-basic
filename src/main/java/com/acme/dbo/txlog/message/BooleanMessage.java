package com.acme.dbo.txlog.message;

public class BooleanMessage implements Message {
    private boolean body;


    public BooleanMessage(boolean body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody(){
        return "primitive: " + body;
    }
}

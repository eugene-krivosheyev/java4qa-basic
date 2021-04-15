package com.acme.dbo.txlog.message;

public class ObjectMessage implements Message {
    private Object body;

    public ObjectMessage(Object body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody(){
        return "reference: " + body;
    }
}

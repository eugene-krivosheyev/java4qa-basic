package com.acme.dbo.txlog.message;

public class ObjectMessage implements Message {
    private Object body;

    public ObjectMessage(Object message) {
        this.body = message;
    }

    @Override
    public String getDecorateBody() {
        return "reference: " + body;
    }
}

package com.acme.dbo.txlog.message;

public class BooleanMessage implements Message {
    private boolean body;

    public BooleanMessage(boolean message) {
        this.body = message;
    }

    @Override
    public String getDecorateBody() {
        return "primitive: " + body;
    }
}

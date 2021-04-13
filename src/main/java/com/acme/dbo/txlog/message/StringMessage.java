package com.acme.dbo.txlog.message;

public class StringMessage implements Message {
    private String body;

    public StringMessage(String message) {
        this.body = message;
    }

    @Override
    public String getDecorateBody() {
        return "string: " + body;
    }
}

package com.acme.dbo.txlog.message;

public class CharMessage implements Message {
    private char body;

    public CharMessage(char message) {
        this.body = message;

    }

    @Override
    public String getDecorateBody() {
        return "char: " + body;
    }
}

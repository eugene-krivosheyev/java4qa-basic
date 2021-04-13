package com.acme.dbo.txlog.message;

public class IntMessage implements Message{
    private int body;

    public IntMessage(int message) {
        this.body = message;
    }

    @Override
    public String getDecorateBody(){
        return "primitive: " + body;
    }
}

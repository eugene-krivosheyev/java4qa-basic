package com.acme.dbo.txlog.message;

public class CharMessage implements Message {
    private char body;

    public CharMessage(char body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody(){
        return "char: " + body;
    }

}

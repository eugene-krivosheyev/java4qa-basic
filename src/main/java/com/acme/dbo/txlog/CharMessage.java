package com.acme.dbo.txlog;

public class CharMessage implements Message{
    private static final String CHAR_PREFIX = "char: ";
    private char value;

    CharMessage(char value) {
        this.value = value;
    }

    @Override
    public String getDecoratedBody() {
        return CHAR_PREFIX + value;
    }
}

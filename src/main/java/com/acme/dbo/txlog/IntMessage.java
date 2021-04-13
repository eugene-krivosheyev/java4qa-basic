package com.acme.dbo.txlog;

public class IntMessage implements Message {
    private static final String INT_PREFIX = "primitive: ";
    private int value;

    IntMessage(int value) {
        this.value = value;
    }

    @Override
    public String getDecoratedBody() {
        return INT_PREFIX + value;
    }
}

package com.acme.dbo.txlog;

public class BooleanMessage implements Message {
    private static final String BOOLEAN_PREFIX = "boolean: ";
    private boolean value;

    BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public String getDecoratedBody() {
        return BOOLEAN_PREFIX + value;
    }
}

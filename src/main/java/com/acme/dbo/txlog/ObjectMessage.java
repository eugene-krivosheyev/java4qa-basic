package com.acme.dbo.txlog;

public class ObjectMessage implements Message {
    private static final String OBJ_PREFIX = "reference: ";
    private Object value;

    ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String getDecoratedBody() {
        return OBJ_PREFIX + value;
    }
}

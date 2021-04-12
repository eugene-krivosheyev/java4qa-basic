package com.acme.dbo.txlog;

public class ReferenceMessage implements Message {
    private Object value;
    public static String PREFIX = "reference: ";

    public ReferenceMessage(Object value) {
        this.value = value;
    }

    @Override
    public String getBody() {
        return value.toString();
    }

    @Override
    public String getDecoratedBody() {
        return PREFIX + value.toString();
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    @Override
    public boolean isAccumulable() {
        return false;
    }
}

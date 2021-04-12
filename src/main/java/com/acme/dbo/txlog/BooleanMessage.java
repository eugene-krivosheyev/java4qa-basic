package com.acme.dbo.txlog;

public class BooleanMessage implements Message {
    public static String PREFIX = "primitive: ";
    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public String getBody() {
        return Boolean.toString(value);
    }

    @Override
    public String getDecoratedBody() {
        return PREFIX + value;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message.getClass() == this.getClass();
    }

    @Override
    public boolean isAccumulable() {
        return false;
    }
}

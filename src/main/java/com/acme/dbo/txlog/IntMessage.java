package com.acme.dbo.txlog;

public class IntMessage implements Message {
    private int value;

    private static String PREFIX = "primitive: ";

    IntMessage(int value) {
        this.value = value;
    }

    @Override
    public String getBody() {
        return Integer.toString(this.value);
    }

    @Override
    public String getDecoratedBody() {
        return PREFIX + Integer.toString(this.value);
    }

    public Message accumulate(Message message) {
        if (message == null) {
            return this;
        }

        if (isOverflowed(message)) {
            return null;
        }

        return new IntMessage(Integer.parseInt(message.getBody()) + this.value);
    }

    @Override
    public boolean isAccumulable() {
        return true;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message.getClass() == this.getClass();
    }

    private boolean isOverflowed(Message message) {
        long left = ((long) Integer.parseInt(message.getBody()) + (long) this.value) - Integer.MAX_VALUE;
        return left > 0;
    }
}

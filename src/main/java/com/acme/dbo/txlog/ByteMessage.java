package com.acme.dbo.txlog;

public class ByteMessage implements Message {
    private byte value;
    public static String PREFIX = "primitive: ";

    ByteMessage(byte value) {
        this.value = value;
    }

    @Override
    public String getBody() {
        return Byte.toString(this.value);
    }

    @Override
    public String getDecoratedBody() {
        return PREFIX + Byte.toString(this.value);
    }

    public Message accumulate(Message message) {
        if (message == null) {
            return this;
        }

        if (isOverflowed(message)) {
            return null;
        }

        return new ByteMessage((byte) (Byte.parseByte(message.getBody()) +  this.value));
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
        long left = ((long) Byte.parseByte(message.getBody()) + (long) this.value) - Byte.MAX_VALUE;
        return left > 0;
    }
}

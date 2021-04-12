package com.acme.dbo.txlog;

public class CharMessage implements Message {
    private char value;
    public static String PREFIX = "char: ";

    public CharMessage(char value) {
        this.value = value;
    }

    @Override
    public String getBody() {
        return Character.toString(this.value);
    }

    @Override
    public String getDecoratedBody() {
        return PREFIX + Character.toString(this.value);
    }

    @Override
    public Message accumulate(Message message) {
        if (message == null) {
            return this;
        }
        return null;
    }

    @Override
    public boolean isAccumulable() {
        return false;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message.getClass() == this.getClass();
    }
}

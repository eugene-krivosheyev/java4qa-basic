package com.acme.dbo.txlog;

public class StringMessage implements Message {
    private String value;
    private int count;
    private static String PREFIX = "string: ";

    StringMessage(String value) {
        this(value, 1);
    }

    StringMessage(String value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public String getBody() {
        return this.value;
    }

    @Override
    public String getDecoratedBody() {
        String body = PREFIX + this.value;
        if (this.count > 1) {
            body += " (x" + this.count + ")";
        }

        return body;
    }

    public Message accumulate(Message message) {
       if (message == null) {
           return this;
       }

       if (this.getBody().equals(message.getBody())) {
           return new StringMessage(this.getBody(), this.count + 1);
       }

       return null;
    }

    @Override
    public boolean isAccumulable() {
        return true;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message.getClass() == this.getClass();
    }
}

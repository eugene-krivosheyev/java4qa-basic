package com.acme.dbo.txlog.message;

public class StringMessage implements Message {
    private String body;
    private static int repeatCounter = 1;


    public StringMessage(String body) {
        this.body = body;
    }


    @Override
    public String getDecoratedBody() {
        String decoratedBody;
        if (repeatCounter > 1) {
            decoratedBody = "string: " + body + " (x" + repeatCounter + ")";
            repeatCounter = 1;
        } else decoratedBody = "string: " + body;
        return decoratedBody;
    }

    @Override
    public boolean immediatelyFlushable() {
        return false;
    }

    @Override
    public boolean accumulatableWith(Message message) {
        if (this.body.equals(((StringMessage)message).body)) return true;
        else return false;
    }

    @Override
    public Message accumulate(Message message) {
        repeatCounter++;
        return message;
    }

    public String toString() {
        return this.body;
    }

}

package com.acme.dbo.txlog.message;

public class IntMessage{
    private int body;

    public IntMessage() {
        body = 0;
    }

    public IntMessage(int body) {
        this.body = body;
    }

    public String getDecoratedMessage() {
        return "primitive: " + body;
    }

    public void accumulateState (final IntMessage message) {
        long accumulatedValue = (long) body + (long) message.getBody();
        if(accumulatedValue >= Integer.MAX_VALUE) {
            accumulatedValue = Integer.MAX_VALUE;
        }
        body = (int) accumulatedValue;
    }

    public void flush() {
        body = 0;
    }

    public int getBody() {
        return body;
    }
}

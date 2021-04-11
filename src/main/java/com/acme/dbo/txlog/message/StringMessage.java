package com.acme.dbo.txlog.message;

public class StringMessage {
    private String body;
    private int bodySubsequentCount = 0;

    public StringMessage() {
        bodySubsequentCount = 0;
        body = "";
    }

    public StringMessage(String body) {
        this.body = body;
    }

    public String getDecoratedMessage() {
        if(bodySubsequentCount > 1) {
            body = body + " (x" + bodySubsequentCount + ")";
        }
        return "string: " + body;
    }

    public void accumulateState(final StringMessage message) {
        if(!body.equals(message.getBody())) {
            bodySubsequentCount = 1;
            body = message.getBody();
            return;
        }
        bodySubsequentCount++;
    }

    public void flush() {
        body = "";
        bodySubsequentCount = 0;
    }

    public String getBody() {
        return body;
    }

}

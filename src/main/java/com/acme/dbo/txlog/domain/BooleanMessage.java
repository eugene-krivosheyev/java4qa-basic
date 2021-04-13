package com.acme.dbo.txlog.domain;

public class BooleanMessage extends AbstractMessage {
    Boolean body;

    {
        prefix = "primitive: ";
    }

    public BooleanMessage(boolean message) {
        body = message;
    }

    public String toString(){
        return getPrefix() + getBody().toString();
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new BooleanMessage( ((BooleanMessage)newMessage).getBody());
    }

    public Boolean getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) { return true; }

}

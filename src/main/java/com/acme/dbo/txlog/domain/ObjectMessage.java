package com.acme.dbo.txlog.domain;

public class ObjectMessage extends AbstractMessage {
    Object body;

    {
        prefix = "reference: ";
    }

    public ObjectMessage(Object message) {
        body = message;
    }

    public String toString() {
        return getPrefix() + getBody().toString();
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new ObjectMessage(((ObjectMessage) newMessage).getBody());
    }

    public Object getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) { return true; }
}

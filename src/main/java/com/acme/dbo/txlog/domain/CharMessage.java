package com.acme.dbo.txlog.domain;

public class CharMessage extends AbstractMessage {
    char body;

    {
        prefix = "char: ";
    }

    public CharMessage(char message) {
        body = message;
    }

    public String toString() {
        return getPrefix() + getBody().toString();
    }

    @Override
    public Message accumulate(Message newMessage) {
        return new CharMessage(((CharMessage) newMessage).getBody());
    }

    public Character getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) { return true; }
}

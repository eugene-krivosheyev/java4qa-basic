package com.acme.dbo.txlog.domain;

public class IntMessage extends AbstractMessage {
    private int body;

    {
        prefix = "primitive: ";
    }

    public IntMessage(int message) {
        body = message;
    }

    public String toString() {
        return getPrefix() + getBody().toString();
    }

    public IntMessage accumulate(Message newMessage) {
        return new IntMessage(((IntMessage) newMessage).getBody() + body);
    }

    public Integer getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) {
        if (!(newMessage instanceof IntMessage)) {return true;}
        int newBody = ((IntMessage) newMessage).getBody();
        int result = body + newBody;
        return (result > 0 & body < 0 & newBody < 0) || (result < 0 & body > 0 & newBody > 0);
    }
}

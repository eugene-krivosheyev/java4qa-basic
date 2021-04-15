package com.acme.dbo.txlog.message;

public class ObjectMessage extends AbstractMessage implements Message {
    private final String OBJECT_PREFIX = "reference: ";
    private final String OBJECT_POSTFIX = "";

    private final Object body;

    public ObjectMessage(Object body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public ObjectMessage accumulate(Message message) {
        return (ObjectMessage) message;
    }

    @Override
    public String getDecoratedMessage() {
        return OBJECT_PREFIX + body + OBJECT_POSTFIX;
    }

}

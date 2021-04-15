package com.acme.dbo.txlog.message;

public class CharMessage extends AbstractMessage implements Message {
    private final String CHAR_PREFIX = "char: ";
    private final String CHAR_POSTFIX = "";

    private final char body;

    public CharMessage(char body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public CharMessage accumulate(Message message) {
        return (CharMessage) message;
    }

    @Override
    public String getDecoratedMessage() {
        return CHAR_PREFIX + body + CHAR_POSTFIX;
    }
}

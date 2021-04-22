package com.acme.dbo.txlog.message;

public class CharMessage implements DecoratingMessage {
    private char body;
    private static final String CHAR_PREFIX = "char: ";
    private static final String CHAR_POSTFIX = "";

    // Java Beans standard -> POJO
    public char getBody() {
        return body;
    }

    public void setBody(char body) {
        this.body = body;
    }

    public CharMessage(char body) {
        this.body = body;
    }

    @Override
    public String getDecoratedMessage() {
        return CHAR_PREFIX + body + CHAR_POSTFIX;
    }
    @Override
    public void flush() {
        body = 0;
    }
    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        body = ((CharMessage) message).getBody();
        return this;
    }

}

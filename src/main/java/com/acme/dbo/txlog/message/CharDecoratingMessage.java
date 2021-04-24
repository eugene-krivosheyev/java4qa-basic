package com.acme.dbo.txlog.message;

public class CharDecoratingMessage extends AbstractDecoratingMessage<Character> {
    private static final String PREFIX = "char: ";

    public CharDecoratingMessage(final Character body) {
        this.body = body;
        this.prefix = PREFIX;
    }
}

package com.acme.dbo.txlog.message;

public class BooleanDecoratingMessage extends AbstractDecoratingMessage<Boolean> {
    private static final String PREFIX = "primitive: ";

    public BooleanDecoratingMessage(final Boolean body) {
        this.body = body;
        this.prefix = PREFIX;
    }
}

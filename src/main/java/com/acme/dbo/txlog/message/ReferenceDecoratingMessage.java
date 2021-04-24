package com.acme.dbo.txlog.message;

public class ReferenceDecoratingMessage extends AbstractDecoratingMessage<Object> {
    private static final String PREFIX = "reference: ";

    public ReferenceDecoratingMessage(final Object body) {
        this.body = body;
        this.prefix = PREFIX;
    }
}

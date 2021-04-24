package com.acme.dbo.txlog.message.accumulating;

import com.acme.dbo.txlog.message.AbstractDecoratingMessage;
import com.acme.dbo.txlog.message.DecoratingMessage;

public class IntDecoratingMessage extends AbstractDecoratingMessage<Long> {
    private static final String PREFIX = "primitive: ";
    private final int overflowMaxValue;

    public IntDecoratingMessage(final long body) {
        this.body = body;
        this.overflowMaxValue = Integer.MAX_VALUE;
        this.prefix = PREFIX;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof IntDecoratingMessage)) {
            return message;
        }
        final IntDecoratingMessage addingMessage = (IntDecoratingMessage) message;
        if (this.body + addingMessage.body > this.overflowMaxValue) {
            return message;
        }
        return new IntDecoratingMessage(this.body + addingMessage.body);
    }
}

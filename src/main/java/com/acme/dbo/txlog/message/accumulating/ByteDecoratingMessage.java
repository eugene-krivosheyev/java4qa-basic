package com.acme.dbo.txlog.message.accumulating;

import com.acme.dbo.txlog.message.AbstractDecoratingMessage;
import com.acme.dbo.txlog.message.DecoratingMessage;

public class ByteDecoratingMessage extends AbstractDecoratingMessage<Integer> {
    private static final String PREFIX = "primitive: ";
    private final int overflowMaxValue;

    public ByteDecoratingMessage(final int body) {
        this.body = body;
        this.overflowMaxValue = Byte.MAX_VALUE;
        this.prefix = PREFIX;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof ByteDecoratingMessage)) {
            return message;
        }
        final ByteDecoratingMessage addingMessage = (ByteDecoratingMessage) message;
        if (this.body + addingMessage.body > this.overflowMaxValue) {
            return message;
        }
        return new ByteDecoratingMessage(this.body + addingMessage.body);
    }
}

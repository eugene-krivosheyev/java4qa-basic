package com.acme.dbo.txlog.message.accumulating;

import com.acme.dbo.txlog.message.AbstractDecoratingMessage;
import com.acme.dbo.txlog.message.DecoratingMessage;

public class StringDecoratingMessage extends AbstractDecoratingMessage<String> {
    private static final String PREFIX = "string: ";
    private final int repeated;

    public StringDecoratingMessage(final String body) {
        this.body = body;
        this.repeated = 1;
        this.prefix = PREFIX;
    }

    public StringDecoratingMessage(final String body, final int repeated) {
        this.body = body;
        this.repeated = repeated;
    }

    @Override
    public String getDecoratedMessage() {
        if (this.repeated > 1) {
            return String.format("string: %s (x%d)", this.body, this.repeated);
        }
        return this.prefix + this.body;
    }

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        if (!(message instanceof StringDecoratingMessage)) {
            return message;
        }
        final StringDecoratingMessage addingMessage = (StringDecoratingMessage) message;
        if (this.body != null && this.body.equals(addingMessage.body)) {
            return new StringDecoratingMessage(this.body, this.repeated + 1);
        }
        return addingMessage;
    }
}

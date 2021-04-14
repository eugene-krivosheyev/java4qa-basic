package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.MessageConstants.PRIMITIVE_PREFIX;

public class BooleanMessage implements Message {
    private final boolean message;

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + message;
    }
}

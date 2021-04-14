package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.MessageConstants.PRIMITIVE_PREFIX;

public class IntMessage implements Message {
    private int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public boolean accumulate(Message message) {
        final long accumulatedSum = (long) this.body + ((IntMessage) message).body;
        if (accumulatedSum >= Integer.MAX_VALUE) {
            return false;
        } else {
            this.body = (int) accumulatedSum;
            return true;
        }
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + body;
    }
}

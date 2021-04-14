package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.message.MessageConstants.PRIMITIVE_PREFIX;

public class ByteMessage implements Message {
    private byte body;

    public ByteMessage(byte body) {
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
        final int accumulatedSum = (int) this.body + ((ByteMessage) message).body;
        if (accumulatedSum >= Byte.MAX_VALUE) {
            return false;
        } else {
            this.body = (byte) accumulatedSum;
            return true;
        }
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + body;
    }
}

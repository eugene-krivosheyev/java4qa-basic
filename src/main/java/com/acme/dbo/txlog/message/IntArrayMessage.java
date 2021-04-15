package com.acme.dbo.txlog.message;

import static java.lang.System.lineSeparator;

public class IntArrayMessage extends AbstractMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final int[] body;

    public IntArrayMessage(int[] body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return false;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        StringBuilder result = new StringBuilder();
        for (int value : body) {
            result
                    .append(PRIMITIVE_PREFIX)
                    .append(value)
                    .append(PRIMITIVE_POSTFIX)
                    .append(lineSeparator());
        }
        return result.toString();
    }
}

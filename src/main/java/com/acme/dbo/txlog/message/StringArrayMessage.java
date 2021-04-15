package com.acme.dbo.txlog.message;

import static java.lang.System.lineSeparator;

public class StringArrayMessage extends AbstractMessage implements Message{
    private final String STRING_PREFIX = "string: ";
    private final String STRING_POSTFIX = "";

    private final String[] body;

    public StringArrayMessage(String[] body) {
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
        for (String value : body) {
            result
                    .append(STRING_PREFIX)
                    .append(value)
                    .append(STRING_POSTFIX)
                    .append(lineSeparator());
        }
        return result.toString();
    }
}

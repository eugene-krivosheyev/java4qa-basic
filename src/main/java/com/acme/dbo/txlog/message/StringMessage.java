package com.acme.dbo.txlog.message;

import java.util.Objects;

public class StringMessage implements Message {
    private final String body;
    private int bodyCount = 1;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StringMessage that = (StringMessage) o;
        return Objects.equals(body, that.body);
    }

    @Override
    public boolean accumulate(Message message) {
        bodyCount++;
        return true;
    }

    @Override
    public String getDecoratedMessage() {
        return "string: " + body + (bodyCount > 1 ? String.format(" (x%s)", bodyCount) : "");
    }
}

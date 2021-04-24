package com.acme.dbo.txlog.message;

import java.util.function.Function;

public abstract class AbstractDecoratingMessage<T> implements DecoratingMessage {
    protected String prefix;
    protected T body;
    protected Function<T, String> decoratingFunction;

    @Override
    public DecoratingMessage accumulate(final DecoratingMessage message) {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        if (decoratingFunction != null) {
            return prefix + decoratingFunction.apply(this.body);
        }
        return prefix + body;
    }
}

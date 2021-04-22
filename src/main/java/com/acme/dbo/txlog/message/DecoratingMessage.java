package com.acme.dbo.txlog.message;

public interface DecoratingMessage {
    String getDecoratedMessage();
    void flush();
    DecoratingMessage accumulate(DecoratingMessage message);
}

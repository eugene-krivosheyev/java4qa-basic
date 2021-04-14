package com.acme.dbo.txlog.message;

public interface Message {
    boolean accumulate(Message message);

    String getDecoratedMessage();
}

package com.acme.dbo.txlog.message;

public interface Message {
    boolean equalType(Message message);
    Message accumulate(Message message);
    String getDecoratedMessage();
    Message getMessageIfCurrentMessageFlushedAfterAccumulation();
}

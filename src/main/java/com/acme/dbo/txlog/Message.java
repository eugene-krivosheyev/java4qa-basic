package com.acme.dbo.txlog;

public interface Message {
    public String getBody();

    public String getDecoratedBody();

    public Message accumulate(Message message);

    public boolean isSameTypeOf(Message message);

    public boolean isAccumulable();
}


package com.acme.dbo.txlog.domain;

public interface Message {

    Message accumulate(Message newMessage);

    String getPrefix();

    boolean shouldFlush(Message newMessage);
}

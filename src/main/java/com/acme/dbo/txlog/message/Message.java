package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public interface Message {

    Object getValue();

    Message accumulate(Message message);

    @Override
    String toString();

    Message getDefaultMessage();

    AccumulatorState getStatus();

    boolean isAccumulatable(Message message);
}

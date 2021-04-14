package com.acme.dbo.txlog.filter;

import com.acme.dbo.txlog.message.Message;

public interface MessageFilter {
    boolean filter(Message message, SeverityLevel logLevel);
}

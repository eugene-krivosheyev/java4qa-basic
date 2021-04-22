package com.acme.dbo.txlog.filter;

import com.acme.dbo.txlog.SeverityLevel;
import com.acme.dbo.txlog.message.DecoratingMessage;

public interface MessageFilter {
    boolean filter(DecoratingMessage message, SeverityLevel severity);
}

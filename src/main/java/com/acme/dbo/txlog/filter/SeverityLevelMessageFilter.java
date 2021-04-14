package com.acme.dbo.txlog.filter;

import com.acme.dbo.txlog.message.Message;

public class SeverityLevelMessageFilter implements MessageFilter {
    private final SeverityLevel level;

    public SeverityLevelMessageFilter(SeverityLevel level) {
        this.level = level;
    }

    @Override
    public boolean filter(Message message, SeverityLevel logLevel) {
        return logLevel.compareTo(level) < 0;
    }
}

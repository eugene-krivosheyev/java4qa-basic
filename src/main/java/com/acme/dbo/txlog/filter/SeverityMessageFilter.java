package com.acme.dbo.txlog.filter;

import com.acme.dbo.txlog.SeverityLevel;
import com.acme.dbo.txlog.message.DecoratingMessage;

public class SeverityMessageFilter implements MessageFilter {
    private final SeverityLevel threshold;

    public SeverityMessageFilter(SeverityLevel threshold){
        this.threshold = threshold;
    };

    @Override
    public boolean filter(DecoratingMessage message, SeverityLevel severity) {

        return severity.compareTo(threshold) < 0;
    }

}

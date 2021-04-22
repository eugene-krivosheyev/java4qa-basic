package ooaddemo.filter;

import ooaddemo.SeverityLevel;
import ooaddemo.message.DecoratingMessage;

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

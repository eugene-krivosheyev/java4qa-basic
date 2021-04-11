package ooaddemo.filter;

import ooaddemo.message.DecoratingMessage;
import ooaddemo.domain.SeverityLevel;

public interface MessageFilter {
    boolean filter(DecoratingMessage message, SeverityLevel severity);
}

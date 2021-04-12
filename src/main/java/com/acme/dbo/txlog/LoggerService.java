package com.acme.dbo.txlog;

public class LoggerService {
    private Message messageAccumulator = null;

    private Logger logger;

    LoggerService(Logger logger) {
        this.logger = logger;
    }

    public void log(Message message) {
        if (messageAccumulator != null && !message.isSameTypeOf(messageAccumulator)) {
            close();
        }

        if (!message.isAccumulable()) {
            logger.log(message);
            return;
        }

        if (messageAccumulator == null || !message.isSameTypeOf(messageAccumulator)) {
            messageAccumulator = message;
            return;
        }

        Message accumulated = messageAccumulator.accumulate(message);

        if (accumulated == null) {
            logger.log(messageAccumulator);
            messageAccumulator = message;
            return;
        }

        messageAccumulator = accumulated;
    }

    public void close() {
        if (messageAccumulator == null) {
            return;
        }

        logger.log(messageAccumulator);

        messageAccumulator = null;
    }
}

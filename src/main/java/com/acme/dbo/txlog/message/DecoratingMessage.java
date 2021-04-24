package com.acme.dbo.txlog.message;

public interface DecoratingMessage {
    String getDecoratedMessage();

    /**
     * Method for messages accumulation
     * @param message a message to be accumulated
     * @return an accumulated message or the passed <b>message</b> if nothing to accumulate
     */
    DecoratingMessage accumulate(final DecoratingMessage message);
}

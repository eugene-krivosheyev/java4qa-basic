package com.acme.dbo.txlog.message;

abstract class AbstractMessage {
    protected Message messageSavedAfterAccumulation = null;

    public Message getMessageIfCurrentMessageFlushedAfterAccumulation() {
        return messageSavedAfterAccumulation;
    }
}

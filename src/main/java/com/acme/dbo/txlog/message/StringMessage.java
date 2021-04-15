package com.acme.dbo.txlog.message;

public class StringMessage extends AbstractMessage implements Message {
    private final String STRING_PREFIX = "string: ";
    private final String STRING_POSTFIX = "";

    private int stringCounter = 1;
    private final String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public StringMessage accumulate(Message message) {
        if (!(message instanceof StringMessage)) throw new IllegalArgumentException("Message");
        StringMessage newMessage = (StringMessage) message;
        if (this.messageEquals(newMessage)) {
            this.incrementCounter();
            return this;
        } else {
            newMessage.messageSavedAfterAccumulation = this;
            return newMessage;
        }
    }

    @Override
    public String getDecoratedMessage() {
        return STRING_PREFIX + getStringDependingOnCounter() + STRING_POSTFIX;
    }

    private boolean messageEquals(StringMessage stringMessage) {
        return this.body.equals(stringMessage.body);
    }

    private String getStringDependingOnCounter() {
        if (stringCounter == 1) {
            return body;
        } else {
            return body + " (x" + stringCounter + ")";
        }
    }

    private void incrementCounter() {
        stringCounter++;
    }
}

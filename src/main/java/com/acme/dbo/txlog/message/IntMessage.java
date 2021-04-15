package com.acme.dbo.txlog.message;

public class IntMessage extends AbstractMessage implements Message {
    private final String PRIMITIVE_PREFIX = "primitive: ";
    private final String PRIMITIVE_POSTFIX = "";

    private final int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public IntMessage accumulate(Message intMessage) {
        if (!(intMessage instanceof IntMessage)) throw new IllegalArgumentException("Message");
        IntMessage newMessage = (IntMessage) intMessage;
        if ((long) this.body + newMessage.body > Integer.MAX_VALUE) {
            newMessage.messageSavedAfterAccumulation = this;
            return newMessage;
        } else {
            return new IntMessage(this.body + newMessage.body);
        }

    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE_PREFIX + body + PRIMITIVE_POSTFIX;
    }

    @Override
    public Message getMessageIfCurrentMessageFlushedAfterAccumulation() {
        return messageSavedAfterAccumulation;
    }

    public int getBody() {
        return body;
    }
}

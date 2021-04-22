package com.acme.dbo.txlog.message;

import static com.acme.dbo.txlog.SeverityLevel.INFO;

public class IntArrayMessage implements DecoratingMessage{
    private int[] body;

    private static final String ARRAY_PREFIX = "primitives array: {";
    private static final String ARRAY_POSTFIX = "}";

    public int[] getBody() {
        return body;
    }

    public void setBody(int[] body) {
        this.body = body;
    }

    public IntArrayMessage(int[] body) {
        this.body = body;
    }

    public IntArrayMessage accumulate(IntArrayMessage message){
        body = message.getBody();
        return this;
    }

    @Override
    public String getDecoratedMessage() {
        String stringAccum = ARRAY_PREFIX;
        for (int i = 0; i < body.length; i++) {
            stringAccum = stringAccum + body[i];
            if (i < body.length-1) stringAccum = stringAccum + ", ";
        }
        return stringAccum + ARRAY_POSTFIX;
    }
    @Override
    public void flush() {
        body = null;
    }
    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return this.accumulate((IntArrayMessage) message);
    }

}

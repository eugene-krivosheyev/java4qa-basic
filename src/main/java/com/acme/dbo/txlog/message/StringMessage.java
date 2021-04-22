package com.acme.dbo.txlog.message;

public class StringMessage implements DecoratingMessage {
    private String body;
    private int repCount = 1;
    private static final String STRING_PREFIX = "string: ";
    private static final String STRING_POSTFIX = "";

    // Java Beans standard -> POJO
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public StringMessage(String body) {
        this.body = body;
    }

    public StringMessage accumulate(StringMessage message){
        if (body != null){
            if (body.contains(message.getBody())) {// repetition found
                repCount++;
            } else {
                body = body + message.getBody();
            }
        } else {
            body = message.getBody();
        }
        return this;
    }

    @Override
    public String getDecoratedMessage() {
        if (repCount > 1)
            return STRING_PREFIX + body + " (x"+ repCount +")" + STRING_POSTFIX;
        else{
            return STRING_PREFIX + body + STRING_POSTFIX;

        }
    }
    @Override
    public void flush() {
        body = "";
        repCount = 1;
    }
    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return this.accumulate((StringMessage) message);
    }
}

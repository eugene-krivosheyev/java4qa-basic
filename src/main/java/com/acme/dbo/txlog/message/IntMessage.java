package com.acme.dbo.txlog.message;

public class IntMessage implements Message {
    private int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody() {
        return "primitive: " + body;
    }

    @Override
    public boolean immediatelyFlushable(){
        return false;
    }

    @Override
    public boolean accumulatableWith (Message message){
        if ((this.body > 0 && ((IntMessage)message).body > Integer.MAX_VALUE - this.body) || (this.body < 0 && ((IntMessage)message).body < Integer.MIN_VALUE - this.body)){
            return false;
        }
        else return true;
    }


    @Override
    public Message accumulate(Message message) {
        return new IntMessage(this.body + ((IntMessage)message).body);
    }


}

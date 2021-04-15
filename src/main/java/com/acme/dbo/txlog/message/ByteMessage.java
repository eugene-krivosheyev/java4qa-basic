package com.acme.dbo.txlog.message;

public class ByteMessage implements Message {
    private int body;

    public ByteMessage(byte body) {
        this.body = body;
    }
    public ByteMessage(int body) {
        this.body = body;
    }   //TODO

    @Override
    public String getDecoratedBody(){
        return "primitive: " + body;
    }


    @Override
    public boolean immediatelyFlushable(){
        return false;
    }

    @Override
    public boolean accumulatableWith (Message message){
        if ((this.body > 0 && ((ByteMessage)message).body > Byte.MAX_VALUE - this.body) || (this.body < 0 && ((ByteMessage)message).body < Byte.MIN_VALUE - this.body)){
            return false;
        }
        else return true;
    }

    @Override
    public Message accumulate (Message message){
        return new ByteMessage(this.body + Byte.parseByte(message.toString()));
    }


}

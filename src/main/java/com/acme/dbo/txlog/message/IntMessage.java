package com.acme.dbo.txlog.message;

public class IntMessage extends MessageBase {

    private int value;

    public IntMessage(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}

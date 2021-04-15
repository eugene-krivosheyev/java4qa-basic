package com.acme.dbo.txlog.message;

public interface Message {
    String getDecoratedBody();

    default boolean immediatelyFlushable(){
        return true;
    };

    default boolean accumulatableWith (Message message){
        return false;
    }

    default Message accumulate(Message message) {
        return message;
    }

}

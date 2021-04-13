package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.utils.ArrayUtils;

public class ArrayMessage extends AbstractMessage {

    private int[] body;

    {
        prefix = "primitives array: ";
    }

    public ArrayMessage(int[] message) {
        body = message;
    }

    @Override
    public ArrayMessage accumulate(Message newMessage) {
        return new ArrayMessage(((ArrayMessage)newMessage).getBody());
    }

    public int[] getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) { return true; }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(prefix);
        builder.append(ArrayUtils.intArrayToString(body));
        return builder.toString();
    }

}

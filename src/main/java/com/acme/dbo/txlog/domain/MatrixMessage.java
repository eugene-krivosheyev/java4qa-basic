package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.utils.ArrayUtils;

public class MatrixMessage extends AbstractMessage {

    private int[][] body;

    {
        prefix = "primitives matrix: ";
    }

    public MatrixMessage(int[][] message) {
        body = message;
    }

    @Override
    public MatrixMessage accumulate(Message newMessage) {
        return new MatrixMessage(((MatrixMessage)newMessage).getBody());
    }

    public int[][] getBody() {
        return body;
    }

    @Override
    public boolean shouldFlush(Message newMessage) { return true; }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(prefix + "{" + System.lineSeparator());
        for (int i = 0; i < body.length; i++) {
            builder.append(ArrayUtils.intArrayToString(body[i]));
            builder.append(System.lineSeparator());
        }
        builder.append("}");
        return builder.toString();

    }

}
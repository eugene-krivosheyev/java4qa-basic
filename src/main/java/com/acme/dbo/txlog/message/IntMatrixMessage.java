package com.acme.dbo.txlog.message;

public class IntMatrixMessage implements DecoratingMessage{
    private int[][] body;

    private static final String MATRIX_PREFIX = "primitives matrix: {" + System.lineSeparator();
    private static final String MATRIX_POSTFIX = "}";

    public int[][] getBody() {
        return body;
    }

    public void setBody(int[][] body) {
        this.body = body;
    }

    public IntMatrixMessage(int[][] body) {
        this.body = body;
    }

    public IntMatrixMessage accumulate(IntMatrixMessage message){
        body = message.getBody();
        return this;
    }

    @Override
    public String getDecoratedMessage() {
        String stringAccum = MATRIX_PREFIX;
        for (int i = 0; i < body.length; i++) {
            stringAccum = stringAccum + "{";
            for (int j = 0; j < body[i].length; j++){
                stringAccum = stringAccum + body[i][j];
                if (j < body[i].length-1) stringAccum = stringAccum + ", ";
            }
            stringAccum = stringAccum + "}" + System.lineSeparator();
        }
        return stringAccum + MATRIX_POSTFIX;
    }

    @Override
    public void flush() {
        body = null;
    }
    @Override
    public DecoratingMessage accumulate(DecoratingMessage message) {
        return this.accumulate((IntMatrixMessage) message);
    }

}

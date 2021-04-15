package com.acme.dbo.txlog.message;

public class IntMatrixMessage extends AbstractMessage implements Message {
    private final String MATRIX_PREFIX = "primitives matrix: ";
    private final String MATRIX_POSTFIX = "";

    private final int[][] body;

    public IntMatrixMessage(int[][] body) {
        this.body = body;
    }

    @Override
    public boolean equalType(Message message) {
        return false;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return MATRIX_PREFIX + matrixToString() + MATRIX_POSTFIX;
    }

    private String matrixToString() {
        StringBuilder result = new StringBuilder("{" + System.lineSeparator());
        for (int[] array : this.body) {
            result.append("{");
            for (int i = 0; i < array.length; i++) {
                result.append(array[i]);
                if (i<array.length-1){
                    result.append(", ");
                }
            }
            result.append("}"+ System.lineSeparator());
        }
        result.append("}");

        return result.toString();
    }
}

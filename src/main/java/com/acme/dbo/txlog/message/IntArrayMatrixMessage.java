package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class IntArrayMatrixMessage extends AbstractMessage implements Message {

    private static final String MATRIX_PREFIX = "{" + System.lineSeparator();
    private static final String MATRIX_POSTFIX = "}";


    public IntArrayMatrixMessage(int[][] value) {
        this.value = value;
        this.DECORATION_PREFIX = "primitives matrix: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.INT_MATRIX;
    }

    public IntArrayMatrixMessage() {
        this(new int[][] {{0}});
    }

    @Override
    public IntArrayMatrixMessage accumulate(Message message) {
        return new IntArrayMatrixMessage((int[][]) message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + matrixToString((int[][]) value) + DECORATION_POSTFIX;
    }

    @Override
    public IntArrayMatrixMessage getDefaultMessage() {
        return new IntArrayMatrixMessage();
    }

    private String matrixToString(int[][] matrix) {
        StringBuilder buffer = new StringBuilder(MATRIX_PREFIX);
        for (int[] array: matrix) {
            IntArrayMessage temp = new IntArrayMessage(array);
            buffer.append(temp.toString(false)).append(System.lineSeparator());
        }
        return buffer.append(MATRIX_POSTFIX).toString();
    }

}

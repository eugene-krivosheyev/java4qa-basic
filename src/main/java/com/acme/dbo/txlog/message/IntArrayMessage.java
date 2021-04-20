package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.controller.AccumulatorState;

public class IntArrayMessage extends AbstractMessage implements Message{

    private static final String ARRAY_PREFIX = "{";
    private static final String ARRAY_DEVIDER = ", ";
    private static final String ARRAY_POSTFIX = "}";


    public IntArrayMessage(int[] value) {
        this.value = value;
        this.DECORATION_PREFIX = "primitives array: ";
        this.DECORATION_POSTFIX = "";
        this.status = AccumulatorState.INT_ARRAY;
    }

    public IntArrayMessage() {
        this(new int[] {0});
    }

    @Override
    public IntArrayMessage accumulate(Message message) {
        return new IntArrayMessage((int[]) message.getValue());
    }

    @Override
    public String toString() {
        return DECORATION_PREFIX + arrayToString((int[]) value) + DECORATION_POSTFIX;
    }

    @Override
    public IntArrayMessage getDefaultMessage() {
        return new IntArrayMessage();
    }

    public String toString(boolean decorate) {
        if (decorate) {
            return toString();
        } else {
            return arrayToString((int[]) value);
        }
    }

    private String arrayToString(int[] intArray) {
        StringBuilder buffer = new StringBuilder(ARRAY_PREFIX);
        for (int element: intArray) {
            if (!buffer.toString().equals(ARRAY_PREFIX)) {
                buffer.append(ARRAY_DEVIDER).append(element);
            } else {
                buffer.append(element);
            }
        }
        return buffer.append(ARRAY_POSTFIX).toString();
    }
}

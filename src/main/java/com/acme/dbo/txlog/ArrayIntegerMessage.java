package com.acme.dbo.txlog;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayIntegerMessage implements Message {
    private static String LEFT_BRACKET = "{";
    private static String RIGHT_BRACKET = "}";
    private static String ARRAY_DIVIDER = ",";
    private static String SPACE = " ";
    private static String PREFIX = "primitives array: ";

    private int[] value;

    ArrayIntegerMessage(int[] value) {
        this.value = value;
    }

    @Override
    public String getBody() {
        return this.value.toString();
    }

    @Override
    public String getDecoratedBody() {
        return PREFIX + this.decorate(this.value);
    }

    private String decorate(int[] array) {
        return LEFT_BRACKET + Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(ARRAY_DIVIDER + SPACE)) + RIGHT_BRACKET;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isAccumulable() {
        return false;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message.getClass() == this.getClass();
    }
}

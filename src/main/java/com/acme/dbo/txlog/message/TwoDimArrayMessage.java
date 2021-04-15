package com.acme.dbo.txlog.message;

public class TwoDimArrayMessage implements Message {
    private int[][] body;

    public TwoDimArrayMessage(int[][] body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody() {
        ArrayDecorator arrayDecorator = new ArrayDecorator();
        return "primitives matrix: " + arrayDecorator.decorate(this.body);
    }
}

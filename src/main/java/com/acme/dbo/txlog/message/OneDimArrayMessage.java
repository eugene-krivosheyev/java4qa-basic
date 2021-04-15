package com.acme.dbo.txlog.message;

public class OneDimArrayMessage implements Message {
    private int[] body;

    public OneDimArrayMessage(int[] body) {
        this.body = body;
    }

    @Override
    public String getDecoratedBody() {
        ArrayDecorator arrayDecorator = new ArrayDecorator();
        return "primitives array: " + arrayDecorator.decorate(this.body);
    }
}

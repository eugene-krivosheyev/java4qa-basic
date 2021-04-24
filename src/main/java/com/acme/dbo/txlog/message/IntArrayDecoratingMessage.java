package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.message.utils.DecoratingUtils;

public class IntArrayDecoratingMessage extends AbstractDecoratingMessage<int[]> {
    private static final String PREFIX = "primitives array: ";

    public IntArrayDecoratingMessage(final int[] body) {
        this.body = body;
        this.prefix = PREFIX;
        this.decoratingFunction = DecoratingUtils::arrayToString;
    }
}

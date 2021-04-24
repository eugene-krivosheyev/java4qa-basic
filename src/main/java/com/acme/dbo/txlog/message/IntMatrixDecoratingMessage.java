package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.message.utils.DecoratingUtils;

public class IntMatrixDecoratingMessage extends AbstractDecoratingMessage<int[][]> {
    private static final String PREFIX = "primitives matrix: ";

    public IntMatrixDecoratingMessage(final int[][] body) {
        this.body = body;
        this.prefix = PREFIX;
        this.decoratingFunction = DecoratingUtils::matrixToString;
    }
}

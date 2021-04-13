package com.acme.dbo.txlog;

public class ByteMessage implements Message {
        private static final String BYTE_PREFIX = "primitive: ";
        private byte value;

        ByteMessage(byte value) {
            this.value = value;
        }

        @Override
        public String getDecoratedBody() {
            return BYTE_PREFIX + value;
        }
}

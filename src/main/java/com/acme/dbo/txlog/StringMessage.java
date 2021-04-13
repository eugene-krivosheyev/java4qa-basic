package com.acme.dbo.txlog;

public class StringMessage implements Message {
        private static final String STR_PREFIX = "string: ";
        private String value;

        StringMessage(String value) {
            this.value = value;
        }

        @Override
        public String getDecoratedBody() {
            return STR_PREFIX + value;
        }
    }


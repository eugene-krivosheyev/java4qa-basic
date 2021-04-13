package com.acme.dbo.txlog.domain;

abstract class AbstractMessage implements Message{
    String prefix;

    @Override
    public String getPrefix() {
        return prefix;
    }
}

package com.acme.dbo.txlog;

public interface Command {
    Boolean isSame(Command command);
    Command updateState(Command command);
    String decorate (Command command);
}

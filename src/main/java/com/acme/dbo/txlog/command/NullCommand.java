package com.acme.dbo.txlog.command;

import com.acme.dbo.txlog.Controller;

public class NullCommand extends BaseCommand {
    public NullCommand(String anyMessage) {
    }

    @Override
    public String getDecoratedState(int duplicationNum) {
        return null;
    }

    @Override
    public Command accumulate(Controller controller, Command command) {
        return this;
    }

    @Override
    public String getCurrentValue() {
        return "";
    }

    @Override
    public void flush() {

    }
}

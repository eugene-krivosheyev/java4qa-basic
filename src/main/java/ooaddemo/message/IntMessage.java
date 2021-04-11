package ooaddemo.message;

import com.acme.dbo.txlog.Facade;

public class IntMessage implements DecoratingMessage {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }


    @Override
    public String getDecoratedMessage() {
        return Facade.PRIMITIVE_PREFIX + message;
    }
}

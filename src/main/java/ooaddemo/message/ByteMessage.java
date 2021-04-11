package ooaddemo.message;

import com.acme.dbo.txlog.Facade;

public class ByteMessage implements DecoratingMessage {

    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public String getDecoratedMessage() {
        return Facade.PRIMITIVE_PREFIX + message;
    }
}

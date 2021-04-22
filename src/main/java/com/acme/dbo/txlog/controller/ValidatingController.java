package com.acme.dbo.txlog.controller;

import com.acme.dbo.txlog.SeverityLevel;
import com.acme.dbo.txlog.message.DecoratingMessage;

public class ValidatingController {

    public void log(DecoratingMessage message, SeverityLevel severity){
        if (message == null) throw new IllegalArgumentException("null on input!");
    }

}

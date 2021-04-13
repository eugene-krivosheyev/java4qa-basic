package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.LoggerFacade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() {
        String separator = System.lineSeparator();
        //region when
        LoggerFacade.log(1);
        LoggerFacade.flush();
        LoggerFacade.log(0);
        LoggerFacade.flush();
        LoggerFacade.log(-1);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + separator + "primitive: 0" + separator + "primitive: -1" + separator);
        //endregion
    }

    @Test
    public void shouldLogByte() {
        //region when
        LoggerFacade.log((byte)1);
        LoggerFacade.flush();
        LoggerFacade.log((byte)0);
        LoggerFacade.flush();
        LoggerFacade.log((byte)-1);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogChar() {
        //region when
        LoggerFacade.log('a');
        LoggerFacade.flush();
        LoggerFacade.log('b');
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() {
        //region when
        LoggerFacade.log("test string 1");
        LoggerFacade.log("other str");
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() {
        //region when
        LoggerFacade.log(true);
        LoggerFacade.flush();
        LoggerFacade.log(false);
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() {
        //region when
        LoggerFacade.log(new Object());
        LoggerFacade.flush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

}
package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.acme.dbo.txlog.facade.Facade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest01 implements SysoutCaptureAndAssertionAbility {
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
        //region when
        Facade.log(1);
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        Facade.log(-1);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogByte() {
        //region when
        Facade.log((byte) 1);
        Facade.flush();
        Facade.log((byte) 0);
        Facade.flush();
        Facade.log((byte) -1);
        Facade.flush();
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
        Facade.log('a');
        Facade.flush();
        Facade.log('b');
        Facade.flush();
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
        Facade.log("test string 1");
        Facade.flush();
        Facade.log("other str");
        Facade.flush();
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
        Facade.log(true);
        Facade.flush();
        Facade.log(false);
        Facade.flush();
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
        Facade.log(new Object());
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}
package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.acme.dbo.txlog.Facade.flush;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        Facade.log(1);
        flush();
        Facade.log(0);
        flush();
        Facade.log(-1);
        flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 0");
        assertSysoutContains("primitive: -1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Facade.log((byte)1);
        flush();
        Facade.log((byte)0);
        flush();
        Facade.log((byte)-1);
        flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Facade.log('a');
        flush();
        Facade.log('b');
        flush();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Facade.log("test string 1");
        flush();
        Facade.log("other str");
        flush();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Facade.log(true);
        flush();
        Facade.log(false);
        flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Facade.log(new Object());
        flush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}
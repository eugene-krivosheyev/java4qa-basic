package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.acme.dbo.txlog.Facade.flush;
import static com.acme.dbo.txlog.Facade.log;
import static java.lang.System.lineSeparator;

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
        log(1);
        flush();
        log(0);
        flush();
        log(-1);
        flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + lineSeparator() + "primitive: 0" + lineSeparator() + "primitive: -1" + lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        log((byte)1);
        flush();
        log((byte)0);
        flush();
        log((byte)-1);
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
        log('a');
        flush();
        log('b');
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
        log("test string 1");
        flush();
        log("other str");
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
        log(true);
        flush();
        log(false);
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
        log(new Object());
        flush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

}
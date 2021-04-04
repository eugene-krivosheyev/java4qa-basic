package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
        Facade.log(1);
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        Facade.log(-1);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 0");
        assertSysoutContains("primitive: -1");
        assertSysoutEquals("primitive: 1" + lineSeparator()
                + "primitive: 0" + lineSeparator()
                + "primitive: -1" + lineSeparator());
//       Assuming client and server will have same platform (logger code and the client)
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Facade.log((byte)1);
        Facade.flush();
        Facade.log((byte)0);
        Facade.flush();
        Facade.log((byte)-1);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("primitive: 0");
        assertSysoutContains("primitive: -1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
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
    public void shouldLogString() throws IOException {
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
    public void shouldLogBoolean() throws IOException {
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
    public void shouldLogReference() throws IOException {
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
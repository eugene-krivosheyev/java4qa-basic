package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    String lineSeparator = System.lineSeparator();
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
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Facade.log("str 1");
        Facade.flush();

        Facade.log(1);
        Facade.log(2);
        Facade.flush();

        Facade.log("str 2");
        Facade.flush();

        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("3" + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Facade.log("str 1");
        Facade.flush();

        Facade.log(10);
        Facade.flush();

        Facade.log(Integer.MAX_VALUE);
        Facade.flush();

        Facade.log("str 2");
        Facade.flush();

        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("10" + lineSeparator);
        assertSysoutContains(Integer.MAX_VALUE + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        //endregion
    }


    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1");
        Facade.flush();

        Facade.log((byte)10);
        Facade.flush();

        Facade.log((byte)Byte.MAX_VALUE);
        Facade.flush();

        Facade.log("str 2");
        Facade.flush();

        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("10" + lineSeparator);
        assertSysoutContains(Byte.MAX_VALUE + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);

        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Facade.log("str 1");
        Facade.log("str 2");
        Facade.log("str 2");

        Facade.log(0);
        Facade.flush();

        Facade.log("str 2");

        Facade.log("str 3");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + lineSeparator);
        assertSysoutContains("str 2 (x2)" + lineSeparator);
        assertSysoutContains("0" + lineSeparator);
        assertSysoutContains("str 2" + lineSeparator);
        assertSysoutContains("str 3 (x3)" + lineSeparator);
        //endregion
    }
}
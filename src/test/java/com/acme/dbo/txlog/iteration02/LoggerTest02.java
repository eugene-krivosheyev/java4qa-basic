package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.acme.dbo.txlog.facade.Facade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest02 implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogSequentIntegersAsSum() {
        //region when
        Facade.log("str 1");
        Facade.log(1);
        Facade.log(2);
        Facade.log("str 2");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + System.lineSeparator() +
                        "primitive: 3" + System.lineSeparator() +
                        "string: str 2" + System.lineSeparator() +
                        "primitive: 0" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Facade.log("str 1");
        Facade.log(10);
        Facade.log(Integer.MAX_VALUE);
        Facade.log("str 2");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + System.lineSeparator() +
                        "primitive: 10" + System.lineSeparator() +
                        "primitive: " + Integer.MAX_VALUE + "" + System.lineSeparator() +
                        "string: str 2" + System.lineSeparator() +
                        "primitive: 0" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Facade.log("str 1");
        Facade.log((byte) 10);
        Facade.log((byte) Byte.MAX_VALUE);
        Facade.log("str 2");
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + System.lineSeparator() +
                        "primitive: 10" + System.lineSeparator() +
                        "primitive: " + Byte.MAX_VALUE + "" + System.lineSeparator() +
                        "string: str 2" + System.lineSeparator() +
                        "primitive: 0" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() {
        //region when
        Facade.log("str 1");
        Facade.log("str 2");
        Facade.log("str 2");
        Facade.log(0);
        Facade.log("str 2");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + System.lineSeparator() +
                        "string: str 2 (x2)" + System.lineSeparator() +
                        "primitive: 0" + System.lineSeparator() +
                        "string: str 2" + System.lineSeparator() +
                        "string: str 3 (x3)" + System.lineSeparator()
        );
        //endregion
    }

    /*
    TODO: implement Logger solution to match specification as tests
    */
}
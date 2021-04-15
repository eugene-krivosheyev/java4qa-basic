package com.acme.dbo.txlog.iteration03;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static com.acme.dbo.txlog.Facade.flush;
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

//    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[]{-1, 0, 1});
        flush();
        //endregion

        //region then
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        flush();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives matrix: {" + lineSeparator() +
                        "{-1, 0, 1}" + lineSeparator() +
                        "{1, 2, 3}" + lineSeparator() +
                        "{-1, -2, -3}" + lineSeparator() +
                        "}" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log("str1", "string 2", "str 3");
        flush();
        //endregion

        //region then
        assertSysoutContains("str1");
        assertSysoutContains("string 2");
        assertSysoutContains("str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Facade.log(-1, 0, 1, 3);
        flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }
}
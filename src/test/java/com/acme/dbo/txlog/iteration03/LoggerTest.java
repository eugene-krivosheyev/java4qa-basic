package com.acme.dbo.txlog.iteration03;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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

    /*
    TODO: implement Logger solution to match specification as tests
     */

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[] {-1, 0, 1});
        Facade.flush();
        //endregion
        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Facade.flush();
        //endregion
        //region then
        assertSysoutEquals(
            "primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
            "}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log("str1", "string 2", "str 3");
        Facade.flush();
        //endregion
        //region then
        assertSysoutContains("str1");
        assertSysoutContains("string 2");
        assertSysoutContains("str 3");
        //endregion
    }

//    @Test
//    public void shouldLogIntegersWithOneMethodCall() throws IOException {
//        //region when
//        Facade.log(-1, 0, 1, 3);
//        Facade.flush();
//        //endregion
//        //region then
//        assertSysoutContains("3");
//        //endregion
//    }
}
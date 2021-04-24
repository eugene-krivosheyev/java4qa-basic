package com.acme.dbo.txlog.iteration03;

import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.acme.dbo.txlog.facade.Facade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest03 implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogIntegersArray() {
        //region when
        Facade.log(new int[] {-1, 0, 1});
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives array: {-1, 0, 1}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() {
        //region when
        Facade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" + System.lineSeparator() +
                "{-1, 0, 1}" + System.lineSeparator() +
                "{1, 2, 3}" + System.lineSeparator() +
                "{-1, -2, -3}" + System.lineSeparator() +
            "}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() {
        //region when
        Facade.log(new int[][][][] {{{{0}}}});
        Facade.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {" + System.lineSeparator() +
                "{" + System.lineSeparator() + "{" + System.lineSeparator() + "{" + System.lineSeparator() +
                    "0" + System.lineSeparator() +
                "}" + System.lineSeparator() + "}" + System.lineSeparator() + "}" + System.lineSeparator() +
            "}" + System.lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() {
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

    @Test
    public void shouldLogIntegersWithOneMethodCall() {
        //region when
        Facade.log(-1, 0, 1, 3);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains("primitives array: {-1, 0, 1, 3}");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() {
        //region when
        Facade.log(1);
        Facade.log("str");
        Facade.log(Integer.MAX_VALUE - 10);
        Facade.log(11);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(1);
        assertSysoutContains("str");
        assertSysoutContains(Integer.MAX_VALUE - 10);
        assertSysoutContains(11);
        //endregion
    }
}
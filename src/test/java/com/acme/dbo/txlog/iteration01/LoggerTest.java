package com.acme.dbo.txlog.iteration01;

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


    public void assertSysoutContainsArray(String[] expected) {
        for (String s : expected) {
            assertSysoutContains(s);
        }
    }

    public void callFacadeMultipleTimes(byte[] messages) {
        for (byte message : messages) {
            Facade.log(message);
            Facade.flush();
        }
    }

    public void callFacadeMultipleTimes(int[] messages) {
        for (int message : messages) {
            Facade.log(message);
            Facade.flush();
        }
    }

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        callFacadeMultipleTimes(new int[]{1,0,-1});
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1\nprimitive: 0\nprimitive: -1\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        callFacadeMultipleTimes(new byte[]{(byte)1,(byte)0,(byte)-1});
        //endregion

        //region then
        assertSysoutContainsArray(new String[]{"primitive: ", "1", "0", "-1"});
        //endregion
    }


//    TODO: implement Logger solution to match specification as tests

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
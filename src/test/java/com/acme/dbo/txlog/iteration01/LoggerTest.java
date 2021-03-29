package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.acme.dbo.txlog.FacadePrefixes.*;
import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private final String lineSeparator = lineSeparator();
    private String logResultInt(int number){
        return INT_PREFIX + number + lineSeparator;
    }
    private String logResultByte(byte number){
        return BYTE_PREFIX + number + lineSeparator;
    }
    private String logResultChar(char symbol){
        return CHAR_PREFIX + symbol + lineSeparator;
    }

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
        int number1 = 1;
        int number2 = 0;
        int number3 = -1;

        //region when
        Facade.log(number1);
        Facade.flush();
        Facade.log(number2);
        Facade.flush();
        Facade.log(number3);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(INT_PREFIX);
        assertSysoutEquals(logResultInt(number1) +
                                    logResultInt(number2) +
                                    logResultInt(number3));
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        byte number1 = 1;
        byte number2 = 0;
        byte number3 = -1;


        //region when
        Facade.log(number1);
        Facade.flush();
        Facade.log(number2);
        Facade.flush();
        Facade.log(number3);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(BYTE_PREFIX);
        assertSysoutContains(Integer.toString(number1));
        assertSysoutContains(Integer.toString(number2));
        assertSysoutContains(Integer.toString(number3));
        //endregion
    }


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        char symbol1 = 'a';
        char symbol2 = 'b';
        //region when
        Facade.log(symbol1);
        Facade.log(symbol2);
        //endregion

        //region then
        assertSysoutContains(CHAR_PREFIX);
        assertSysoutContains(Character.toString(symbol1));
        assertSysoutContains(Character.toString(symbol2));
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        String string1 = "test string 1";
        String string2 = "other str";
        //region when
        Facade.log(string1);
        Facade.log(string2);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(STRING_PREFIX);
        assertSysoutContains(string1);
        assertSysoutContains(string2);
        //endregion
    }


    @Test
    public void shouldLogBoolean() throws IOException {
        boolean bool1 = true;
        boolean bool2 = false;
        //region when
        Facade.log(bool1);
        Facade.log(bool2);
        //endregion

        //region then
        assertSysoutContains(BOOLEAN_PREFIX);
        assertSysoutContains(Boolean.toString(bool1));
        assertSysoutContains(Boolean.toString(bool2));
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        Object object = new Object();
        //region when
        Facade.log(object);
        //endregion

        //region then
        assertSysoutContains(REFERENCE_PREFIX);
        assertSysoutContains("@");
        //endregion
    }


}
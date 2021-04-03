package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import static com.acme.dbo.txlog.FacadePrefixes.*;
import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.PrimitiveIterator;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private final String LineSeparator =lineSeparator();
    private String logResultInt (int number) {

        return INT_PREFIX + number + lineSeparator();
    }
    private String logResultByte (byte number) {

        return BYTE_PREFIX + number + lineSeparator();
    }
    private String logResultChar (char symbol) {

        return CHAR_PREFIX + symbol + lineSeparator();
    }

    private String logResultString (String symbol) {

        return STRING_PREFIX + symbol + lineSeparator();

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
        //region when
        int number1=1;
        int number2=0;
        int number3=-1;
        Facade.log(number1);
        Facade.flush();
        Facade.log(number2);
        Facade.flush();
        Facade.log(number3);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(INT_PREFIX);
        assertSysoutEquals(logResultInt(number1)  + logResultInt(number2) + logResultInt(number3));
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        byte byte1=1;
        byte byte2=0;
        byte byte3=-1;
        Facade.log((byte1));
        Facade.flush();
        Facade.log((byte2));
        Facade.flush();
        Facade.log((byte3));
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(BYTE_PREFIX);
        assertSysoutEquals(logResultByte(byte1) + logResultByte(byte2) + logResultByte(byte3));
        //endregion
    }


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        char char1 = 'a';
        char char2 = 'b';
        Facade.log(char1);
        Facade.log(char2);
        //endregion

        //region then
        assertSysoutContains(CHAR_PREFIX);
        assertSysoutEquals(logResultChar(char1) + logResultChar(char2));
        //endregion
    }


    @Test
    public void shouldLogString() throws IOException {
        //region when
        String string1 = "test string 1";
        String string2 = "other str";
        Facade.log(string1);
        Facade.log(string2);
        //endregion

        //region then
        assertSysoutContains(STRING_PREFIX);
        assertSysoutEquals(logResultString(string1) + logResultString(string2));
        //endregion
    }
/*
    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Facade.log(true);
        Facade.log(false);
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
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
    */
}
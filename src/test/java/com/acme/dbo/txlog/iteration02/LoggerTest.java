package com.acme.dbo.txlog.iteration02;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import static com.acme.dbo.txlog.FacadePrefixes.*;
import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;
import static java.lang.System.lineSeparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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



    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        String string1 = "str 1";
        int number1 = 1;
        int number2 = 2;
        String string2 = "str 2";
        int number3 = 0;

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
        assertSysoutContains(INT_PREFIX);
        assertSysoutContains(STRING_PREFIX);
        assertSysoutEquals(logResultString(string1)  + logResultInt(number1 + number2) + logResultString(string2) + logResultInt(number3));
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        String string1 = "str 1";
        int number1 = 10;
        int number2 = Integer.MAX_VALUE;
        String string2 = "str 2";
        int number3 = 0;

        Facade.log("str 1");
        Facade.flush();
        Facade.log(10);
        Facade.log(Integer.MAX_VALUE);
        Facade.flush();
        Facade.log("str 2");
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(INT_PREFIX);
        assertSysoutContains(STRING_PREFIX);
        assertSysoutEquals(logResultString(string1) + logResultInt(number1) + logResultInt(number2) + logResultString(string2) + logResultInt(number3));
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        String string1 = "str 1";
        byte byte1 = 10;
        byte byte2 = Byte.MAX_VALUE;
        String string2 = "str 2";
        int number1 = 0;

        Facade.log("str 1");
        Facade.flush();
        Facade.log((byte)10);
        Facade.log((byte)Byte.MAX_VALUE);
        Facade.flush();
        Facade.log("str 2");
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(INT_PREFIX);
        assertSysoutContains(STRING_PREFIX);
        assertSysoutEquals(logResultString(string1) + logResultByte(byte1) + logResultByte(byte2) + logResultString(string2) + logResultInt(number1));
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        String string1 = "str 1";
        String string2 = "str 2";
        int number1 = 0;
        String string3 = "str 3";

        Facade.log("str 1");
        Facade.flush();
        Facade.log("str 2");
        Facade.log("str 2");
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        Facade.log("str 2");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.log("str 3");
        Facade.flush();
        //endregion

        //region then
        assertSysoutContains(INT_PREFIX);
        assertSysoutContains(STRING_PREFIX);
        assertSysoutEquals(logResultString(string1) + logResultString(string2) + logResultInt(number1) + logResultString(string2) + logResultString(string3));
        assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        //endregion
    }
}


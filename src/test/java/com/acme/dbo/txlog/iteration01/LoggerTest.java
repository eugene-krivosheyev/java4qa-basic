//package com.acme.dbo.txlog.iteration01;
//
//import com.acme.dbo.txlog.Facade;
//import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class LoggerTest implements SysoutCaptureAndAssertionAbility {
//    //region given
//    @Before
//    public void setUpSystemOut() throws IOException {
//        resetOut();
//        captureSysout();
//    }
//
//    @After
//    public void tearDown() {
//        resetOut();
//    }
//    //endregion
//
//    private String getTestString(String prefix, Object obj){
//        String separator = System.lineSeparator();
//        return prefix + ": " + obj.toString() + separator;
//        //return String.format("%s:%s%s", prefix, content, separator);
//    }
//
//    @Test
//    public void shouldLogInteger() throws IOException {
//        //region when
//        Facade.log(1);
//        Facade.flush();
//        Facade.log(0);
//        Facade.flush();
//        Facade.log(-1);
//        Facade.flush();
//        //endregion
//
//        //region then
//        assertSysoutContains("primitive: ");
//        assertSysoutContains(getTestString("primitive", "1"));
//        assertSysoutContains(getTestString("primitive","0"));
//        assertSysoutContains(getTestString("primitive","-1"));
//        //endregion
//    }
//
//    @Test
//    public void shouldLogByte() throws IOException {
//        //region when
//        Facade.log((byte)1);
//        Facade.flush();
//
//        Facade.log((byte)0);
//        Facade.flush();
//
//        Facade.log((byte)-1);
//        Facade.flush();
//        //endregion
//
//        //region then
//        assertSysoutContains("primitive: ");
//        assertSysoutContains(getTestString("primitive","1"));
//        assertSysoutContains(getTestString("primitive","0"));
//        assertSysoutContains(getTestString("primitive","-1"));
//        //endregion
//    }
//
//
//    //TODO: implement Logger solution to match specification as tests
//
//    @Test
//    public void shouldLogChar() throws IOException {
//        //region when
//        Facade.log('a');
//        Facade.log('b');
//        //endregion
//
//        //region then
//        assertSysoutContains("char: ");
//        assertSysoutContains(getTestString("char",'a'));
//        assertSysoutContains(getTestString("char",'b'));
//        //endregion
//    }
//
//    @Test
//    public void shouldLogString() throws IOException {
//        //region when
//        Facade.log("test string 1");
//        Facade.log("other str");
//        //endregion
//
//        //region then
//        assertSysoutContains("string: ");
//        assertSysoutContains(getTestString("string","test string 1"));
//        assertSysoutContains(getTestString("string","other str"));
//        //endregion
//    }
//
////    @Test
////    public void shouldLogBoolean() throws IOException {
////        //region when
////        Facade.log(true);
////        Facade.log(false);
////        //endregion
////
////        //region then
////        assertSysoutContains("primitive: ");
////        assertSysoutContains(getTestString("primitive","true"));
////        assertSysoutContains(getTestString("primitive","false"));
////        //endregion
////    }
//
////    @Test
////    public void shouldLogReference() throws IOException {
////        //region when
////        Object obj = new Object();
////        Facade.log(obj);
////        //endregion
////
////        //region then
////        assertSysoutContains("reference: ");
////        assertSysoutContains(getTestString("reference", obj));
////        //endregion
////    }
//
//Integer a = new Integer((char)'a');
//}
package com.acme.dbo.txlog;

import static com.sun.deploy.trace.Trace.flush;
import static com.acme.dbo.txlog.FacadePrefixes.*;
import static com.acme.dbo.txlog.FacadePrefixes.INT_PREFIX;
import static jdk.nashorn.internal.objects.Global.print;

public class Facade {
    public static final String INT_PREFIX = "primitive: ";
    public static final String BYTE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "string: ";
    public static final String STRING_PREFIX = "string: ";

    private static String type = "null";
    private static int cumulativeIntLog = 0;
    private static byte cumulativeByteLog = 0;
    private static char cumulativeCharLog = 0;
    private static String cumulativeStringLog = "0";


    public static void log(int message) {
        if (type != "int") {
            flush();
            type = "int";
            cumulativeIntLog = message;
        } else {
            if (Integer.MAX_VALUE - message >= cumulativeIntLog) {
                cumulativeIntLog += message;
            } else {
                flush();
                log(message);
            }
        }
    }

    public static void flush() {
        if (type == "int") {
            print(INT_PREFIX + cumulativeIntLog);
        } else if (type == "byte") {
            print(BYTE_PREFIX + cumulativeByteLog);
        } else if (type == "char") {
            print(CHAR_PREFIX + cumulativeCharLog);
        }
        else if (type == "string") {
            print(STRING_PREFIX + cumulativeStringLog);
        }
        else {
            type = "null";
        }
    }

    public static void log(byte message) {
        if (type != "byte") {
            flush();
            type = "byte";
            cumulativeByteLog = message;
        } else {
            if (Byte.MAX_VALUE - message >= cumulativeByteLog) {
                cumulativeByteLog += message;
            } else {
                flush();
                log(message);
            }
        }
    }

    public static void log(char message) {
        type = "char";
        print(CHAR_PREFIX + message);
        }

    public static void log(String message) {
        type = "string";
        print(STRING_PREFIX + message);
        }

    public static void print (String message){
            System.out.println(message);
        }
    }





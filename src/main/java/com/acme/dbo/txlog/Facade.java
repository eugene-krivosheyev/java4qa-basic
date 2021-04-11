package com.acme.dbo.txlog;

import com.acme.dbo.txlog.controller.LoggerController;
import com.acme.dbo.txlog.message.ByteMessage;
import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class Facade {

    private static final LoggerController loggerController = new LoggerController();

    public static final String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";
    public static final String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }

    public static void log(byte message) {

        loggerController.log(new ByteMessage(message));
    }

    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }

    public static void log(char message) {
        print(decorate(message, CHAR_PREFIX, ""));
    }

    public static void log(boolean message) {
        print(decorate(message, "primitive: ", ""));
    }

    public static void log(Object message) {
        print(decorate(message, REFERENCE_PREFIX, ""));
    }

    public static void log(int[][] messagesMatrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(lineSeparator());
        for (int[] ints : messagesMatrix) {
            sb.append(buildPrimitivesArrayOutput(ints));
            sb.append(lineSeparator());
        }
        sb.append("}");
        print(decorate(sb,PRIMITIVES_MATRIX_PREFIX,""));
    }

    public static void log(int... messages) {
        String sb = buildPrimitivesArrayOutput(messages);
        print(decorate(sb, PRIMITIVES_ARRAY_PREFIX, ""));
    }

    public static void log(String... messages) {
        String sb = buildGenericsArrayOutput(messages, lineSeparator());
        print(decorate(sb, "", ""));
    }


    private static void print(Object message) {
        System.out.println(message);
    }

    private static String buildPrimitivesArrayOutput(int[] message) {
        Integer[] array = Arrays.stream( message ).boxed().toArray( Integer[]::new );
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(buildGenericsArrayOutput(array, ", "));
        sb.append("}");
        return sb.toString();
    }

    private static<T> String buildGenericsArrayOutput(T[] messages, String separator) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < messages.length; i++) {
            sb.append(messages[i]);
            if(i != messages.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    private static String decorate(Object message, String prefix, String postfix) {
        return prefix + message + postfix;
    }
}

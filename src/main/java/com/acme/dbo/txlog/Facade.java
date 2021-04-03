package com.acme.dbo.txlog;

public class Facade {

    private static Object lastObject = null;
    private static int lastStrObjectRepeatedCnt = 0;

    // check object. accumulate if required, flush on type/value change
    public static void log(Object obj) {
        if (null == lastObject) {
            lastObject = obj;
        } else if(obj.getClass() != lastObject.getClass()) {
            flush();
            lastObject = obj;
        } else if (obj instanceof Integer) {
            long lObj = ((Integer)obj).longValue();
            long lLastObj = ((Integer)lastObject).longValue();
            long sum = lObj + lLastObj;

            if(sum > Integer.MAX_VALUE) {
                flush();
                lastObject = obj;
            } else {
                lastObject = sum;
            }
        } else if (obj instanceof String) {
            String sObj = (String)obj;
            String sLastObj = (String)lastObject;
            if (sObj.equals(sLastObj)) {
                ++lastStrObjectRepeatedCnt;
            } else {
                flush();
                lastObject = obj;
            }
        } else {
            flush();
            lastObject = obj;
        }
    }

    private static void logInternal(Object obj) {
        printMessage(decorate(obj));
    }

    // if we have accumulated value
    public static void flush() {
        if (null == lastObject)
            return;

        Object ret = lastObject;

        if (lastStrObjectRepeatedCnt > 0) {
            ret = lastObject + " (x" +  (lastStrObjectRepeatedCnt + 1) + ")";
            lastStrObjectRepeatedCnt = 0;
        }

        logInternal(ret);
        lastObject = null;
    }

    private static String decorate(Object message) {
        String prefix = "reference: "; // default one, if need custom case - modify below

        if ((message instanceof Integer) || (message instanceof Byte) || (message instanceof Boolean)) {
            prefix = "primitive: ";
        } else if (message instanceof String ) {
            prefix = "string: ";
        } else if (message instanceof Character) {
            prefix = "char: ";
        }

        return prefix + message;
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }
}

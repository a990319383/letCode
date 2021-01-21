package com.sangsang.util;

public class ExceptionUtil {

    public static String getException(Exception e){
        StringBuffer sOut = new StringBuffer();
        sOut.append(e.getMessage() + "\r\n");
        StackTraceElement[] trace = e.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut.append("\tat " + s + "\r\n");
        }
        return sOut.toString();
    }
    
}

package com.ali.weathermap;

public class Log {
    public static void i(String tag, String msg) {
        if (Enviroment.showLog) {
            android.util.Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (Enviroment.showLog) {
            android.util.Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (Enviroment.showLog) {
            android.util.Log.i(tag, msg);
        }
    }

    public static String getStackTraceString(Exception e) {
        return android.util.Log.getStackTraceString(e);
    }
}
package com.ali.weathermap;

import java.lang.reflect.Type;

public class Enviroment {

    //Default values (production)
    public static boolean showLog = false;

    private static Type type = Type.DEVELOPE;

    public static void configure() {
        switch (type) {
            case DEVELOPE:
                showLog = true;
                break;
            case PRODUCTION:
                showLog = false;
                break;
        }

    }

    public enum Type {
        DEVELOPE,
        PRODUCTION
    }
}

package com.ali.weathermap.utils;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

public class Constants {
    public static final String DATE_LONG = "EEE, MMM dd";
    public static final String DATE_SHORT = "dd/MM/yyyy";
    public static final String DATE_1 = "EEE, MMM";
    public static final String DATE_2 = "EEE, dd/MM ";
    public static final String DATE_3 = "EEE dd ,HH:mm a";
    public static final String HOUR = "hh:mm a";

    public static String getDate(long time, String pattern) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format(pattern, cal).toString();
        return date;
    }
}

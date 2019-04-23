package com.ali.weathermap.utils;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

public class Constants {

    public static String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }
}

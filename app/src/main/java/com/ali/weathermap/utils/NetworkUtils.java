package com.ali.weathermap.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ali.weathermap.data.network.ApiClient;
import com.ali.weathermap.data.network.ApiInterface;

public class NetworkUtils {
    //API URL
    final public static String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    final public static String BASE_URL_ICON = "https://openweathermap.org/img/w/";

    // API Queries
    final public static String Q_CITY_NAME = "q";
    final public static String Q_KEY = "APPID";
    final public static String Q_UNITS = "units";

    //End Points
    final public static String END_POINT_WEATHER = "weather";
    final public static String END_POINT_FORECAST = "forecast";

    public static ApiInterface getApiServices() {
        return ApiClient.getClient().create(ApiInterface.class);
    }

    //Check Network Connectivity
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }
}

package com.ali.weathermap.data.network;

import com.ali.weathermap.utils.NetworkUtils;

import java.util.HashMap;
import java.util.Map;

public class Queries {

    private static Map<String, Object> stringMap;

    public static Map<String, Object> getQueriesMap(String name, String unit) {
        stringMap = new HashMap<>();
        stringMap.put(NetworkUtils.Q_CITY_NAME, name);
        stringMap.put(NetworkUtils.Q_UNITS, unit);
        return stringMap;
    }
}

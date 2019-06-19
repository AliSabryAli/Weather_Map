package com.ali.weathermap.data.local.pref;


public interface PreferencesHelperModel {

    void saveData(String key, String value);

    String getData(String key, String defaultValue);
}

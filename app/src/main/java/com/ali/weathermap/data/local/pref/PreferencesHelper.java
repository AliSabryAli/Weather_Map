package com.ali.weathermap.data.local.pref;

import android.app.Activity;
import android.content.SharedPreferences;

public class PreferencesHelper implements PreferencesHelperModel {

    SharedPreferences SHARED_PREFERENCES = null;

    public PreferencesHelper(Activity activity) {
        SHARED_PREFERENCES = activity.getPreferences(activity.MODE_PRIVATE);
    }

    @Override
    public void saveData(String key, String value) {
        SHARED_PREFERENCES.edit().putString(key, value).commit();
    }

    @Override
    public String getData(String key, String defaultValue) {
        return SHARED_PREFERENCES.getString(key, defaultValue);
    }
}

package com.ali.weathermap.ui.main;

import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Map;

/**
 * Call when user interact with the view and other when view OnDestroy()
 */

public interface MainMvpPresenter {
    void requestDataFromServer(String endPoint, Map<String, Object> queries);

    void requestImageFromServer(ImageView imageWeatherIcon, ProgressBar progressBar);

    void onDestroy();
}

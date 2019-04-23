package com.ali.weathermap.ui.main;

import com.ali.weathermap.modle.Weather;

/**
 * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
 * while the displayDataToView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
 **/
public interface MainMvpView {

    void setupUi();

    void displayDataToView(Weather weather);

    void showProgress();

    void hideProgress();

}

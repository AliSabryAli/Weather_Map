package com.ali.weathermap.ui.main;

import com.ali.weathermap.modle.Forecast;
import com.ali.weathermap.modle.Weather;

import java.util.List;

/**
 * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
 * while the displayDataToView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
 **/
public interface MainMvpView {

    void setupUi();

    void displayDataToView(Weather weather);

    void setDataToRecyclerView(List<Forecast> forecastList);

    void showProgress();

    void hideProgress();

}

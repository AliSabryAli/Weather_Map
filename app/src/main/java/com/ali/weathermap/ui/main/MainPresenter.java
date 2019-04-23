package com.ali.weathermap.ui.main;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ali.weathermap.data.network.ApiModel;
import com.ali.weathermap.data.network.ApiModelListener;
import com.ali.weathermap.data.network.LoadingImage;
import com.ali.weathermap.data.network.entity.WeatherListResponse;
import com.ali.weathermap.data.network.entity.weather.CurrentWeather;
import com.ali.weathermap.data.network.entity.weather.WeatherDetails;
import com.ali.weathermap.data.network.entity.weather.Wind;
import com.ali.weathermap.modle.Weather;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainPresenter implements MainMvpPresenter {
    private final static String TAG = "Main Presenter";
    private MainMvpView mainView;
    private ApiModel apiModel;
    private Weather weather;
    private WeatherDetails weatherDetails;
    private Wind wind;
    private List<CurrentWeather> currentWeatherList;

    public MainPresenter(MainMvpView mainView) {
        this.mainView = mainView;
        apiModel = new ApiModel();
        weather = new Weather();
        wind = new Wind();
        currentWeatherList = new ArrayList<>();
    }

    @Override
    public void requestDataFromServer(String endPoint, Map<String, Object> queries) {
        apiModel.getObjects(endPoint, queries, new ApiModelListener.OnFinishedListener() {
            @Override
            public void onFinished(Object responseObjects) {
                String json = new Gson().toJson(responseObjects);
                WeatherListResponse response = new Gson().fromJson(
                        json, WeatherListResponse.class);
                wind = response.getWind();
                weatherDetails = response.getWeatherDetails();
                currentWeatherList = response.getCurrentWeather();

                weather.setName(response.getName());
                weather.setHumidity(weatherDetails.getHumidity());
                weather.setPressure(weatherDetails.getPressure());
                weather.setDate(response.getDate());
                weather.setTemp(String.valueOf(Math.round(weatherDetails.getTemp())));
                weather.setWind(String.valueOf(wind.getSpeed()));
                for (CurrentWeather currentWeather : currentWeatherList) {
                    weather.setCloudiness(currentWeather.getDescription());
                    weather.setIcon(currentWeather.getIcon());

                }
                mainView.displayDataToView(weather);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void requestImageFromServer(ImageView imageWeatherIcon, ProgressBar progressBar) {
        LoadingImage.getImage(
                (Context) mainView, imageWeatherIcon, progressBar, weather.getIcon() + ".png");
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }


}

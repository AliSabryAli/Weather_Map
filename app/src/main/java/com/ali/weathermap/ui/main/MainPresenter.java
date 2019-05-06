package com.ali.weathermap.ui.main;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ali.weathermap.data.network.ApiModel;
import com.ali.weathermap.data.network.ApiModelListener;
import com.ali.weathermap.data.network.LoadingImage;
import com.ali.weathermap.data.network.entity.ForecastListResponse;
import com.ali.weathermap.data.network.entity.WeatherListResponse;
import com.ali.weathermap.data.network.entity.forecast.ForecastList;
import com.ali.weathermap.data.network.entity.forecast.Main;
import com.ali.weathermap.data.network.entity.forecast.WeatherState;
import com.ali.weathermap.data.network.entity.weather.CurrentWeather;
import com.ali.weathermap.data.network.entity.weather.WeatherDetails;
import com.ali.weathermap.data.network.entity.weather.Wind;
import com.ali.weathermap.modle.Forecast;
import com.ali.weathermap.modle.Weather;
import com.ali.weathermap.utils.Constants;
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
    //
    private List<Forecast> forecastsList;
    private List<ForecastList> forecastListٌResponse;
    private Forecast forecast;
    private Main main;
    private List<WeatherState> weatherStateList;

    public MainPresenter(MainMvpView mainView) {
        this.mainView = mainView;
        apiModel = new ApiModel();
        weather = new Weather();
        forecastsList = new ArrayList<>();
        wind = new Wind();
        currentWeatherList = new ArrayList<>();
        forecastListٌResponse = new ArrayList<>();
        weatherStateList = new ArrayList<>();
    }

    @Override
    public void requestWeatherFromServer(String endPoint, Map<String, Object> queries) {
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
                weather.setDate(response.getDate(Constants.DATE_LONG));
                weather.setTemp(String.valueOf(Math.round(weatherDetails.getTemp())));
                weather.setWind(String.valueOf(wind.getSpeed()));
                weather.setMax(String.valueOf(Math.round(weatherDetails.getTempMax())));
                weather.setMin(String.valueOf(Math.round(weatherDetails.getTempMin())));
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
    public void requestForecastFromServer(String endPoint, Map<String, Object> queries) {
        apiModel.getObjects(endPoint, queries, new ApiModelListener.OnFinishedListener() {
            @Override
            public void onFinished(Object responseObjects) {
                String json = new Gson().toJson(responseObjects);
                ForecastListResponse response = new Gson().fromJson(
                        json, ForecastListResponse.class);
                forecastListٌResponse = response.getList();
                for (ForecastList forecastItem : forecastListٌResponse) {
                    forecast = new Forecast();
                    forecast.setDate(Constants.getDate(forecastItem.getDt(), Constants.DATE_LONG));
                    forecast.setMin(String.valueOf(Math.round(forecastItem.getMain().getTempMin())));
                    forecast.setMax(String.valueOf(Math.round(forecastItem.getMain().getTempMax())));
                    weatherStateList = forecastItem.getWeather();
                    for (WeatherState weatherState : weatherStateList) {
                        forecast.setDescription(weatherState.getDescription());
                        forecast.setIcon(weatherState.getIcon());
                    }
                    forecastsList.add(forecast);
                    Log.i(TAG, "onFinished: Description " + forecast.getDescription() + "\n");
                }
                Log.i(TAG, "onFinished: " + forecastsList + "\n");
                mainView.setDataToRecyclerView(forecastsList);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void requestImageFromServer(ImageView imageWeatherIcon, ProgressBar progressBar, String icon) {
        LoadingImage.getImage(
                (Context) mainView, imageWeatherIcon, progressBar, icon + ".png");
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }


}

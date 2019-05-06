package com.ali.weathermap.data.network.entity.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastList {
    @SerializedName("dt")
    private Integer dt;
    @SerializedName("main")
    private Main main;
    @SerializedName("weather")
    private List<WeatherState> weather = null;
    @SerializedName("dt_txt")
    private String dateTxt;

    public String getDateTxt() {
        return dateTxt;
    }

    public void setDateTxt(String dateTxt) {
        this.dateTxt = dateTxt;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<WeatherState> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherState> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "ForecastList{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                '}';
    }
}

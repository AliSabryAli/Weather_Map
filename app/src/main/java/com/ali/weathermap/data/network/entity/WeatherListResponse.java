package com.ali.weathermap.data.network.entity;

import com.ali.weathermap.data.network.entity.weather.Clouds;
import com.ali.weathermap.data.network.entity.weather.Coordinates;
import com.ali.weathermap.data.network.entity.weather.CurrentWeather;
import com.ali.weathermap.data.network.entity.weather.Sys;
import com.ali.weathermap.data.network.entity.weather.WeatherDetails;
import com.ali.weathermap.data.network.entity.weather.Wind;
import com.ali.weathermap.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherListResponse {

    @SerializedName("coord")
    private Coordinates coordinates;

    @SerializedName("weather")
    private List<CurrentWeather> currentWeather = null;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private WeatherDetails weatherDetails;

    @SerializedName("visibility")
    private Integer visibility;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("dt")
    private long date;

    @SerializedName("sys")
    private Sys system;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private Integer code;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<CurrentWeather> getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(List<CurrentWeather> currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public String getDate(String pattern) {
        return Constants.getDate(date, pattern);
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Sys getSystem() {
        return system;
    }

    public void setSystem(Sys system) {
        this.system = system;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "WeatherListResponse{" +
                "coordinates=" + coordinates +
                ", currentWeather=" + currentWeather +
                ", base='" + base + '\'' +
                ", weatherDetails=" + weatherDetails +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", date=" + date +
                ", system=" + system +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}

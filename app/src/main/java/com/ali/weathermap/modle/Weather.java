package com.ali.weathermap.modle;

public class Weather {
    private String name;
    private String temp;
    private String Cloudiness;
    private Double humidity;
    private Double pressure;
    private String wind;
    private String date;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCloudiness() {
        return Cloudiness;
    }

    public void setCloudiness(String feelsLike) {
        this.Cloudiness = feelsLike;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "name :'" + name + '\'' +
                ", temp : '" + temp + '\'' +
                ", feelsLike : '" + Cloudiness + '\'' +
                ", humidity : '" + humidity + '\'' +
                ", pressure : '" + pressure + '\'' +
                ", wind : '" + wind + '\'' +
                '}';
    }
}

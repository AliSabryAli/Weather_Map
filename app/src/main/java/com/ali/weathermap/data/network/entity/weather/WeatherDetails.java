package com.ali.weathermap.data.network.entity.weather;

import com.google.gson.annotations.SerializedName;

public class WeatherDetails {
    @SerializedName("temp")
    private Double temp;

    @SerializedName("pressure")
    private Double pressure;

    @SerializedName("humidity")
    private Double humidity;

    @SerializedName("temp_min")
    private Double tempMin;

    @SerializedName("temp_max")
    private Double tempMax;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Temp : " + temp + "\n")
                .append("P : " + pressure + "\n")
                .append("H : " + humidity + "\n")
                .append("MinTemp : " + tempMin + "\n")
                .append("MaxTemp : " + tempMax).toString();
    }
}

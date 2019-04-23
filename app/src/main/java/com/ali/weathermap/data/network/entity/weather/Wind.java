package com.ali.weathermap.data.network.entity.weather;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private Double speed;

    @SerializedName("deg")
    private Double degree;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }
}

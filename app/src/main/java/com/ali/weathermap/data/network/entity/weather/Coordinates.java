package com.ali.weathermap.data.network.entity.weather;

import com.google.gson.annotations.SerializedName;

public class Coordinates {

    @SerializedName("lon")
    private Double lon;

    @SerializedName("lat")
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}

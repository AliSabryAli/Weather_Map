package com.ali.weathermap.data.network.entity.weather;

import com.google.gson.annotations.SerializedName;

public class CurrentWeather {

    @SerializedName("id")
    private Integer id;

    @SerializedName("main")
    private String state;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

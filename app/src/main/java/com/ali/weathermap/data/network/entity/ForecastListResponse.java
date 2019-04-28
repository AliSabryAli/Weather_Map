package com.ali.weathermap.data.network.entity;

import com.google.gson.annotations.SerializedName;

public class ForecastListResponse {
    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private Double message;

    @SerializedName("cnt")
    private Integer cnt;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "ForecastListResponse{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                '}';
    }
}

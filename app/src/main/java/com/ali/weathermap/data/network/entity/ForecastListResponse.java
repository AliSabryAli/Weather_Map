package com.ali.weathermap.data.network.entity;

import com.ali.weathermap.data.network.entity.forecast.ForecastList;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastListResponse {
    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private Double message;
    @SerializedName("cnt")
    private Integer cnt;
    @SerializedName("list")
    private List<ForecastList> list = null;

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

    public List<ForecastList> getList() {
        return list;
    }

    public void setList(List<ForecastList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ForecastListResponse{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                '}';
    }
}

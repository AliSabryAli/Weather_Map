package com.ali.weathermap.modle;

public class Forecast {
    private String date;
    private String icon;
    private String min;
    private String Max;
    private String hours;
    private String description;

    public String getDescription() {
        return description;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return Max;
    }

    public void setMax(String max) {
        Max = max;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", icon='" + icon + '\'' +
                ", min='" + min + '\'' +
                ", Max='" + Max + '\'' +
                '}';
    }
}

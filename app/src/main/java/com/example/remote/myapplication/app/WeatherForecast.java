package com.example.remote.myapplication.app;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WeatherForecast {
    @SerializedName("list")
    private List<WeatherDay> items;

    public WeatherForecast(List<WeatherDay> items) {
        this.items = items;
    }

    List<WeatherDay> getItems() {
        return items;
    }
}

package com.example.remote.myapplication.app;

public interface NetworkDataSource {
    void getToday(double mLongitude, double mLatityde);
    void setPresenter(WeatherInterfaceForDataSourse weatherPresenter);
}

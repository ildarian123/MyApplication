package com.example.remote.myapplication.app;

import android.content.Context;

public class WeatherPresenter implements WeatherPresenterInterface, WeatherInterfaceForDataSourse {

    private WeatherActivityInterface weatherActivity;
    private NetworkDataSource networkDataSource = new NetworkDataSourceImpl();

    public WeatherPresenter() {
        networkDataSource.setPresenter(this);
    }

    @Override
    public void getWeather(double mLatityde, double mLongitude) {
        networkDataSource.getToday(mLatityde, mLongitude);
    }

    @Override
    public void setView(WeatherActivityInterface view) {
        weatherActivity = view;
    }

    @Override
    public void setCityName(String cityName) {
        weatherActivity.setCityNameToUI(cityName);

    }

    @Override
    public void setContext(Context context) {

    }
}

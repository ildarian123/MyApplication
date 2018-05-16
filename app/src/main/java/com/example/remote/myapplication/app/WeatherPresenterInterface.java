package com.example.remote.myapplication.app;

import android.content.Context;

public interface WeatherPresenterInterface {
    void getWeather(double mLatityde, double mLongitude);
    void setView(WeatherActivityInterface view);
    void setContext(Context context);
}

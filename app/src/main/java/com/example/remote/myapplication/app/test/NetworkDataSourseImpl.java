package com.example.remote.myapplication.app.test;

public class NetworkDataSourseImpl implements NetworkDataSourse {

    private Presenter activity;

    @Override
    public void getToday() {
        //TODO get weather from internet
        activity.setWeatherToActivity();
    }

    @Override
    public void setActivity(Presenter activity) {
        this.activity = activity;
    }
}

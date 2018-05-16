package com.example.remote.myapplication.app.test;

public class PresenterImpl implements Presenter {

    private NetworkDataSourse networkDataSourse = new NetworkDataSourseImpl();

    public PresenterImpl() {
        networkDataSourse.setActivity(this);
        networkDataSourse.getToday();
    }

    @Override
    public void setWeatherToActivity() {

    }
}

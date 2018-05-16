package com.example.remote.myapplication.mvp.presentation;

import com.example.remote.myapplication.mvp.view.MainView;

public interface MainPresenter {

    void setView(MainView view);

    void calculate(int a, int b);

}

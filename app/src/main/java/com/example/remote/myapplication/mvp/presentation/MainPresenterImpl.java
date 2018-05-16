package com.example.remote.myapplication.mvp.presentation;

import com.example.remote.myapplication.mvp.model.MainModel;
import com.example.remote.myapplication.mvp.model.MainModelImpl;
import com.example.remote.myapplication.mvp.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainModel mainModel;

    public String temp;

    public MainPresenterImpl() {
        mainModel = new MainModelImpl();
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
    }

    @Override
    public void calculate(int a, int b) {
        int result = mainModel.calculate(a, b);
        view.setResultToUi(result);
        view.setVar("varvar");
    }

    public void doS() {

    }
}

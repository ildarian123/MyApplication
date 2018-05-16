package com.example.remote.myapplication.mvp.view;

import com.example.remote.myapplication.mvp.presentation.MainPresenter;
import com.example.remote.myapplication.mvp.presentation.MainPresenterImpl;

public class MainActivity implements MainView {

    private MainPresenter mainPresenter;

    private String var;

    @Override
    public void setVar(String var) {
        this.var = var;
    }

    public MainActivity() {
        mainPresenter = new MainPresenterImpl();
        mainPresenter.setView(this);
        mainPresenter.calculate(2, 2);


    }


    @Override
    public void setResultToUi(int result) {
        System.out.println("Result: " + result);
        //someTextView.setText(result);
    }
}

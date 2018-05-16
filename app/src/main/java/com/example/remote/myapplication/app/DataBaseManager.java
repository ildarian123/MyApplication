package com.example.remote.myapplication.app;

import android.content.Context;

import java.util.List;

public class DataBaseManager {

    private DaoSession mDaoSession;
    private Context mContext;
    TemperatureForDataBaseDao temperatureForDataBaseDao;
    public DataBaseManager(Context context) {
        this.mContext = context;
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(mContext, "greendao_demo.db").getWritableDb()).newSession();
        temperatureForDataBaseDao = mDaoSession.getTemperatureForDataBaseDao();
    }

    public void getManager(){

    }

    public void saveData(TemperatureForDataBase temperatureForDataBase){

        temperatureForDataBaseDao.save(temperatureForDataBase);

        List<TemperatureForDataBase> temperatureForDataBases = temperatureForDataBaseDao.loadAll();


    }
}

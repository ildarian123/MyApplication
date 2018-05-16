package com.example.remote.myapplication.app;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.remote.myapplication.app.test.Presenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkDataSourceImpl implements NetworkDataSource {

    String TAG = "WEATHER";
    String units = "metric";
    String key = WeatherAPI.KEY;
    WeatherAPI.ApiInterface api = WeatherAPI.getClient().create(WeatherAPI.ApiInterface.class);


    WeatherInterfaceForDataSourse weatherPresenter;



    @Override
    public void getToday(double mLongitude, double mLatityde) {
        Call<WeatherDay> callToday = api.getToday(mLongitude, mLatityde, units, key);
        callToday.enqueue(new Callback<WeatherDay>() {
            @Override
            public void onResponse(Call<WeatherDay> call, Response<WeatherDay> response) {
                Log.e(TAG, "onResponse");
                WeatherDay data = response.body();
                String city = data.getCity();

                weatherPresenter.setCityName(city);

// if (response.isSuccessful()) {
//                    city.setText(mCity);
//                    temperature.setText(data.getTempWithDegree());
//                    Glide.with(WeatherActivity.this).load(data.getIconUrl()).into(imageWeather);
//                }
            }

            @Override
            public void onFailure(Call<WeatherDay> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void setPresenter(WeatherInterfaceForDataSourse weatherPresenter) {
        this.weatherPresenter = weatherPresenter;

    }

    private void getForecast(double mLongitude, double mLatityde) {
        Call<WeatherForecast> callForecast = api.getForecast(mLongitude, mLatityde, units, key);
        callForecast.enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                Log.e(TAG, "onResponse");
                WeatherForecast data = response.body();

                if (response.isSuccessful()) {
                    Log.e(TAG, "response.isSuccessful");
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat formatDayOfWeek = new SimpleDateFormat("E");
//                    LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(
//                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
////                    LinearLayout.LayoutParams paramsImageView = new LinearLayout.LayoutParams(convertDPtoPX(40, WeatherActivity.this),
//                            convertDPtoPX(40, WeatherActivity.this));
//
//                    int marginRight = convertDPtoPX(15, WeatherActivity.this);
//                    LinearLayout.LayoutParams paramsLinearLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                            LinearLayout.LayoutParams.WRAP_CONTENT);
//                    paramsLinearLayout.setMargins(0, 0, marginRight, 0);


                    for (WeatherDay day : data.getItems()) {
                        if (day.getDate().get(Calendar.HOUR_OF_DAY) == 15) {
                            @SuppressLint("DefaultLocale") String date = String.format("%d.%d.%d %d:%d",
                                    day.getDate().get(Calendar.DAY_OF_MONTH),
                                    day.getDate().get(Calendar.WEEK_OF_MONTH),
                                    day.getDate().get(Calendar.YEAR),
                                    day.getDate().get(Calendar.HOUR_OF_DAY),
                                    day.getDate().get(Calendar.MINUTE)
                            );
                            Log.d(TAG, date);
                            Log.d(TAG, day.getTempInteger());
                            Log.d(TAG, "---");

                            // child view wrapper
//                            LinearLayout childLayout = new LinearLayout(WeatherActivity.this);
//                            childLayout.setLayoutParams(paramsLinearLayout);
//                            childLayout.setOrientation(LinearLayout.VERTICAL);
//
//                            // show day of week
//                            TextView tvDay = new TextView(WeatherActivity.this);
//                            String dayOfWeek = formatDayOfWeek.format(day.getDate().getTime());
//                            tvDay.setText(dayOfWeek);
//                            tvDay.setLayoutParams(paramsTextView);
//                            childLayout.addView(tvDay);
//
//                            // show image
//                            ImageView ivIcon = new ImageView(WeatherActivity.this);
//                            ivIcon.setLayoutParams(paramsImageView);
//                            Glide.with(WeatherActivity.this).load(day.getIconUrl()).into(ivIcon);
//                            childLayout.addView(ivIcon);
//
//                            // show temp
//                            TextView tvTemp = new TextView(WeatherActivity.this);
//                            tvTemp.setText(day.getTempWithDegree());
//                            tvTemp.setLayoutParams(paramsTextView);
//                            childLayout.addView(tvTemp);

                            //llForecast.addView(childLayout);
                        }
                    }
                } else Log.e(TAG, "Vse v govne");
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Log.e(TAG, t.toString());
            }
        });

    }

}

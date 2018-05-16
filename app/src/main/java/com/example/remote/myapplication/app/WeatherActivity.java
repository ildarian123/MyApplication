package com.example.remote.myapplication.app;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.remote.myapplication.R;

public class WeatherActivity extends AppCompatActivity implements WhenLocationReadyCallback, WeatherActivityInterface {

    private double mLatityde;
    private double mLongitude;
    private String mCity;

    private LocationManager mLocationManager;
    private LocationListener locationListener;
    private WeatherPresenterInterface weatherPresenter;


    String TAG = "WEATHER";
    TextView city;
    ImageView imageWeather;
    TextView temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_weather);
        findVews();
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener(getApplicationContext(), this);
        weatherPresenter = new WeatherPresenter();
        weatherPresenter.setView(this);
        refreshWeatherData();
        Context context = getApplicationContext();
        weatherPresenter.setContext(context);

    }

    @Override
    protected void onDestroy() {
        weatherPresenter.setView(null);
        super.onDestroy();
    }

    private void findVews() {
        city = findViewById(R.id.cityName);
        imageWeather = findViewById(R.id.weatherIcon);
        temperature = findViewById(R.id.temperature);

    }

    private void refreshWeatherData() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Location currentBestLocation = getLastBestLocation();
            if (currentBestLocation != null) {
                mLatityde = currentBestLocation.getLatitude();
                mLongitude = currentBestLocation.getLongitude();
            }
            refreshWeather("Kiev", mLatityde, mLongitude);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
        }


    }

    private Location getLastBestLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        } else {
            Location locationGPS = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location locationNet = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            long GPSLocationTime = 0;
            if (null != locationGPS) {
                GPSLocationTime = locationGPS.getTime();
            }
            long NetLocationTime = 0;
            if (null != locationNet) {
                NetLocationTime = locationNet.getTime();
            }
            if (0 < GPSLocationTime - NetLocationTime) {
                return locationGPS;
            } else {
                return locationNet;
            }
        }
    }

    @Override
    public void refreshWeather(String city, double latityde, double longitude) {
        Log.d("TESTTTT", city);
        mLatityde = latityde;
        mLongitude = longitude;
        mCity = city;
    }


    public void getWeather(View v) {
        weatherPresenter.getWeather(mLatityde, mLongitude);

    }

    public int convertDPtoPX(int dp, Context ctx) {
        float density = ctx.getResources().getDisplayMetrics().density;
        return (int) (dp * density);
    }


    @Override
    public void setCityNameToUI(String cityName) {
        this.city.setText(cityName);
    }


    @Override
    public void setTemperatureToUI(String temperature) {
        this.temperature.setText(temperature);
    }
}

package com.example.remote.myapplication.app;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationListener implements android.location.LocationListener {

    private Context mContext;
    private WhenLocationReadyCallback mWhenLocationReadyCallback;

    LocationListener(Context context, WhenLocationReadyCallback mWhenLocationReadyCallback) {
        this.mContext = context;
        this.mWhenLocationReadyCallback = mWhenLocationReadyCallback;
    }

    @Override
    public void onLocationChanged(Location loc) {

        double longitude = loc.getLongitude();
        Log.v("TAG", "longitude " + longitude);

        double latitude = +loc.getLatitude();
        Log.v("TAG", "latitude " + latitude);

        /*------- To get city name from coordinates -------- */
        String cityName = getCityNameFromCoordinates(loc);


        mWhenLocationReadyCallback.refreshWeather(cityName, loc.getLongitude(), loc.getLatitude());

    }

    private String getCityNameFromCoordinates(Location loc) {

        String cityName = "";

        Geocoder gcd = new Geocoder(mContext, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                    loc.getLongitude(), 1);

            if (addresses.size() > 0) {
                System.out.println(addresses.get(0).getLocality());
                cityName = addresses.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityName;
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

}

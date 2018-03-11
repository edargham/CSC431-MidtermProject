package com.example.edargham.restoview;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final int LOCATION_PERMISSION = 1;
    private final String TAG = "MainActivity";

    private Double lat, lon;
    private ZomatoApiManager zam;

    private Gson gson = new Gson();

    private Res res = new Res();
    RecyclerView rc;

    private LocationManager lm;
    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.d(TAG, "LOCATION CHANGED");
            lat = location.getLatitude();
            lon = location.getLongitude();

            lm.removeUpdates(listener);

            Log.d(TAG, "Hello, World!");
            zam.getRestaurantsAtLocation(lat,lon).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d(TAG, "Fail");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.d(TAG, "Request Reached!");
                    if(response.isSuccessful()){
                        Log.d(TAG, "Success");
                        String json = response.body().string();
                        res = gson.fromJson(json, Res.class);
                        Log.d(TAG, "Error!!!");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                RestoAdapter ra = new RestoAdapter(getApplicationContext(), res.getNearby_restaurants());
                                rc.setAdapter(ra);
                            }
                        });

                    }else{
                     Log.d(TAG, "ERROR, IN RESPONSE, CHECK WITH API PROVIDER!");
                    }
                }
            });
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zam = new ZomatoApiManager();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_DENIED) {
            requestFineLocationPermission();
        } else {
            startLocationManager();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startLocationManager();
        }
    }

    @SuppressLint("MissingPermission")
    private void startLocationManager() {
        Log.d(TAG, "Starting Location Manager.");

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Log.d(TAG, "Got Activity");
        rc = findViewById(R.id.recycle);
        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Log.d(TAG, "Initailized Recycler View");
        lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
        Log.d(TAG,"UPDATING LOCATION");
    }

    private void requestFineLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        }, LOCATION_PERMISSION);
    }

}

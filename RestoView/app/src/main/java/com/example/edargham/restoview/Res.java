package com.example.edargham.restoview;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class Res {

    @SerializedName("nearby_restaurants")
    private ArrayList<Restaurant> nearby_restaurants;

    public Res(){
        nearby_restaurants = new ArrayList<>();
    }

    public ArrayList<Restaurant> getNearby_restaurants() {
        return nearby_restaurants;
    }

    public void setNearby_restaurants(ArrayList<Restaurant> nearby_restaurants) {
        this.nearby_restaurants = nearby_restaurants;
    }
}

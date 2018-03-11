package com.example.edargham.restoview;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class Res {

    @SerializedName("nearby_restaurants")
    private List<Container> nearby_restaurants;


    public List<Container> getNearby_restaurants() {
        return nearby_restaurants;
    }

}

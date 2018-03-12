package com.example.edargham.restoview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class Container implements Serializable {

    @SerializedName("restaurant")
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }
}

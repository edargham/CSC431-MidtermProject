package com.example.edargham.restoview;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class Restaurant {

    @SerializedName("name")
    private String name;
    @SerializedName("cuisines")
    private String cuisine;
    @SerializedName("thumb")
    private String imgUrl;
    private UserRating user_rating;
    private Location location;

    public Restaurant(String Name, String Cuisine, String thumb, String average_rating, String rating_text,
                      String address, String locality, String city){

        name = Name;
        cuisine = Cuisine;
        imgUrl = thumb;
        user_rating = new UserRating(average_rating, rating_text);
        location = new Location(address, locality, city);


    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUurl) {
        this.imgUrl = imgUurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(UserRating user_rating) {
        this.user_rating = user_rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

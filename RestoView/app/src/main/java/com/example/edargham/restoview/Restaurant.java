package com.example.edargham.restoview;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class Restaurant {

    private String name;
    private String cuisine;
    private UserRating user_rating;

    public Restaurant(String Name, String Cuisine, String average_rating, String rating_text){

        name = Name;
        cuisine = Cuisine;
        user_rating = new UserRating(average_rating, rating_text);

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
}

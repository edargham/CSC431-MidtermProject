package com.example.edargham.restoview;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class UserRating {

    private String average_rating;
    private String rating_text;

    public UserRating(String ar, String rt){
        average_rating = ar;
        rating_text = rt;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public String getAverage_rating() {

        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }
}

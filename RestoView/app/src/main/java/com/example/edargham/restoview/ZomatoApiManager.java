package com.example.edargham.restoview;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.http.HTTP;

/**
 * Created by eliasdargham on 3/11/18.
 */

public class ZomatoApiManager {

    private OkHttpClient client;

    public ZomatoApiManager(){
        client = new OkHttpClient();
    }

    public Call getRestaurantsAtLocation(double latitude, double longtitude){
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("developers.zomato.com")
                .addPathSegment("api")
                .addPathSegment("v2.1")
                .addPathSegment("geocode")
                .addQueryParameter("lat", String.valueOf(latitude))
                .addQueryParameter("lon", String.valueOf(longtitude))
                .addQueryParameter("user-key", "1790d789c593b2e68c6fd677fcfdd501")
                .build();

        Request req = new Request.Builder()
                .url(url)
                .build();

        return client.newCall(req);
    }
}

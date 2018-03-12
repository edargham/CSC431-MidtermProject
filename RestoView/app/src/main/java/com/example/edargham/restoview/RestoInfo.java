package com.example.edargham.restoview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.edargham.restoview.utils.CircleTransform;
import com.squareup.picasso.Picasso;

public class RestoInfo extends AppCompatActivity {

    View.OnClickListener ocls = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resto_info);

        Res data = (Res)getIntent().getSerializableExtra("Restos");
        int position = (int)getIntent().getSerializableExtra("Position");

        Button backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(ocls);

        TextView rname = findViewById(R.id.rname);
        rname.setText(data
                        .getNearby_restaurants()
                        .get(position)
                        .getRestaurant()
                        .getName());

        TextView rcuisine = findViewById(R.id.rcuisine);
        rcuisine.setText(data
                            .getNearby_restaurants()
                            .get(position)
                            .getRestaurant()
                            .getCuisine());

        TextView rate = findViewById(R.id.rate);
        rate.setText(data
                        .getNearby_restaurants()
                        .get(position)
                        .getRestaurant()
                        .getUser_rating()
                        .getAverage_rating());

        TextView txtrate = findViewById(R.id.txtrate);
        txtrate.setText(data
                            .getNearby_restaurants()
                            .get(position)
                            .getRestaurant()
                            .getUser_rating()
                            .getRating_text());

        TextView address = findViewById(R.id.address);
        address.setText(data
                .getNearby_restaurants()
                .get(position)
                .getRestaurant()
                .getLocation()
                .getAddress());

        TextView locale = findViewById(R.id.locale);
        locale.setText(data
                .getNearby_restaurants()
                .get(position)
                .getRestaurant()
                .getLocation()
                .getLocality());

        TextView city = findViewById(R.id.city);
        city.setText(data
                .getNearby_restaurants()
                .get(position)
                .getRestaurant()
                .getLocation()
                .getCity());

        RatingBar ratingBar = findViewById(R.id.ratingBar);

        float rating = Float.parseFloat(data
                .getNearby_restaurants()
                .get(position)
                .getRestaurant()
                .getUser_rating()
                .getAverage_rating());

        ratingBar.setRating(rating);
        ratingBar.setIsIndicator(true);

        ImageView imageView = findViewById(R.id.restoicn);
        Picasso
                .with(this)
                .load(data.getNearby_restaurants().get(position).getRestaurant().getImgUrl())
                .transform(new CircleTransform())
                .into(imageView);
    }
}

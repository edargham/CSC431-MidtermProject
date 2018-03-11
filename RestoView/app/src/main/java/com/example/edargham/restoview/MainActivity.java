package com.example.edargham.restoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rc = findViewById(R.id.recycle);
        rc.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Restaurant> restos = new ArrayList<>();

        RestoAdapter ra = new RestoAdapter(getApplicationContext(), restos);
        rc.setAdapter(ra);
    }
}

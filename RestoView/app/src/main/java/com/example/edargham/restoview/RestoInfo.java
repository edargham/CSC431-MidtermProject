package com.example.edargham.restoview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(ocls);
    }
}

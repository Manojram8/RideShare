package com.example.rideshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Button postRideButton;
    private Button searchRidesButton;
    private Button profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        postRideButton = findViewById(R.id.postRideButton);
        searchRidesButton = findViewById(R.id.searchRidesButton);
        profileButton = findViewById(R.id.doneButton);

        postRideButton.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, PostRideActivity.class));
        });

        searchRidesButton.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, SearchRidesActivity.class));
        });

        profileButton.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
        });
    }
}

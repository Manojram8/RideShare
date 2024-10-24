package com.example.rideshare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Button postRideButton;
    private Button searchRidesButton;
    private Button profileButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        initializeViews();

        // Set up button click listeners
        setupButtonListeners();
    }

    private void initializeViews() {
        postRideButton = findViewById(R.id.postRideButton);
        searchRidesButton = findViewById(R.id.searchRidesButton);
        profileButton = findViewById(R.id.profileButton); // Make sure this is initialized properly
    }

    private void setupButtonListeners() {
        postRideButton.setOnClickListener(v -> {
            // Navigate to PostRideActivity
            startActivity(new Intent(DashboardActivity.this, PostRideActivity.class));
        });

        searchRidesButton.setOnClickListener(v -> {
            // Navigate to SearchRidesActivity
            startActivity(new Intent(DashboardActivity.this, SearchRidesActivity.class));
        });

        profileButton.setOnClickListener(v -> {
            // Navigate to ProfileActivity
            startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
        });
    }
}

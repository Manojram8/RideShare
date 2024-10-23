package com.example.rideshare;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RideDetailsActivity extends AppCompatActivity {

    private TextView rideDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_details);

        rideDetailsTextView = findViewById(R.id.emailTextView);

        // Assuming ride details are passed via Intent
        String rideDetails = getIntent().getStringExtra("RIDE_DETAILS");
        rideDetailsTextView.setText(rideDetails);
    }
}

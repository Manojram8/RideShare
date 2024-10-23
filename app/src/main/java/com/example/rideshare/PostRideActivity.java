package com.example.rideshare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class PostRideActivity extends AppCompatActivity {

    private EditText pickupLocationEditText, dropOffLocationEditText, availableSeatsEditText, departureTimeEditText;
    private Button postRideButton;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ride);

        pickupLocationEditText = findViewById(R.id.pickupLocationEditText);
        dropOffLocationEditText = findViewById(R.id.dropOffLocationEditText);
        availableSeatsEditText = findViewById(R.id.availableSeatsEditText);
        departureTimeEditText = findViewById(R.id.departureTimeEditText);
        postRideButton = findViewById(R.id.postRideButton);

        firestore = FirebaseFirestore.getInstance();

        postRideButton.setOnClickListener(v -> postRide());
    }

    private void postRide() {
        String pickupLocation = pickupLocationEditText.getText().toString();
        String dropOffLocation = dropOffLocationEditText.getText().toString();
        String availableSeats = availableSeatsEditText.getText().toString();
        String departureTime = departureTimeEditText.getText().toString();

        Ride ride = new Ride(pickupLocation, dropOffLocation, availableSeats, departureTime);
        firestore.collection("rides").add(ride)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(PostRideActivity.this, "Ride posted successfully.", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(PostRideActivity.this, "Error posting ride.", Toast.LENGTH_SHORT).show();
                });
    }
}

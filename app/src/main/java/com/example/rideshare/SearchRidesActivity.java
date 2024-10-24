package com.example.rideshare;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SearchRidesActivity extends AppCompatActivity {

    private ListView ridesListView;
    private FirebaseFirestore firestore;
    private ArrayList<Ride> ridesList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_rides);

        ridesListView = findViewById(R.id.ridesListView);
        firestore = FirebaseFirestore.getInstance();
        ridesList = new ArrayList<>();

        fetchRides();
    }

    private void fetchRides() {
        firestore.collection("rides").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Ride ride = document.toObject(Ride.class);
                    ridesList.add(ride);
                }
                RidesAdapter adapter = new RidesAdapter(SearchRidesActivity.this, ridesList);
                ridesListView.setAdapter(adapter);
            }
        });
    }
}

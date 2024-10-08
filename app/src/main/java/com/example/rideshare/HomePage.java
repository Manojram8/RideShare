package com.example.rideshare;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    private EditText fromLocationEditText;
    private EditText toLocationEditText;
    private Button dateTimeButton;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // Initialize UI components
        fromLocationEditText = findViewById(R.id.fromLocationEditText);
        toLocationEditText = findViewById(R.id.toLocationEditText);
        dateTimeButton = findViewById(R.id.dateTimeButton);
        searchButton = findViewById(R.id.searchButton);

        // Set up click listeners
        dateTimeButton.setOnClickListener(v -> showDateTimePicker());
        searchButton.setOnClickListener(v -> searchRide());
    }

    private void showDateTimePicker() {
        // Implement date and time picker dialog
        // Update the dateTimeButton text with selected date and time
    }

    private void searchRide() {
        String fromLocation = fromLocationEditText.getText().toString();
        String toLocation = toLocationEditText.getText().toString();
        String dateTime = dateTimeButton.getText().toString();

        // Implement ride search logic here
        // You might want to start a new activity or show results
    }
}
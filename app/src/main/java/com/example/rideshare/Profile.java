package com.example.rideshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Initialize views
        ImageView profilePhoto = findViewById(R.id.profile_photo);
        TextView nameText = findViewById(R.id.name_text);
        TextView emailText = findViewById(R.id.email_text);
        TextView mobileNumberText = findViewById(R.id.mobile_number_text);
        TextView verificationStatusText = findViewById(R.id.verification_status_text);
        Button signOutButton = findViewById(R.id.sign_out_button);

        // Set user details
        nameText.setText("Name: Kunny");  // Replace with actual user name
        emailText.setText("Email: ko@gmail.com");  // Replace with actual email
        mobileNumberText.setText("Mobile: +1234567890");  // Replace with actual mobile number
        verificationStatusText.setText("Verified: Yes");  // Change to "No" if not verified

        // Handle sign-out button click
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle sign-out logic here
                // For example, you might want to clear user session or token

                // Redirect to login page
                Intent intent = new Intent(Profile.this, MainActivity.class); // Change to your login activity
                startActivity(intent);
                finish(); // Finish the profile activity
            }
        });
    }
}

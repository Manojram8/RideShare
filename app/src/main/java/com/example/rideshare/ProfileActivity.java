package com.example.rideshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameTextView, emailTextView, mobileTextView, verificationTextView;
    private ImageView profilePicImageView;
    private Button signOutButton, editProfileButton;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        mobileTextView = findViewById(R.id.mobileTextView);
        verificationTextView = findViewById(R.id.verifiedTextView);
        signOutButton = findViewById(R.id.signOutButton);
        editProfileButton = findViewById(R.id.editProfileButton);  // New Edit button

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        fetchUserProfile();

        signOutButton.setOnClickListener(v -> {
            auth.signOut();
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            finish();
        });

        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });
    }

    private void fetchUserProfile() {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            emailTextView.setText(user.getEmail());
            firestore.collection("users").document(user.getUid()).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            String name = documentSnapshot.getString("name");
                            String mobile = documentSnapshot.getString("mobile");
                            nameTextView.setText(name);
                            mobileTextView.setText(mobile);
                        }
                    });
        }
    }
}

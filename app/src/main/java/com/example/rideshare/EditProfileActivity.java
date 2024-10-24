package com.example.rideshare;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editNameEditText, editMobileEditText;
    private Button saveButton;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editNameEditText = findViewById(R.id.editNameEditText);
        editMobileEditText = findViewById(R.id.editMobileEditText);
        saveButton = findViewById(R.id.saveButton);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        saveButton.setOnClickListener(v -> saveUserProfile());
    }

    private void saveUserProfile() {
        String name = editNameEditText.getText().toString().trim();
        String mobile = editMobileEditText.getText().toString().trim();

        if (name.isEmpty() || mobile.isEmpty()) {
            Toast.makeText(EditProfileActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            firestore.collection("users").document(user.getUid())
                    .update("name", name, "mobile", mobile)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(EditProfileActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(EditProfileActivity.this, "Failed to update profile", Toast.LENGTH_SHORT).show());
        }
    }
}

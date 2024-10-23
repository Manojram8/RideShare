package com.example.rideshare;

public class User {
    private String name;
    private String email;
    private String mobile;
    private String profilePicUrl;

    public User(String name, String email) {
        // Required empty constructor for Firestore
    }

    public User(String name, String email, String mobile, String profilePicUrl) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.profilePicUrl = profilePicUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }
}

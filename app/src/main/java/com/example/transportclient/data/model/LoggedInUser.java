package com.example.transportclient.data.model;

import androidx.annotation.NonNull;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    public LoggedInUser(@NonNull String userId, @NonNull String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    @NonNull
    public String getDisplayName() {
        return displayName;
    }
}
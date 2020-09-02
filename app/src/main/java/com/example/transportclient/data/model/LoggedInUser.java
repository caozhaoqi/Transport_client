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

    /**
     * Getter for property 'userId'.
     *
     * @return Value for property 'userId'.
     */
    @NonNull
    public String getUserId() {
        return userId;
    }

    /**
     * Getter for property 'displayName'.
     *
     * @return Value for property 'displayName'.
     */
    @NonNull
    public String getDisplayName() {
        return displayName;
    }
}
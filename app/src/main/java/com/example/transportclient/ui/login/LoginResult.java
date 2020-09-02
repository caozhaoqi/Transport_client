package com.example.transportclient.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    /**
     * Getter for property 'success'.
     *
     * @return Value for property 'success'.
     */
    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    /**
     * Getter for property 'error'.
     *
     * @return Value for property 'error'.
     */
    @Nullable
    Integer getError() {
        return error;
    }
}
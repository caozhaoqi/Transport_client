package com.example.transportclient.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer usernameError, @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    /**
     * Getter for property 'usernameError'.
     *
     * @return Value for property 'usernameError'.
     */
    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    /**
     * Getter for property 'passwordError'.
     *
     * @return Value for property 'passwordError'.
     */
    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    /**
     * Getter for property 'dataValid'.
     *
     * @return Value for property 'dataValid'.
     */
    boolean isDataValid() {
        return isDataValid;
    }
}
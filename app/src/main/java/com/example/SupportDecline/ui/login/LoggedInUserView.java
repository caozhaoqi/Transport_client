package com.example.SupportDecline.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Getter for property 'displayName'.
     *
     * @return Value for property 'displayName'.
     */
    String getDisplayName() {
        return displayName;
    }
}
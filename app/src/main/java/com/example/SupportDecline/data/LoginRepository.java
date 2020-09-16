package com.example.SupportDecline.data;

import androidx.annotation.NonNull;

import com.example.SupportDecline.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Gets instance.
     *
     * @param dataSource the data source
     * @return the instance
     */
    @NonNull
    public static LoginRepository getInstance(@NonNull LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    /**
     * Getter for property 'loggedIn'.
     *
     * @return Value for property 'loggedIn'.
     */
    public boolean isLoggedIn() {
        return user != null;
    }

    /**
     * Logout.
     */
    public void logout() {
        user = null;
        dataSource.logout();
    }

    /**
     * Setter for property 'loggedInUser'.
     *
     * @param user Value to set for property 'loggedInUser'.
     */
    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    /**
     * Login result.
     *
     * @param username the username
     * @param password the password
     * @return the result
     */
    @NonNull
    public Result<LoggedInUser> login(@NonNull String username, @NonNull String password) {
        // handle login
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        assert result != null;
        return result;
    }
}
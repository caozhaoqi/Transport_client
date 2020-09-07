package com.example.SupportDecline.data;

import androidx.annotation.NonNull;


/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public class Result<T> {
    /**
     * Constructs a new Result.
     */ // hide the private constructor to limit subclass types (Success, Error)
    public Result() {
    }

    public Result(String result, Object o, Object o1, Object o2) {
    }


    /** {@inheritDoc} */
    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    // Success sub-class
    public final static class Success<T> extends Result {
        private T data;

        public Success(T data) {
            this.data = data;
        }

        /**
         * Getter for property 'data'.
         *
         * @return Value for property 'data'.
         */
        public T getData() {
            return this.data;
        }
    }

    // Error sub-class
    public final static class Error extends Result {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        /**
         * Getter for property 'error'.
         *
         * @return Value for property 'error'.
         */
        @NonNull
        public Exception getError() {
            return this.error;
        }
    }
}
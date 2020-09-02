package com.example.transportclient.ui.dashboard;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    /**
     * Constructs a new DashboardViewModel.
     */
    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    /**
     * Getter for property 'text'.
     *
     * @return Value for property 'text'.
     */
    @NonNull
    public LiveData<String> getText() {
        return mText;
    }
}
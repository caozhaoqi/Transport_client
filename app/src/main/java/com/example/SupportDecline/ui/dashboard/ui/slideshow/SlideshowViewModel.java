package com.example.SupportDecline.ui.dashboard.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    /**
     * Constructs a new SlideshowViewModel.
     */
    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
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
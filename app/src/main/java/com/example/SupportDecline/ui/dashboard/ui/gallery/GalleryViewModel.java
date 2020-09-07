package com.example.SupportDecline.ui.dashboard.ui.gallery;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    /**
     * Constructs a new GalleryViewModel.
     */
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
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
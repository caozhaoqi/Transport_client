package com.example.SupportDecline.ui.main;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
/*

 * **/
public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    /**
     * Setter for property 'index'.
     *
     * @param index Value to set for property 'index'.
     */
    public void setIndex(int index) {
        mIndex.setValue(index);
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
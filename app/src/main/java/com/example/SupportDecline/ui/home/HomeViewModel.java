package com.example.SupportDecline.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
/*
 *
 * 添加快递页面数据
 * */
public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    /**
     * Constructs a new HomeViewModel.
     */
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        //  mText.setValue("This is home fragment");
        //
    }

    /**
     * Getter for property 'text'.
     *
     * @return Value for property 'text'.
     */
    public LiveData<String> getText() {
        return mText;
    }
}
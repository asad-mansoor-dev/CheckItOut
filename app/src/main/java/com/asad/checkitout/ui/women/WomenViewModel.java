package com.asad.checkitout.ui.women;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WomenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WomenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is women fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
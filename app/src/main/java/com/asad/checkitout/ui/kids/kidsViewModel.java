package com.asad.checkitout.ui.kids;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class kidsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public kidsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Kids fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
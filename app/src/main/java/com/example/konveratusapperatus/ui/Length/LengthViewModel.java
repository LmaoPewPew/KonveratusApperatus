package com.example.konveratusapperatus.ui.Length;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LengthViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LengthViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.avvritersmedia.usermodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.avvritersmedia.MainActivity;
import com.example.avvritersmedia.usersdata.UserData;

public class UserDataViewModel extends ViewModel {

private MutableLiveData<UserData> userdata = new MutableLiveData<>();

public LiveData<UserData> getUserData() {
    return userdata;
}

public void setUserData(UserData data) {
    userdata.setValue(data);
}
}


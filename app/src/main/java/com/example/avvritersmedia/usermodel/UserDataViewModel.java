package com.example.avvritersmedia.usermodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.avvritersmedia.MainActivity;
import com.example.avvritersmedia.usersdata.UserData;

public class UserDataViewModel extends ViewModel {

private static MutableLiveData<UserData> userdata = new MutableLiveData<>();

public static LiveData<UserData> getUserData() {
    return userdata;
}

public static void setUserData(UserData data) {
    userdata.setValue(data);
}
}


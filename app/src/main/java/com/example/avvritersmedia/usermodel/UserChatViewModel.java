package com.example.avvritersmedia.usermodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.avvritersmedia.usersdata.UserChat;
import com.example.avvritersmedia.usersdata.UserData;

public class UserChatViewModel extends ViewModel {

    private MutableLiveData<UserChat> userchat = new MutableLiveData<>();

    public LiveData<UserChat> getUserChat() {
        return userchat;
    }

    public void setUserChat(UserChat data) {
        userchat.setValue(data);
    }
}

package com.example.avvritersmedia.usersdata;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.avvritersmedia.MainActivity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserData {
    String userid;
    String username;
    String useremail;
    String password;
    Map<String, Object> dataList;
    Map<String,UserIdea> listOfIdeas;
Map<String,UserChat> listOfChats;

    public UserData(){
        listOfIdeas=new HashMap<>();
        listOfChats=new HashMap<>();
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return useremail;
    }

    public void setUserEmail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
    public void setDataList(@NonNull Map<String,Object> objectMap){
        for(Map.Entry<String,Object> entry: objectMap.entrySet())
        {
            if(entry.getValue()!=null) {
                String value = entry.getValue().toString();
                password = entry.getKey();
                if (entry.getKey().equals("username")) username = entry.getValue().toString();
                if (entry.getKey().equals("email")) useremail = entry.getValue().toString();
                if (entry.getKey().toString().equals("password"))setPassword(entry.getValue().toString());
            }
        }
    }
    public Map<String, Object> getDataList() {
        fillDataList();
        return dataList;
    }
    public void addIdea(String title,String body)
    {
        UserIdea userIdea=new UserIdea(title,body,"idea_"+createUserId());
        listOfIdeas.put(userIdea.getIdeaId(),userIdea);
    }
    public void addToListOfChats(UserChat userChat){

    }

    public Map<String, UserChat> getListOfChats() {
        return listOfChats;
    }

    public Map<String, UserIdea> getListOfIdeas() {
        return listOfIdeas;
    }
    String createUserId()
    {
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }
void fillDataList(){
    dataList=new HashMap<>();
    dataList.put("chat",null);
    dataList.put("ideas",listOfIdeas);
    dataList.put("password",password);
    dataList.put("email",useremail);
    dataList.put("username",username);
}

}

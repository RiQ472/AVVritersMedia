package com.example.avvritersmedia.usersdata;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserIdea {
    String title;
    String body;
    String ideaId;
    Map<String,String> ideaData;
    public UserIdea(String title, String body, String ideaId){
        this.title = title;
        this.body = body;
        this.ideaId = ideaId;
    }

    public String getIdeaId() {
        return ideaId;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    Map<String,String> getIdeaData()
    {
        fillDataList();
        return ideaData;
    }
    void fillDataList(){
        ideaData=new HashMap<>();
        ideaData.put("title",title);
        ideaData.put("body",body);
        ideaData.put("ideaId",ideaId);
    }


}

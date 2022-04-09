package com.ourApi.demo.utils;

import com.ourApi.demo.model.entity.Message;

import java.util.ArrayList;

public class TestUtils {
    public static Message initializeMessage(){
        Message message = new Message();
        message.setTopic("topic1");
        message.setText("text1");
        return  message;
    }

    public static ArrayList<Message> initializeListMessage() {
        ArrayList<Message> listMessage = new ArrayList<>();
        listMessage.add(initializeMessage());
        return listMessage;
    }
}

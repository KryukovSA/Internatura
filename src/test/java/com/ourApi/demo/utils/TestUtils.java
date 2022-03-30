package com.ourApi.demo.utils;

import com.ourApi.demo.model.entity.Message;

public class TestUtils {
    public static Message initializeMessage(){
        Message message = new Message();
        message.setTopic("topic1");
        message.setText("text1");
        return  message;
    }
}

package com.ourApi.demo.utils;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.service.MessageService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProcessingProblemRequests {
    public static ResponseEntity<Message> NullPointerCheck (Message message){
        if(message != null){
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.noContent().build();
    }
    public static ResponseEntity<List<Message>> NullPointerCheck (List<Message> messages){
        if(messages.isEmpty() == false){
            return ResponseEntity.ok(messages);
        }
        return ResponseEntity.noContent().build();
    }

    public static ResponseEntity ValidationInputMessage(Message InputMessage, MessageService messageService){
        if (InputMessage.getTopic() != null & InputMessage.getText() != null) {
            messageService.addMessage(InputMessage);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public static ResponseEntity ValidationDeletedMessage(String topic, MessageService messageService){
        if (messageService.getAllMessage().contains(messageService.getMessage(topic))) {
            messageService.deleteMessage(topic);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

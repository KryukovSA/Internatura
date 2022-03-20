package com.ourApi.demo.service;

import com.ourApi.demo.model.entity.Message;
import com.ourApi.demo.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public ResponseEntity<Message> getMessage(String topic) {
        if(messageRepository.getMessageByTopic(topic) != null){
            return ResponseEntity.ok(messageRepository.getMessageByTopic(topic));
        }
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity deleteMessage(String topic){
        if (messageRepository.findAll().contains(messageRepository.getMessageByTopic(topic))) {
            messageRepository.deleteMessageByTopic(topic);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity addMessage(Message msg) {
        log.info("сообщение " + msg);
        if (msg.getTopic() != null & msg.getText() != null) {
            messageRepository.saveAndFlush(msg);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<List<Message>> getAllMessage(){
        if(messageRepository.findAll().isEmpty() == false){
            return ResponseEntity.ok(messageRepository.findAll());
        }
        return ResponseEntity.noContent().build();
    }
}

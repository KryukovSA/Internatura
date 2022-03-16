package com.ourApi.demo.service;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public Message getMessage(String topic) {
        return messageRepository.getMessageByTopic(topic);
    }

    @Transactional
    public void deleteMessage(String topic){
        messageRepository.deleteMessageByTopic(topic);
    }

    public Message addMessage(Message msg) {
        log.info("сообщение " + msg);
        messageRepository.saveAndFlush(msg);
        return msg;
    }

    public List<Message> getAllMessage(){
        return  messageRepository.findAll();
    }

}

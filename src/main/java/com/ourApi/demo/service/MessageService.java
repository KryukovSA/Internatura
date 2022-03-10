package com.ourApi.demo.service;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    public Message getText(String topic) {
        Message message = messageRepository.getById(topic);
        if(message != null)
            return message;
        else //например верну мессаже с нулями
            return messageRepository.getById(topic);
    }

    public Message addMessage(Message msg) {
        log.info("сообщение " + msg);
        messageRepository.saveAndFlush(msg);
        return msg;
    }



}

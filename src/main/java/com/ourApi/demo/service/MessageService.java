package com.ourApi.demo.service;

import com.ourApi.demo.model.entity.Message;
import com.ourApi.demo.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public Message getMessage(String topic) throws NullPointerException {
        Message message = messageRepository.getMessageByTopic(topic);
        if(message != null){
            return message;
        }
        throw new NullPointerException();
    }

    @Transactional
    public void deleteMessage(String topic) throws NullPointerException{
        if (messageRepository.findAll().contains(messageRepository.getMessageByTopic(topic))) {
            messageRepository.deleteMessageByTopic(topic);
        } else {
            throw new NullPointerException();
        }
    }

    public void addMessage(Message msg) throws IllegalArgumentException {
        log.info("сообщение " + msg);
        if (msg.getTopic() != null & msg.getText() != null) {
            msg.setCreatedDataTime(new Date());
            messageRepository.saveAndFlush(msg);
        } else {
            throw new IllegalArgumentException("некорректный ввод");
        }
    }

    public List<Message> getAllMessages() throws NullPointerException{
        if(!messageRepository.findAll().isEmpty()){
            return messageRepository.findAll();
        }
        throw new NullPointerException();
    }
}

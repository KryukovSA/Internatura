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

    public Message getMsg(String topic) {
        Message message = messageRepository.getMessageByTopic(topic);
        if(message != null)
            return message;
        message = new Message(null, "NoData");
        return message;
    }

    @Transactional
    public void deleteMsg(String topic){
        messageRepository.deleteMessageByTopic(topic);
    }

    public Message addMsg(Message msg) {
        log.info("сообщение " + msg);
        messageRepository.saveAndFlush(msg);
        return msg;
    }

    public List<Message> getAllMsg(){
        return  messageRepository.findAll();
    }
}

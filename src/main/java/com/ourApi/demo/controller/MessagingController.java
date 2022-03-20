package com.ourApi.demo.controller;

import com.ourApi.demo.model.entity.Message;
import com.ourApi.demo.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/request/Info")
@AllArgsConstructor
@Slf4j
public class MessagingController {

    private final MessageService messageService;

    @GetMapping(params = {"topic"})
    public ResponseEntity<Message> getMessage(@RequestParam final String topic) {
        log.info("GET info by topic: " + topic);
        return messageService.getMessage(topic);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        log.info("GET all info");
        return messageService.getAllMessage();
    }

    @PostMapping
    public ResponseEntity addMessage(@RequestBody Message message) {
        log.info("POST info " + message);
        return messageService.addMessage(message);
    }

    @DeleteMapping
    public ResponseEntity deleteMessage(@RequestBody final String topic) {
        log.info("DELETE info by key " + topic);
        return messageService.deleteMessage(topic);
    }
}



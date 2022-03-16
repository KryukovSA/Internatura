package com.ourApi.demo.controller;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ourApi.demo.utils.ProcessingProblemRequests.*;

@RestController
@RequestMapping(path = "/request/Info")
@AllArgsConstructor
@Slf4j
public class MessagingController {

    private final MessageService messageService;

    @GetMapping(params = {"topic"})
    public ResponseEntity<Message> getMessage(@RequestParam final String topic) {
        log.info("GET info by topic: " + topic);
        Message message = messageService.getMessage(topic);
        return NullPointerCheck(message);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        log.info("GET all info");
        return NullPointerCheck(messageService.getAllMessage());
    }

    @PostMapping
    public ResponseEntity addMessage(@RequestBody Message message) {
        log.info("POST info " + message);
        return ValidationInputMessage(message, messageService);
    }

    @DeleteMapping
    public ResponseEntity deleteMessage(@RequestBody final String topic) {
        log.info("DELETE info by key " + topic);
        return ValidationDeletedMessage(topic, messageService);
    }
}



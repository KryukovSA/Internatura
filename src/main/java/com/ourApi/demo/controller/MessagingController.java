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
        log.info("GET info by topic:" + topic);
        try {
            messageService.getMessage(topic);
            return ResponseEntity.ok(messageService.getMessage(topic));
        } catch (NullPointerException e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        log.info("GET all info");
        try {
            return ResponseEntity.ok(messageService.getAllMessages());
        } catch (NullPointerException e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        log.info("POST info " + message);
        try {
            messageService.addMessage(message);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Message> deleteMessage(@RequestBody final String topic) {
        log.info("DELETE info by key " + topic);
        try {
            messageService.deleteMessage(topic);
            return ResponseEntity.ok().build();
        } catch (NullPointerException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}



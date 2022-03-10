package com.ourApi.demo.controller;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/request/Info")
@AllArgsConstructor
@Slf4j
public class MessagingController {

    private final MessageService messageService;

    @GetMapping(params = {"key"})
    public Message getData(@RequestParam final String key) {
        log.info("GET info by key: " + key);
        return messageService.getMsg(key);
    }

    @GetMapping
    public List<Message> getAllData() {
        log.info("GET all info");
        return messageService.getAllMsg();
    }

    @PostMapping
    public void addData(@RequestBody Message message) {
        log.info("POST info " + message);
        messageService.addMsg(message);
    }

    @DeleteMapping
    public void deleteData(@RequestBody final String key) {
        log.info("DELETE info by key " + key);
        messageService.deleteMsg(key);
    }
}



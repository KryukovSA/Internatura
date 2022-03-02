package com.ourApi.demo.controller;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.repository.MessageSomeDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/request/Info")
@AllArgsConstructor
@Slf4j
public class MessagingController {

    public MessageSomeDataRepository dataRepository;

    @GetMapping(params = {"key"})
    public String getData(@RequestParam final String key) {
        log.info("GET info by key: " + key);
        return dataRepository.getInfoByKey(key);
    }

    @PostMapping
    public void addData(@RequestBody Message message) {
        log.info("POST info " + message);
        dataRepository.addInHashMap(message.getTopic(), message.getText());
    }

    @DeleteMapping
    public void deleteData(@RequestBody final String key) {
        log.info("DELETE info by key " + key);
        dataRepository.deleteFromHashMap(key);
    }
}



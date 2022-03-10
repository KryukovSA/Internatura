package com.ourApi.demo.controller;

import com.ourApi.demo.model.Message;
import com.ourApi.demo.repository.MessageRepository;
import com.ourApi.demo.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/request/Info")
@AllArgsConstructor
@Slf4j
public class MessagingController {

    private final MessageService messageService;

    @GetMapping(params = {"key"})
    public Message getData(@RequestParam final String key) {
        log.info("GET info by key: " + key);
        return messageService.getText(key);
    }

    //сделать еще гет который все записи из таблицы печетеет все message напрмер в лист объеденить

    @PostMapping
    public void addData(@RequestBody Message message) {
        log.info("POST info " + message);
        messageService.addMessage(message);
        //dataRepository.addInHashMap(message.getTopic(), message.getText());
    }

    /*@DeleteMapping
    public void deleteData(@RequestBody final String key) {
        log.info("DELETE info by key " + key);
        dataRepository.deleteFromHashMap(key);
    }*/
}



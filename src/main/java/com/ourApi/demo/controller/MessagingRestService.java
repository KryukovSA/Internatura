package com.ourApi.demo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ourApi.demo.Message;
import com.ourApi.demo.repozitory.SomeDataRepozitory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/request")
@AllArgsConstructor
public class MessagingRestService {

    public SomeDataRepozitory dataRepozitory;

    @GetMapping(
            path = "/Info")
    public String getMessage(
            @RequestBody final String key) {
        return dataRepozitory.getHashMap(key);
    }

    @PostMapping(
            path = "/Info")
    public void addData(
            @RequestBody ObjectNode objectNode) {
        String key = objectNode.get("str1").asText();
        String value = objectNode.get("str2").asText();
        dataRepozitory.addInHashMap(key, value);
    }

    @DeleteMapping(
            path = "/Info"
    )
    public void delData(
            @RequestBody final String key) {
      dataRepozitory.deleteFromHashMap(key);
    }
}



package com.ourApi.demo.repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Repository
public class MessageSomeDataRepository {
    public Map<String, String> hashMap;

    public MessageSomeDataRepository(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @PostConstruct
    private void initializeMap(){
        this.hashMap.put("0", "ноль");
        this.hashMap.put("1", "один");
        this.hashMap.put("2", "два");
    }


    public void addInHashMap(String key, String value) {
        log.info("add data: " + key + ":" + value);
        hashMap.put(key, value);
    }

    public String getInfoByKey(String key) {
        if(this.hashMap.get(key) == null) {
            log.info("no key data: " + key);
            return "such key does not exist";
        }
        else
            return hashMap.get(key);
    }

    public void deleteFromHashMap(String key) {
        if (this.hashMap.get(key) == null) {
            log.info("such key does not exist: " + key);
        } else {
            log.info("delete key data: " + key);
            this.hashMap.remove(key);
        }
    }
}

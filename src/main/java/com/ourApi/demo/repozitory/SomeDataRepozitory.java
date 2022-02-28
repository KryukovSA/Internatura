package com.ourApi.demo.repozitory;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SomeDataRepozitory {
    public Map<String, String> hashMap;

    public void addInHashMap(String key, String value) {
        hashMap.put(key, value);
    }

    public String getHashMap(String key) {
        try {

        } catch () {}

        return hashMap.get(key);
    }

    public SomeDataRepozitory(Map<String, String> hashMap) {
        hashMap.put("0", "ноль");
        hashMap.put("1", "один");
        this.hashMap = hashMap;
    }

    public void deleteFromHashMap(String key) {
        this.hashMap.remove(key);
    }

}

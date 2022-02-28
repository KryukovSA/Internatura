package com.ourApi.demo.repozitory;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class SomeDataRepozitory {
    public Map<String, String> hashMap;

    public SomeDataRepozitory(Map<String, String> hashMap) {
        hashMap.put("0", "ноль");
        hashMap.put("1", "один");
        hashMap.put("2", "два");
        this.hashMap = hashMap;
    }

    public void addInHashMap(String key, String value) {
        hashMap.put(key, value);
    }

    public String getHashMap(String key) {
       try {
            if(this.hashMap.get(key) == null)
                throw new NullPointerException("Exception: val is null!");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception was processed. Program continues");
        }
        return hashMap.get(key);
    }

    public void deleteFromHashMap(String key) {
        try {
            if(this.hashMap.get(key) == null)
                throw new NullPointerException("Exception: val is null!");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception was processed. Program continues");
        }
        this.hashMap.remove(key);
    }
}

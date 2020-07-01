package com.gx.lru;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(5);
        lruCache.put(1, "1");
        lruCache.put(2, "2");
        lruCache.put(3, "3");
        lruCache.put(4, "4");
        lruCache.put(5, "5");
        String s1 = lruCache.get(1);

        lruCache.put(6, "6");

        Set<Map.Entry<Integer, String>> entries = lruCache.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println("key:" + key + "  value:" + value);
        }

        System.out.println("---------------------------------");




    }
}

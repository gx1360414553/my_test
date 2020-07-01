package com.gx.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExecutionException {
//        LoadingCache<String, Person> loadingCache = CacheBuilder.newBuilder().concurrencyLevel(10).expireAfterWrite(200, TimeUnit.SECONDS).build(new CacheLoader<String, Person>() {
//            @Override
//            public Person load(String s) throws Exception {
//                return new Person(s, 15);
//            }
//        });
//        loadingCache.put("one", new Person("李四",20));
//        Person person1 = loadingCache.get("one");
//        Person person = loadingCache.get("张三");
//        System.out.println("person = " + person);
//        System.out.println("person = " + person1);

        String format = String.format("%02d", 1);
        System.out.println("format = " + format);

        String s = "123456";
        int i = Integer.parseInt(s, 16);
        System.out.println("i = " + i);


    }
}

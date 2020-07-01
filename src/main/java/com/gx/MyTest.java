package com.gx;

import com.gx.single.Singleton;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public class MyTest {
    public static void main(String[] args) {
        try {

            Class<?> aClass = Class.forName("com.gx.single.Singleton");
            Field[] declaredFields = aClass.getDeclaredFields();

            Constructor<?> constructor = aClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Singleton singleton1 = (Singleton) constructor.newInstance();
            System.out.println("singleton1 = " + singleton1);
            for (Field field : declaredFields) {
                if("flag".equals(field.getName())){
                    field.setAccessible(true);
                    field.setBoolean(singleton1,true);
                }
            }
            Singleton singleton2 = (Singleton) constructor.newInstance();
            System.out.println("singleton2 = " + singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1(){
        Optional<String> optional = Optional.of(null);
        Object o = optional.get();
        System.out.println("o = " + o);
    }
}

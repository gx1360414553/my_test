package com.gx.help;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "张三", 15);
        Student student2 = new Student(2, "李三", 16);

//        Teacher teacher = new Teacher();
//        teacher.setAge(1);
//        teacher.setId(1);
//        teacher.setName("李四");
//        teacher.setStudent(student);
//
//        String jsonString = JSON.toJSONString(teacher);
//        System.out.println("jsonString = " + jsonString);
//        JSONObject jsonObject = JSON.parseObject(jsonString);
//        String name = jsonObject.getString("name");
//        System.out.println("name = " + name);
//        System.out.println("jsonObject = " + jsonObject);

        Student [] students = {student1, student2};
        Map<String, Student []> map = new HashMap<>();
        map.put("student",students);
        String jsonString = JSON.toJSONString(map);
        System.out.println("jsonString = " + jsonString);

        JSONObject jsonObject = JSON.parseObject(jsonString);

        System.out.println("jsonObject = " + jsonObject);
    }
}

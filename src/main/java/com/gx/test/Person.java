package com.gx.test;

public class Person extends Child{

    public void eat(){
//        System.out.println("Person..............eat");
        super.eat();
    }

    public void sleep(){
        System.out.println("Person..............sleep");
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.eat();
    }

}

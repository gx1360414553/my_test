package com.gx.classloader;

public class ClassLoadTest {
    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
    }
}

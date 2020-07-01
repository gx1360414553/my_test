package com.gx.single;

public class Singleton {
    private static Singleton instance;
    private static boolean flag = true;
    private Singleton() {
        System.out.println("flag = " + flag);
        if(flag){
            flag = !flag;
        }else {
            throw new RuntimeException("破坏单利");
        }
    }

    public static Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

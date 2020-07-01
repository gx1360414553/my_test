package com.gx.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ParkTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();

        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

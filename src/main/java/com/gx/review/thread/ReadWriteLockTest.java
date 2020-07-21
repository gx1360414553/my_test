package com.gx.review.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        Map<String, String> map = new HashMap<>();

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1);
                    writeLock.lock();
                    System.out.println("上写锁。。。。。。。。。。。。。。");
                    map.put(i + "", i + "");
                    System.out.println("释放写锁。。。。。。。。。。。。。。");
                    writeLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    readLock.lock();
                    System.out.println("上读锁。。。。。。。。。。。。。。");
                    String s = map.get(i);
                    System.out.println("s = " + s);
                    System.out.println("释放读锁。。。。。。。。。。。。。。");
                    readLock.unlock();
                }
        });

        thread1.start();
        thread2.start();


    }
}

package com.gx.sync;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
//        try {
//            condition.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("12345646879");
//        condition.signal();
        lock.unlock();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        readLock.unlock();

        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        writeLock.unlock();

        Semaphore semaphore = new Semaphore(3);


        ExecutorService pools = Executors.newCachedThreadPool();

        for (int i=0 ; i < 2;i++){
            final int index = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(String.format("[Thread-%s]任务id --- %s--%s",Thread.currentThread().getId(),index, LocalDateTime.now()));
                        TimeUnit.SECONDS.sleep(2);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //使用完成释放锁
                        semaphore.release();
                        System.out.println("锁释放");
                    }
                }
            };
            pools.execute(run);
        }
        pools.shutdown();

    }
}

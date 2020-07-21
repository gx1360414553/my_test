package com.gx.review.thread;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "21321321");
                return thread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        new ThreadPoolExecutor.AbortPolicy();
        new ThreadPoolExecutor.DiscardOldestPolicy();
        new ThreadPoolExecutor.CallerRunsPolicy();
    }
}

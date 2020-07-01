package com.gx.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    private static Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadFactory build = new ThreadFactoryBuilder().setUncaughtExceptionHandler((thread, throwable) -> logger.error("ThreadPool {} got execption", thread, throwable)).build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2), build, new ThreadPoolExecutor.DiscardOldestPolicy());
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1 ;
            }
        });
        priorityQueue.add(5);
        priorityQueue.add(9);
        priorityQueue.add(91);

        Integer peek1 = priorityQueue.poll();
        Integer peek2 = priorityQueue.poll();
        Integer peek3 = priorityQueue.poll();
        System.out.println("peek1 = " + peek1);
        System.out.println("peek2 = " + peek2);
        System.out.println("peek3 = " + peek3);
        Integer poll = priorityQueue.poll();
        System.out.println("poll = " + poll);


        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 100 ; i++) {
            Future<String> submit = threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println("name = " + name);
//                    Thread.sleep(500);
                        return name;
                    } catch (Exception e) {

                    }finally {

                    }
                    return "";
                }
            });
            futures.add(submit);
        }

        System.out.println("--------------------------------------------");

        for (Future<String> future : futures) {
            System.out.println("future = " + future.get(500, TimeUnit.SECONDS));
        }
        threadPoolExecutor.shutdown();
    }
    
}

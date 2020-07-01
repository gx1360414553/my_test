package com.gx.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("ThreadId:" + Thread.currentThread().getId());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("ThreadId:" + Thread.currentThread().getId());
            int i = 1/0;
            return 100;
        });
        future.join();
//        future.get();
    }
}

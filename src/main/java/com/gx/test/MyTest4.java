package com.gx.test;

import org.apache.commons.lang3.time.StopWatch;

public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
       sw.start();
       Thread.sleep(1000);
       sw.stop();

        System.out.println(sw.getTime());
        System.out.println(sw.getNanoTime());
        System.out.println(System.currentTimeMillis());
//        System.out.println(sw.getSplitNanoTime());
//        System.out.println(sw.getSplitTime());
        System.out.println(sw.getStartTime());
        sw.reset();
       sw.start();
       Thread.sleep(2000);
       sw.stop();

        System.out.println(sw.getTime());
        sw.reset();
        sw.start();
        Thread.sleep(1000);
        sw.stop();

        System.out.println(sw.getTime());
    }
}

package com.gx.thread;

public class PrintNum implements Runnable {

    private static final Object LOCK = new Object();
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;
    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;
    /**
     * 线程数量
     */
    private int threadCount;
    /**
     * 打印的最大数值
     */
    private int maxInt;

    public PrintNum(int threadNo, int threadCount, int maxInt) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.maxInt = maxInt;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LOCK) {
                // 判断是否轮到当前线程执行
                while (current % threadCount == threadNo) {
                    if (current > maxInt) {
                        return;
                    }
                    System.out.println("thread" + threadNo + " : " + current);
                    current++;
                    LOCK.notifyAll();
                }
                try {
                    // 如果不是，则当前线程进入wait
                    LOCK.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        int max = 100;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new PrintNum(i, threadCount, max)).start();
        }
    }
}

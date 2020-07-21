package com.gx.review.queue;

import java.util.PriorityQueue;
import java.util.concurrent.*;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
//        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
//        concurrentLinkedQueue.add("zhangsan");
//        concurrentLinkedQueue.offer("lisi");
//        concurrentLinkedQueue.poll();
//        concurrentLinkedQueue.peek();
//        System.out.println(concurrentLinkedQueue.size());
//        System.out.println("==========================================");
//        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
//        arrayBlockingQueue.add("123");
//        String poll = arrayBlockingQueue.poll();
//        System.out.println("poll = " + poll);
//        String peek = arrayBlockingQueue.peek();
//        System.out.println("peek = " + peek);
//        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
//        linkedBlockingQueue.add("123");
//        linkedBlockingQueue.poll();
//        linkedBlockingQueue.poll(5, TimeUnit.SECONDS);
//
//
//        PriorityQueue<Student> students = new PriorityQueue<>();
//        students.add(new Student(8));
//        students.add(new Student(3));
//        students.add(new Student(5));
//        System.out.println(students.poll());
//        System.out.println(students.poll());
//        System.out.println(students.poll());

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        synchronousQueue.add("1");
//        synchronousQueue.add("2");
        System.out.println(synchronousQueue.poll());


    }
}

package com.gx.review.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();

        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<Integer>(1, 1);
        Integer reference = integerAtomicStampedReference.getReference();
        int stamp = integerAtomicStampedReference.getStamp();
        boolean b = integerAtomicStampedReference.compareAndSet(reference, 2, stamp, stamp + 1);

        Integer reference1 = integerAtomicStampedReference.getReference();
        int stamp1 = integerAtomicStampedReference.getStamp();
        System.out.println(reference1 + ":" + stamp1);
    }
}

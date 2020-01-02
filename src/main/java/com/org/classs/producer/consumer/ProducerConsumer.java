package com.org.classs.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY=5;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Thread producer1 = new Producer("P-1",queue,CAPACITY);
        Thread producer2 = new Producer("P-2",queue,CAPACITY);
        Thread consumer1 = new Consumer("C1",queue,CAPACITY);
        Thread consumer2 = new Consumer("C2",queue,CAPACITY);
        Thread consumer3 = new Consumer("C3",queue,CAPACITY);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

}

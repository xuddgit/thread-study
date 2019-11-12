/*
 *company:jlc
 *author:xudd
 *date:2019/11/12:10:00
 *desc:{}
 **/


package com.org.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:xudd
 * @date:2019/11/12 -10:00
 * @desc:
 **/
public class ProducerConsumer1 {

    public static final Integer MAXSIZE=10;

    private static Queue<String> queue = new LinkedList<>();

    private static final Lock lock = new ReentrantLock();

    private static final  Condition condition=lock.newCondition();

    public static void main(String[] args) {

         Producer1 producer1= new Producer1(lock,queue,condition);

         Consumer1 consumer1= new Consumer1(lock,queue,condition);

         Thread t1 = new Thread(producer1);
                t1.start();
         Thread t2 =new Thread(consumer1);
                t2.start();
    }
}

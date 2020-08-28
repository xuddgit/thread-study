/*
 *company:jlc
 *author:xudd
 *date:2020/4/26:15:03
 *desc:{}
 **/


package com.org.juc.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:xudd
 * @date:2020/4/26 -15:03
 * @desc:
 **/
public class ConditionTest {


     private static Lock lock = new ReentrantLock();
     private static Condition condition ;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConditionTest test = new ConditionTest();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        condition= lock.newCondition();
        consumer.start();
        producer.start();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {

            try {
                lock.lock();
                System.out.println("我在等一个新信号"+Thread.currentThread().getName());
                condition.await();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally{
                System.out.println("拿到一个信号"+Thread.currentThread().getName());
                lock.unlock();
            }

        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁"+Thread.currentThread().getName());
                condition.signalAll();
                System.out.println("我发出了一个信号："+Thread.currentThread().getName());
            } finally{
                lock.unlock();
            }
        }
    }






}

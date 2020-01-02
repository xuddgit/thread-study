/*
 *company:jlc
 *author:xudd
 *date:2019/11/12:9:59
 *desc:{}
 **/


package com.org.classs.producer.consumer;

import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author:xudd
 * @date:2019/11/12 -9:59
 * @desc:
 **/
public class Consumer1 implements   Runnable{

    private Queue<String> queue;
    private Lock lock ;
    private Condition condition;
    public Consumer1(Lock lock,Queue<String> queue,Condition condition){

        this.queue=queue;
        this.lock=lock;
        this.condition=condition;
    }

    @Override
    public void run() {

        while (true){
            lock.lock();
          try{
           if(queue.isEmpty()){

               try {
                   condition.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            queue.poll();
            condition.signal();
            System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}finally{
              lock.unlock();
           }
        }

    }
}

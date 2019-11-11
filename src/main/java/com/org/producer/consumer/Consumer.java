package com.org.producer.consumer;

import java.util.Queue;
import java.util.Random;

/**
 * 消费者
 */
public class Consumer extends Thread{
    private Queue<Integer> queue;
    String name;
    int maxSize;

    public Consumer(String name,Queue<Integer> queue,int maxSize){
            super(name);
            this.name=name;
            this.queue=queue;
            this.maxSize=maxSize;

    }

    public void run(){

        while(true){
            synchronized (queue){
               while(queue.isEmpty()) {
                 try{
                     System.out.println("Queue is empty ,Consumer["+name+"]thread is waiting for Producer");
                     queue.wait();
                 } catch (Exception ex){
                     ex.printStackTrace();
                 }

               }
               int x = queue.poll();
               System.out.println("["+name+"]consuming value:"+x);
               queue.notifyAll();
               try{
                  Thread.sleep(new Random().nextInt(1000));

               }catch (InterruptedException e){
                   e.printStackTrace();
               }


            }

        }
    }

}

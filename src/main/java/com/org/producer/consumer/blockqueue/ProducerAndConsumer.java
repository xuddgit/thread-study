/*
 *company:jlc
 *author:xudd
 *date:2019/11/12:15:38
 *desc:{}
 **/


package com.org.producer.consumer.blockqueue;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author:xudd
 * @date:2019/11/12 -15:38
 * @desc:
 **/
public class ProducerAndConsumer {

    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    class Producer extends Thread{
        @Override
        public void run(){

            produce();
        }

        private void produce(){
            while(true){
                try {
                    queue.put(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("生产者生产一条任务，当前队列长度为"+queue.size());
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    class Consumer extends Thread {
        @Override
        public void run(){


        }

        private void consumer(){
            while(true){
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              System.out.println("消费者消费一条任务,当前队列长度为："+queue.size());
                try {
                    TimeUnit.MILLISECONDS.sleep(new  Random().nextInt(1000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public static void main(String[] args) {

        ProducerAndConsumer producerAndConsumer= new ProducerAndConsumer();

         Producer producer = producerAndConsumer.new Producer();
        Consumer consumer = producerAndConsumer.new Consumer();
        producer.start();
        consumer.start();

    }





}

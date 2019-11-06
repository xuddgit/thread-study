/*
 *company:jlc
 *author:xudd
 *date:2019/11/5:20:23
 *desc:{}
 **/


package com.thread.wait.notity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author:xudd
 * @date:2019/11/5 -20:23
 * @desc:
 **/
public class WaitNotify {

    static boolean flag=true;
    static Object lock= new Object();

    public static void main(String[] args) {
        Thread waitThread= new Thread(new Wait(),"waitThread");
               waitThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread notifyThread = new Thread(new Notify(),"notifyThread");
               notifyThread.start();
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
            //加锁,拥有lock的Monitor
            synchronized (lock){
                //当条件不满足时候，继续wait,同时释放了lock的锁
                while(flag){
                    System.out.println(Thread.currentThread()+"flag is true . wait @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread()+"flag is false . running @"+ new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }


static class Notify implements Runnable{


    @Override
    public void run() {
        //加锁，拥有lock的Monitor
        synchronized (lock){
            //获取lock的锁,然后进行通知，通知时不会释放lock的锁
            //直到当前线程释放了lock后，WaitThead才能从wait方法中返回
            System.out.println(Thread.currentThread()+
                    "hold lock.notify @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            lock.notifyAll();
            flag=false;
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //再次加锁
        synchronized (lock){
            System.out.println(Thread.currentThread()+"hold lock again .sleep @ "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






}

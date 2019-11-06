/*
 *company:jlc
 *author:xudd
 *date:2019/11/5:19:38
 *desc:{}
 **/


package com.thread.shutdown;

import java.util.concurrent.TimeUnit;

/**
 * @author:xudd
 * @date:2019/11/5 -19:38
 * @desc:
 **/
public class ShutDown {

    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread= new Thread(one,"CountThread");
        countThread.start();
        //睡眠1秒，main线程对CountThread 进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        Runner two = new Runner();
        countThread= new Thread(two,"CountThread");
        countThread.start();
        //睡眠1秒,mian线程对Runner two 进行取消，使CountThread 能够感知on为false
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }




    private static class Runner implements  Runnable{

         private long i;
         private volatile  boolean on =true;

        @Override
        public void run() {
            while(on&&!Thread.currentThread().isInterrupted()){
                i++;

            }
            System.out.println("Count i= "+i);
        }

        public void cancel(){

            on =false;
        }
    }

}


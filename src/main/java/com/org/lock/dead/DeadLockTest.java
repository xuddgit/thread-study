package com.org.lock.dead;

import lombok.Synchronized;

public class DeadLockTest {

    private static   String A="a";

    private static   String B="B";

    public static void main(String[] args) {


        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){

                       System.out.println(""+System.currentTimeMillis());
                    }
                }
            }
        } );

          t.start();



        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (B){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(A){

                        System.out.println(""+System.currentTimeMillis());
                    }
                }
            }
        } );

        t2.start();
    }



}

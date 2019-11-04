/*
 *company:jlc
 *author:xudd
 *date:2019/10/30:21:21
 *desc:{}
 **/


package com.org.interrupt;

/**
 * @author:xudd
 * @date:2019/10/30 -21:21
 * @desc:
 **/
public class InterruptTest {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 循环中检测当前线程的中断状态
                for (int i = 0; i < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted(); i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }



}

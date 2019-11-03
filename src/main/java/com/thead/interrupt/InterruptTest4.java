/*
 *company:jlc
 *author:xudd
 *date:2019/10/30:22:19
 *desc:{}
 **/


package com.thead.interrupt;

/**
 * @author:xudd
 * @date:2019/10/30 -22:19
 * @desc:
 **/
public class InterruptTest4 {
    public static void main(String[] args) {
        try {
            MyThread14 thread = new MyThread14();
            thread.start();
            Thread.sleep(1000); //此方法代表 让当前线程休眠 1 秒，即表示使 main线程休眠 1秒
            thread.interrupt();
            System.out.println("是否终止1？ =" + thread.isInterrupted());
            System.out.println("是否终止2？ =" + thread.isInterrupted());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("----------end-----------");
    }

    class MyThread14 extends Thread {
        public void run() {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i = " + i);
            }
        }
}

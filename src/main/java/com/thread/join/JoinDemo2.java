package com.thread.join;

public class JoinDemo2 {

    public static void main(String[] args) {
        Thread current = Thread.currentThread();
        Thread t = new Thread(()->{

            try {
                current.join();
                System.out.println("子线程正在执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();

      System.out.println("主线程等待子线程执行完毕后退出");

    }
}

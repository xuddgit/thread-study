package com.thread.interrupt;

public class MyThread14 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + i);
        }
    }
}

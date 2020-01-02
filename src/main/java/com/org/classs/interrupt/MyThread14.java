/*
 *company:jlc
 *author:xudd
 *date:2019/11/1:20:46
 *desc:{}
 **/


package com.org.classs.interrupt;

/**
 * @author:xudd
 * @date:2019/11/1 -20:46
 * @desc:
 **/
public  class MyThread14 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + i);
        }
    }
}
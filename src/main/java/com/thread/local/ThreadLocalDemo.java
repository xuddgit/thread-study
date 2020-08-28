/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:15:52
 *desc:{}
 **/


package com.thread.local;

/**
 * @author:xudd
 * @date:2020/1/3 -15:52
 * @desc:
 **/
public class ThreadLocalDemo implements Runnable{
    private static ThreadLocal<Long> tl=new ThreadLocal<Long>();
    @Override
    public void run() {
        if(tl.get()==null) {

            tl.set(new Long(Thread.currentThread().getId()));
        }
        System.out.println(tl.get()+"\t");
    }
    public static void main(String args[]) {
        int k=0;
        for(int i=0;i<1000;i++) {
            Thread t=new Thread(new ThreadLocalDemo());
            t.start();
        }
    }
}

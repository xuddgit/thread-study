/*
 *company:jlc
 *author:xudd
 *date:2020/1/17:11:54
 *desc:{}
 **/


package com.thread.local;

import java.util.concurrent.TimeUnit;

/**
 * @author:xudd
 * @date:2020/1/17 -11:54
 * @desc:
 **/
public class ThreadLocalInheritable {
    static final InheritableThreadLocal<String> threadParam = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        //死循环,测多几次看结果
        while (true) {
            //线程1,测试是否能获取父线程参数
            new Thread(() -> {

                Thread t1 = Thread.currentThread();
                //设置参数
                threadParam.set("abc");
                //输出参数
                System.out.println("t1:" + threadParam.get());
                System.out.println("获取T1的线程名称"+t1.getName());

                //线程2,测试是否能获取线程1参数
                new Thread(() -> {
                    Thread t2 = Thread.currentThread();
                   String messsage=  threadParam.get();
                   System.out.println("获取消息的信息"+messsage);
                    System.out.println("获取线程名称:"+t2.getName());
                    //为了测试线程三能否获得,这里先不删除
//                    threadParam.remove();
                }).start();
                threadParam.set("efg");
            }).start();

            TimeUnit.SECONDS.sleep(1);

            //线程3,测试是否能获取线程1参数
            new Thread(() -> {
                System.out.println("t3:" + threadParam.get());
            }).start();
        }
    }
}

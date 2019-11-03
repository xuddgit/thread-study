package com.thread.tea;

import java.util.concurrent.FutureTask;

public class BoilWaterToMakeTea {

    public static void main(String[] args) {
        try {
            //创建t2的futureTask
            FutureTask<String> ft2 = new FutureTask(new T2Task());

            FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));
            // 线程T1执行任务ft1
            Thread t1 = new Thread(ft1);
            t1.start();
            //线程t2执行ft2任务
            Thread t2 = new Thread(ft2);
            t2.start();
            //等待线程T1执行结果

            // 等待线程T1执行结果
        System.out.println(ft1.get());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

package com.thread.tea;



import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class T1Task implements Callable<String> {
    /**t1，需要T2任务的futureTask*/
    private  FutureTask<String> ft2;

    T1Task(FutureTask<String> futureTask){
         this.ft2=futureTask;
    }
    //t1 要执行的任务 洗水壶，烧开水，泡茶
    @Override
    public String call() throws Exception {

        System.out.println("t1 洗水壶");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("t1 烧开水");
        TimeUnit.SECONDS.sleep(15);
        String tf= ft2.get();
        System.out.println("T1:拿到茶叶:"+tf);
        System.out.println("T1:泡茶...");
        return "上茶："+tf;
    }
}

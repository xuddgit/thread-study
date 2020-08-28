package com.org.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecuteTaskTest {

    public static void main(String[] args) {

        ThreadFactoryImpl threadFactoryImpl = new ThreadFactoryImpl("my-testThreadFactory");

        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor(threadFactoryImpl );

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务执行了"+System.currentTimeMillis());
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);
    }
}

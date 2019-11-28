package com.org.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {

    private static final  ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(()->{
            lock.lock();

            lock.lock();

            try{
                System.out.println("锁1执行完毕");
            }catch (Exception e){
                e.printStackTrace();

            }finally {
                lock.unlock();
            }


        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();

            try{
                System.out.println("锁2执行完毕");
            }catch (Exception e){
                e.printStackTrace();

            }finally {
                lock.unlock();
            }


        }).start();


    }

}

package com.org.classs.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest2 {


    private static final ReentrantReadWriteLock  readWriteLock = new ReentrantReadWriteLock ();


    public static void main(String[] args) {

        new Thread(()->{
            readWriteLock.readLock().lock();

            readWriteLock.readLock().lock();

            try{
                System.out.println("锁1执行完毕");
            }catch (Exception e){
                e.printStackTrace();

            }finally {
                readWriteLock.readLock().unlock();
            }


        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.readLock().lock();

            try{
                System.out.println("锁2执行完毕");
            }catch (Exception e){
                e.printStackTrace();

            }finally {
                readWriteLock.readLock().unlock();
            }


        }).start();


    }

}

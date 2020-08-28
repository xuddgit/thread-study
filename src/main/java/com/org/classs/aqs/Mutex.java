/*
 *company:jlc
 *author:xudd
 *date:2019/11/7:9:15
 *desc:{}
 **/


package com.org.classs.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author:xudd
 * @date:2019/11/7 -9:15
 * @desc:
 **/
public class Mutex implements Lock {

    //静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedLongSynchronizer{
        //是否处于占用状态
        @Override
        protected  boolean isHeldExclusively(){
            return getState()==1;
        }

        //当前态为0的时候获取锁
        public boolean tryAcquire(int acquires){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }else{
                return false;
            }

        }

        //释放锁，将状态设置为0

        protected boolean tryRelease(int releases){

            if(getState()==0){throw new IllegalMonitorStateException();}
            setExclusiveOwnerThread(null);
            setState(0);
            return true;

        }

        //返回一个Condition ，每个condition都包含了一个Condition队列
        Condition newCondition(){
            return new ConditionObject();
        }



    }

    private final Sync sync = new Sync();


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
            sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
/**独占锁Mutex时一个自定义同步组件，它在同一时刻只允许一个线程占有锁。*/
Lock的API
void lock(); 获取锁，调用该方法当前线程将会获取锁，当锁获得后，从该方法返回
void lockInterruptibly() throws InterruptedException 可以中断的获取锁，和lock()方法不同之处在于该方法
会响应中断，即在锁的获取中可以中断当前线程。
boolean tryLock();尝试非阻塞的获取锁，调用该方法后例可返回，如果能够获取则返回true,否则
返回false

boolean tryLock(long time,TimeUnit unit) throws InterruptedException 
超时的获取锁，当前线程在以下三种情况下会返回：
1.当前线程在超时时间内获得了锁
2.当前线程在超时时间内被中断
3.超时时间结束，返回false;
void unlock() 释放锁

Condition newCondition() 获取等待通知组件，该组件和当前锁绑定，当前线程只有获得了锁，才能
调用该组件的wait()方法，而调用后，当前线程将释放锁




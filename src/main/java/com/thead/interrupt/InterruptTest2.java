/*
 *company:jlc
 *author:xudd
 *date:2019/10/30:21:57
 *desc:{}
 **/


package com.thead.interrupt;

/**
 * @author:xudd
 * @date:2019/10/30 -21:57
 * @desc:
 **/
public class InterruptTest2 {
    public static void main(String[] args) {
        try {
            MyThread12 thread = new MyThread12();
            thread.start();
            Thread.sleep(500);
            thread.interrupt();
            /**程需运行结束后，thread线程并没有停止，而是调用thread.interrupted()结果
             * 两个false表示线程一直在运行过程中，为什么会出现这种结果呢？
             * 让我们来看看官方解释：这次请着重阅读我标红色的文字：当前线程是指运行中的this.interrupted()
             * 的方法线程。也就是说，当前线程并不是thead,并不因为thread调用了interrupted()方法就是当前线程。
             * 当前线程一直是main线程，它从来未中断过，所以打印结果就是两个false*/
            System.out.println("是否终止1?"+thread.interrupted());
            System.out.println("是否终止2?"+thread.interrupted());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("--------end--------");

    }
}
class MyThread12 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            System.out.println("i = " + i);
        }
    }
}
/*
 *company:jlc
 *author:xudd
 *date:2019/10/30:21:57
 *desc:{}
 **/


package com.org.interrupt;

/**
 * @author:xudd
 * @date:2019/10/30 -21:57
 * @desc:
 **/
public class InterruptTest3 {
    public static void main(String[] args) {
        try {
          Thread.currentThread().interrupt();
          System.out.println("是否终止1?="+Thread.interrupted());
            System.out.println("是否终止2?="+Thread.interrupted());

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("--------end--------");

    }
 /**从上述结果中可以看出，方法interrupted()的确判断出当前线程是否已经停止，但为什么第二个布尔值是
  * false呢？让我们重新阅读一次文档。
  * 测试当前线程是否已经中断。线程的中断状态由该方法清除。换句话说如果连续调用两次该方法，
  * 则第二次将返回false(在第一次调用的时线程中断中被忽略，
  * 因为在中断时，不处于活动状态的线程将由此返回false的方法反应出来)*/


}
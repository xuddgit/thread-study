/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:15:52
 *desc:{}
 **/


package com.thread.local;

/**
 * @author:xudd
 * @date:2020/1/3 -15:52
 * @desc:
 **/
public class ThreadLocalDemo {





    public static void main(String args[]) {
        ThreadLocal<Long> tl=new ThreadLocal<Long>();
        tl.set( 1L);

        Long id = tl.get() ;

        System.out.println(id+"\t");


    }
}

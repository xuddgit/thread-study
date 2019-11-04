/*
 *company:jlc
 *author:xudd
 *date:2019/11/1:21:14
 *desc:{}
 **/


package com.org.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:xudd
 * @date:2019/11/1 -21:14
 * @desc:
 **/
public class TestFuture {

    public static void main(String[] args) {
        Callable<String> userCall= new UserCall();
        FutureTask<String> ft= new FutureTask<>(userCall);

        Thread t = new Thread(ft);
               t.start();
        try {
          String name=  ft.get();
            System.out.println("用户名称"+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

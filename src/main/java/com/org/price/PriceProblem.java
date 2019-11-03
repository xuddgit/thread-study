package com.org.price;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PriceProblem {
/***问题描述
 *
 * 有个询价系统，从三个数据源询价，当询得最低价格后就
 * 保存入库
 * */
    public static void main(String[] args) {
       try {
           Task1 t1 = new Task1();

           Task2 t2 = new Task2();

           Task3 t3 = new Task3();


           ExecutorService executorService = Executors.newFixedThreadPool(3);
           Future<PriceEntity> f1 = executorService.submit(t1);
           Future<PriceEntity> f2 = executorService.submit(t2);
           Future<PriceEntity> f3 = executorService.submit(t3);

           System.out.println(f1.get());
           System.out.println(f2.get());
           System.out.println(f3.get());
           executorService.shutdown();
       }catch (Exception e){
           e.printStackTrace();
       }

    }

}

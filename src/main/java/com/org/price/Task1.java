package com.org.price;

import java.util.concurrent.Callable;
/***询价数据源1*/
public class Task1 implements Callable<PriceEntity> {


    @Override
    public PriceEntity call() throws Exception {

        PriceEntity  priceEntity = new PriceEntity();
        priceEntity.setId("任务1");
        Integer i=(int)(Math.random()*100);
        priceEntity.setPrice(i);
        return priceEntity;
    }
}

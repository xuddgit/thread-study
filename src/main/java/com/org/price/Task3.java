package com.org.price;

import java.util.concurrent.Callable;

public class Task3 implements Callable {


    @Override
    public Object call() throws Exception {
        PriceEntity  priceEntity = new PriceEntity();
        priceEntity.setId("任务3");
        Integer i=(int)(Math.random()*100);
        priceEntity.setPrice(i);
        return priceEntity;

    }

}

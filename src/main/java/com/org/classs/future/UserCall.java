/*
 *company:jlc
 *author:xudd
 *date:2019/11/1:21:13
 *desc:{}
 **/


package com.org.classs.future;

import java.util.concurrent.Callable;

/**
 * @author:xudd
 * @date:2019/11/1 -21:13
 * @desc:
 **/
public class UserCall implements Callable<String> {
    @Override
    public String call() throws Exception {

        return "zs"+System.currentTimeMillis();
    }
}

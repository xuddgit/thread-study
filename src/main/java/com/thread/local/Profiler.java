/*
 *company:jlc
 *author:xudd
 *date:2019/11/5:21:50
 *desc:{}
 **/


package com.thread.local;

import java.util.concurrent.TimeUnit;

/**
 * @author:xudd
 * @date:2019/11/5 -21:50
 * @desc:
 **/
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL= new ThreadLocal<Long>(){
        protected Long initValue(){

           return System.currentTimeMillis();
        }
    };

  public static final void begin(){

        TIME_THREADLOCAL.set(System.currentTimeMillis());
  }

  public static final long end(){

      return System.currentTimeMillis()-TIME_THREADLOCAL.get();
  }

    public static void main(String[] args)throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " +Profiler.end()+" mills");
    }
}

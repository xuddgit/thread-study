/*
 *company:jlc
 *author:xudd
 *date:2019/12/25:14:07
 *desc:{}
 **/


package com.org.classs.wwls;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author:xudd
 * @date:2019/12/25 -14:07
 * @desc:
 **/
public class Test6 {


    public static void main(String[] args) {

         Calendar newTime = Calendar.getInstance();
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        newTime.setTimeZone(timeZone);
        long newTimeMs=1577174428L;

        newTime.setTimeInMillis(newTimeMs*1000L);

        Calendar lastTime = Calendar.getInstance();
        lastTime.setTimeZone(timeZone);

        long lastTimeMs=1575014388L;
        lastTime.setTimeInMillis(lastTimeMs*1000L);
        System.out.println(newTime.get(Calendar.MONTH));
        System.out.println(lastTime.get( Calendar.MONTH));

        if (lastTime.get( Calendar.MONTH) == newTime.get( Calendar.MONTH)) {
            System.out.println("两个年份相等");
        }
    }

}

/*
 *company:jlc
 *author:xudd
 *date:2019/11/19:16:32
 *desc:{}
 **/


package com.org.classs.wwls;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author:xudd
 * @date:2019/11/19 -16:32
 * @desc:
 **/
public class Test2 {

    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
          int h=localDateTime.getHour();
          int m=localDateTime.getMinute();
         System.out.println(localDateTime.getHour());
         System.out.println(localDateTime.getMinute());
         if(h==4 && m==9){

            System.out.println("开盘第一分钟");
         }
    }
}

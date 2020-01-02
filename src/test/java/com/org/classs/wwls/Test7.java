/*
 *company:jlc
 *author:xudd
 *date:2019/12/25:14:17
 *desc:{}
 **/


package com.org.classs.wwls;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * @author:xudd
 * @date:2019/12/25 -14:17
 * @desc:
 **/
public class Test7 {
    public static void main(String[] args) {

       System.out.println(lowerFirstChar(UserInfo.class.getSimpleName()));

    }
    private static String lowerFirstChar(String str){
        char [] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone.getId());
        return LocalDateTime.ofInstant(instant, zone);
    }


}

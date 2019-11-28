/*
 *company:jlc
 *author:xudd
 *date:2019/11/17:9:28
 *desc:{}
 **/


package com.org.wwls;

/**
 * @author:xudd
 * @date:2019/11/17 -9:28
 * @desc:
 **/
public class Test {
    public static void main(String[] args) {
       System.out.println(System.currentTimeMillis());
     long l=   5000 - System.currentTimeMillis()%1000;
     System.out.println(l);
     int i=0;

     int j=1;

     if(i==0){System.out.println("000");}
     else if(j==1){
         System.out.println("1111");

     }
        long minTim_now = System.currentTimeMillis()/60000;

     System.out.println(minTim_now);

    }
}

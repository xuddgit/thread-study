/*
 *company:jlc
 *author:xudd
 *date:2019/12/6:11:50
 *desc:{}
 **/


package com.org.classs.wwls;

/**
 * @author:xudd
 * @date:2019/12/6 -11:50
 * @desc:
 **/
public class Test5 {

    public static void main(String[] args) {
        User user1= User.user;

        User user2 = User.user;

        user1.setName("ls");

        System.out.println(user1.getName());
        System.out.println(user2.getName());


    }

}

/*
 *company:jlc
 *author:xudd
 *date:2019/12/6:11:47
 *desc:{}
 **/


package com.org.wwls;

import lombok.Data;

/**
 * @author:xudd
 * @date:2019/12/6 -11:47
 * @desc:
 **/
@Data
public class User {
    private String name;

    public static final User user = new User("zs");

    public User(String name){

        this.name=name;
    }

}

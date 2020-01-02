/*
 *company:jlc
 *author:xudd
 *date:2019/12/6:11:47
 *desc:{}
 **/


package com.org.classs.wwls;

import lombok.Data;

/**
 * @author:xudd
 * @date:2019/12/6 -11:47
 * @desc:
 **/
@Data
public class UserInfo {
    private String name;

    public static final UserInfo user = new UserInfo("zs");

    public UserInfo(String name){

        this.name=name;
    }

}

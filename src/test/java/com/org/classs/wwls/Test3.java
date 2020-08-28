/*
 *company:jlc
 *author:xudd
 *date:2019/12/3:19:40
 *desc:{}
 **/


package com.org.classs.wwls;

/**
 * @author:xudd
 * @date:2019/12/3 -19:40
 * @desc:
 **/
public class Test3 {
    public static final int OP_READ = 1 << 0;


    public static final int OP_WRITE = 1 << 2;

    public static final int OP_CONNECT = 1 << 3;


    public static final int OP_ACCEPT = 1 << 4;

    public static void main(String[] args) {
        System.out.println("OP_READ"+OP_READ);
        System.out.println("OP_WRITE"+OP_WRITE);

        System.out.println("OP_CONNECT"+OP_CONNECT);

        System.out.println("OP_ACCEPT"+OP_ACCEPT);

    }
}

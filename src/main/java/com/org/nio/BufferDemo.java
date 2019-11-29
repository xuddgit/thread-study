/*
 *company:jlc
 *author:xudd
 *date:2019/11/28:19:49
 *desc:{}
 **/


package com.org.nio;

import java.nio.IntBuffer;

/**
 * @author:xudd
 * @date:2019/11/28 -19:49
 * @desc:
 **/
public class BufferDemo {
   private static IntBuffer intBuffer = IntBuffer.allocate(20);
    public static void main(String[] args) {
        allocatTest();
        putTest();
        flipTest();
        getTest();
        rewindtest();
    }

    public static void allocatTest()
    {

        System.out.println("------------after allocate------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }


    public static void putTest() {
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);


        }
        System.out.println("------------after put------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
        /**flip()方法主要是从读模式切换成写模式，调用规则是：(1)首先设置可读的长度limit .将写模式下的Buffer中
         * 内容的最后位置position值编为读模式下的limit位置值，新的limit值作为读越界位置；*/
    }

    public static void flipTest(){
        intBuffer.flip();

        System.out.println("------------after flip------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());

    }


    public static void getTest(){


        for (int i = 0; i < 2; i++)
        {
            int j = intBuffer.get();
            System.out.println("j = " + j);
        }

        System.out.println("------------after get2------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());

        for (int i = 0; i < 3; i++)
        {
            int j = intBuffer.get();
            System.out.println("j = " + j);
        }
        System.out.println("------------after get3------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());

    }


    public static void rewindtest(){

        intBuffer.rewind();
        System.out.println("------------after rewind------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());

    }

}

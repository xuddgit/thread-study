package com.org.wwls;

public class ThreadLocalDemo {

    public static void main(String[] args) {

       Thread thread = Thread.currentThread();

       System.out.println(thread.getName());
       ThreadLocal<Integer> myLocal = new ThreadLocal<>();
        myLocal.set(1);

    }
}

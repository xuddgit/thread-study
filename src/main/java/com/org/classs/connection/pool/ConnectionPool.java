/*
 *company:jlc
 *author:xudd
 *date:2019/11/6:17:22
 *desc:{}
 **/


package com.org.classs.connection.pool;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author:xudd
 * @date:2019/11/6 -17:22
 * @desc:
 **/
public class ConnectionPool {


    private LinkedList<Connection> pool= new LinkedList<>();

    public ConnectionPool(int initialSize){

        if(initialSize>0){
           for(int i=0;i<initialSize;i++){
               pool.addLast(ConnectionDirver.createConnection());

           }
        }

    }

    public void releseConnection(Connection connection){
        if(!Objects.isNull(connection)){

            synchronized (pool){
              //连接释放需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
              pool.addLast(connection);
              pool.notifyAll();

            }
        }

    }

    //在mills 内无法获取到连接，将会返回null

    public Connection fetchConnection(Long mills)throws InterruptedException{
        synchronized (pool){
            //完全超时
            if(mills<=0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long future= System.currentTimeMillis()+mills;
                long remaining =mills;
                while(pool.isEmpty()&&remaining>0){
                    pool.wait(remaining);
                    remaining=future-System.currentTimeMillis();

                }
                Connection result = null;
                if(!pool.isEmpty()){

                    result=pool.removeFirst();
                }
                return result;
            }
        }

    }

}

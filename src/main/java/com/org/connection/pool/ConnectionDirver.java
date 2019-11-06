/*
 *company:jlc
 *author:xudd
 *date:2019/11/6:17:33
 *desc:{}
 **/


package com.org.connection.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author:xudd
 * @date:2019/11/6 -17:33
 * @desc:
 **/
public class ConnectionDirver {

    static class ConnectionHandler implements InvocationHandler{


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
             if(method.getName().equals("commit")){

                 TimeUnit.MILLISECONDS.sleep(100);
            };
            return null;
        }

    }

    /**创建一个Connection的代理，在commit时休眠100毫秒*/
    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDirver.class.getClassLoader(),
                new Class[]{Connection.class},new ConnectionHandler());

    }

}

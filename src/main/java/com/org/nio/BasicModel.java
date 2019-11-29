/*
 *company:jlc
 *author:xudd
 *date:2019/11/29:17:24
 *desc:{}
 **/


package com.org.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:xudd
 * @date:2019/11/29 -17:24
 * @desc:
 **/
public class BasicModel implements Runnable{
    @Override
    public void run() {
        try {
            ServerSocket ss =
                    new ServerSocket(SystemConfig.SOCKET_SERVER_PORT);
            while (!Thread.interrupted()) {
                new Thread(new Handler(ss.accept())).start();
            }
            //创建新线程来handle
            // or, single-threaded, or a thread pool
        } catch (IOException ex) { /* ... */ }
    }


}

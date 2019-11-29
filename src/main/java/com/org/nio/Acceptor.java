/*
 *company:jlc
 *author:xudd
 *date:2019/11/29:17:52
 *desc:{}
 **/


package com.org.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author:xudd
 * @date:2019/11/29 -17:52
 * @desc:
 **/
public class Acceptor implements  Runnable{
   Acceptor(ServerSocketChannel serverSocket,Selector selector){

       this.serverSocket=serverSocket;
       this.selector=selector;


   }
   private ServerSocketChannel serverSocket;

   private Selector  selector;
    @Override
    public void run()
    {
        try
        {
            SocketChannel channel = serverSocket.accept();
            if (channel != null){
                new Handler(selector, channel);
            }
        } catch (IOException ex)
        { /* ... */ }
    }
}

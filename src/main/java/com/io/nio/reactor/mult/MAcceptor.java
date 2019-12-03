package com.io.nio.reactor.mult;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MAcceptor implements Runnable{
    MAcceptor(ServerSocketChannel serverSocket, Selector selector){

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
                new MthreadHandler(selector, channel);
            }
        } catch (IOException ex)
        { /* ... */ }
    }
}

/*
 *company:jlc
 *author:xudd
 *date:2019/11/29:17:24
 *desc:{}
 **/


package com.io.oio;

import com.io.nio.SystemConfig;

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


    /**
     * @author:xudd
     * @date:2019/11/29 -17:51
     * @desc:
     **/
    public static class Handler implements Runnable{
            final Socket socket;
            Handler(Socket s) { socket = s; }
            @Override
            public void run() {
                try {
                    byte[] input = new byte[SystemConfig.INPUT_SIZE];
                    socket.getInputStream().read(input);
                    byte[] output = process(input);
                    socket.getOutputStream().write(output);
                } catch (IOException ex) { /* ... */ }
            }
            private byte[] process(byte[] input) {
                byte[] output=null;
                /* ... */
                return output;
            }
        }
}

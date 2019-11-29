/*
 *company:jlc
 *author:xudd
 *date:2019/11/29:17:51
 *desc:{}
 **/


package com.org.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author:xudd
 * @date:2019/11/29 -17:51
 * @desc:
 **/
public class Handler implements Runnable{
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


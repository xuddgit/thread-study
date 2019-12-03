package com.io.nio.reactor.sample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable{

  final Selector selector;
  final ServerSocketChannel serverSocket;
     //Reactor 1: Setup
  Reactor(int port)throws IOException {

      selector=Selector.open();
      serverSocket=ServerSocketChannel.open();
      serverSocket.bind(new InetSocketAddress(port));
     //设置非阻塞
      serverSocket.configureBlocking(false);
      SelectionKey sk = serverSocket.register(selector,SelectionKey.OP_ACCEPT);
      sk.attach(new Acceptor());
      /**Alternatively,use explicit SPI provider: SelectorProvider p
       * =SelectorProvier.provider();Slector = p.openSelector();
       * serverSocket= p.openServerSocketChannel();*/
  }
   //Reactor 2: Dispatch Loop
    //class Reactor continued
    @Override
    public void run() {
      // normally in a new Thread
        try{
            while(!Thread.interrupted()){
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while(it.hasNext()){
                  dispatch((SelectionKey)it.next());
                }
                selected.clear();

            }

        }catch (IOException ex){
            /**....**/
        }

    }

    void dispatch(SelectionKey k){
      Runnable r= (Runnable)(k.attachment());
      if(r!=null){

         r.run();
      }
    }
//Reactor 3: Acceptor

// class Reactor continued

 class Acceptor implements  Runnable{
// inner

     @Override
     public void run() {

         try{
             SocketChannel c = serverSocket.accept();
             if(c!=null){
                 new Handler(selector,c);

             }
         }catch (IOException ex){

             /**...**/
         }

     }
    // Reactor 4: Handler setup
   final class Handler implements  Runnable{
         final SocketChannel socket;
         final SelectionKey sk;
         final Integer MAXIN=100;
         final Integer MAXOUT=100;
         ByteBuffer input= ByteBuffer.allocate(MAXIN);
         ByteBuffer output =ByteBuffer.allocate(MAXOUT);
         static final int READING=0,SENDING=1;
         int state=READING;

         Handler(Selector sel,SocketChannel c)throws IOException{
             socket=c;
             c.configureBlocking(false);
             //Optionally try first read now
             sk = socket.register(sel,0);
             sk.attach(this);
             sk.interestOps(SelectionKey.OP_READ);
             sel.wakeup();

         }
         boolean inputIsComplete(){

             /**...*/
             return false;

         }

         boolean outputIsComplete(){
             /***...**/
             return false;

         }

         void process(){


         }
// class Handler continued

        @Override
        public void run() {
            try{
              if(state==READING){
                  read();


              }else if(state==SENDING){
                  send();

              }

            }catch (IOException ex){
                /****/
            }
        }
        void read()throws IOException{
            socket.read(input);
             if(inputIsComplete()){
                 process();
                 state=SENDING;
                 //normally also do first write now
                 sk.interestOps(SelectionKey.OP_WRITE);
             }
        }
        void send()throws IOException{
            socket.write(output) ;
            if(outputIsComplete()){

                sk.cancel();
            }

        }

    }


 }




}

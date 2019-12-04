/*
 *company:jlc
 *author:xudd
 *date:2019/12/3:19:08
 *desc:{}
 **/


package com.io.nio.reactor.single;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author:xudd
 * @date:2019/12/3 -19:08
 * @desc:
 **/
public class Reactor implements Runnable{

    final Selector selector;

    final ServerSocketChannel serverSocket;

    /**Reactor 1: Setup 模式第一步 设置*/
    Reactor(int port )throws IOException {
        //通过open打开一个选择器
        selector=Selector.open();
        //通过open打开一个通道
        serverSocket=ServerSocketChannel.open();
        //将通道绑定端口号
        serverSocket.bind(new InetSocketAddress(port));
        //将serverSocket注册到selector监听 APPCPET事件
      SelectionKey selectionKey=  serverSocket.register(selector, SelectionKey.OP_ACCEPT);
       //设置监听事件的执行类
        selectionKey.attach(new Acceptor());
        /**Alternatively ,use explicit SPI provider:
         * 当然也可以明确通过SPI provider来实现
         * SelectorProvider p = SelectorProvier.provider();
         * selector = p.openSelector();
         * serverSocket = p.openServerSocketChannel();
         * */
    }

    /***Reactor 2:Dispatch Loop 模式第二步：分发循环
     * class Reactor continued*/
    @Override
    public void run() {
       /***normally in new Thead 通常通过一个新线程来实现*/
       try{
       while(!Thread.interrupted()){
           //选择器开始阻塞，等待事件到达
           selector.select();
           //获取到达的事件列表
           Set selected = selector.selectedKeys();
           Iterator it = selected.iterator();
           //循环事件列表
           while(it.hasNext()){
               //分发事件到分配器
               dispatch((SelectionKey) it.next()) ;

           }
           selected.clear();
       }}catch (IOException ex){
           /****/
       }

    }
    /***分派任务的具体方法*/
    void dispatch(SelectionKey selectionKey){

        Runnable r= (Runnable) selectionKey.attachment();
        if(r!=null){
            r.run();
        }

    }

  /**Reactor 3:Acceptor**/
  /**class Reactor continued inner 内部类*/
  class Acceptor implements Runnable {


      @Override
      public void run() {
      try{
          SocketChannel c= serverSocket.accept();

          if(c!=null){

              new Handler(selector,c);
          }
      }catch (IOException ex){
          /****/

      }

      }
  }

  /**Reactor 4:Handler setup 处理器设置*/


  final class Handler implements Runnable{

      final SocketChannel socket;

      final SelectionKey sk;
      final Integer MAXIN=100;
      final Integer MAXOUT=100;

      ByteBuffer input= ByteBuffer.allocate(MAXIN);
      ByteBuffer output= ByteBuffer.allocate(MAXOUT);

      static final int READING=0,SENDING=1;
      int state=READING;

      Handler(Selector sel,SocketChannel c)throws IOException{

          socket=c;
          c.configureBlocking(false);
          //Optionally try first read now
          sk= socket.register(sel,0);
          //把当前类放入附件中
          sk.attach(this);
          //设置当前类 感兴趣 读事件
          sk.interestOps(SelectionKey.OP_READ);
          sel.wakeup();
      }


      boolean inputIsComplete(){

          /***/
          return true;
      }

      boolean outputIsComplete(){

          return true;
      }

      void process(){

      }
      /**Reactor 5 :Request handling
       * class Handler continued
       * */
      @Override
      public void run() {
      try {
          if (state == READING) {

              read();
          } else if (state == SENDING) {
              send();

          }
      }catch (IOException ex){


      }

      }

      void read()throws IOException{
          socket.read(input);
          if(inputIsComplete()){
              process();
              state=SENDING;
              /**Normally also do first write now*/
              sk.interestOps(SelectionKey.OP_WRITE);
          }
      }


      void send() throws IOException{
          socket.write(output);


          if(outputIsComplete()){
              sk.cancel();

          }

      }
  }



}

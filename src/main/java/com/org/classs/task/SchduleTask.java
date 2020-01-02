/*
 *company:jlc
 *author:xudd
 *date:2019/11/1:21:23
 *desc:{}
 **/


package com.org.classs.task;

/**
 * @author:xudd
 * @date:2019/11/1 -21:23
 * @desc:
 **/
public class SchduleTask {

    /***调度分几个角度考虑
     *  1.数据源加载
     *  2.分页查询
     *  3.针对查询出来的数据，先锁定，即更新为成功或者其他中间态
     *  4.通过线程池进行处理
     *  如果速度更快点可以采用分片策略，目前成熟的分片策略，基本上都是采用hash
     *
     *  可以采用同步的，或者异步的策略
     *
     *  FutureTask ,CallAble
     *
     *  线程池 线程池要根据具体的业务进行定义，注意线程池的 初始化大小，以及 饱和策略
     *
     *  调度相关的 框架：tb-schedule
     *                 xxl-job
     *                 qutarz
     *
     *
     *
     *  */

}

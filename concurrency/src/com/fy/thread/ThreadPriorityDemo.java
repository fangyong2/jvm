package com.fy.thread;

/*
线程的优先级

在 Java 的线程操作中，所有的线程在运行前都会保持在就绪状态，那么此时，哪个线程的优先级高，哪个线程就有可能会先被执行。
*/

class MyThread4 implements Runnable{ // 实现Runnable接口
    public void run(){  // 覆写run()方法
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(1000) ; // 线程休眠
            }catch(InterruptedException e){
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i) ;  // 取得当前线程的名字
        }
    }
};

/*
从程序的运行结果中可以观察到，线程将根据其优先级的大小来决定哪个线程会先运行，
但是需要注意并非优先级越高就一定会先执行，哪个线程先执行将由 CPU 的调度决定。
*/
public class ThreadPriorityDemo{
    public static void main(String args[]){
        Thread t1 = new Thread(new MyThread4(),"线程A") ;  // 实例化线程对象
        Thread t2 = new Thread(new MyThread4(),"线程B") ;  // 实例化线程对象
        Thread t3 = new Thread(new MyThread4(),"线程C") ;  // 实例化线程对象
        t1.setPriority(Thread.MIN_PRIORITY) ;   // 优先级最低
        t2.setPriority(Thread.MAX_PRIORITY) ;   // 优先级最高
        t3.setPriority(Thread.NORM_PRIORITY) ;  // 优先级最中等
        t1.start() ;    // 启动线程
        t2.start() ;    // 启动线程
        t3.start() ;    // 启动线程
    }
};

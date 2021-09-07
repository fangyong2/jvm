package com.fy.thread;

/*
一个多线程的程序如果是通过 Runnable 接口实现的，则意味着类中的属性被多个线程共享，
那么这样就会造成一种问题，如果这多个线程要操作同一个资源时就有可能出现资源同步问题。

解决方法：
    同步代码块
    synchronized(同步对象)｛
        需要同步的代码
    ｝
*/
class MyThread6 implements Runnable{
    private int ticket = 5 ;    // 假设一共有5张票
    public void run(){
        for(int i=0;i<100;i++){
            synchronized(this){ // 要对当前对象进行同步
                if(ticket>0){   // 还有票
                    try{
                        Thread.sleep(1000) ; // 加入延迟
                    }catch(InterruptedException e){
                        e.printStackTrace() ;
                    }
                    System.out.println("卖票：ticket = " + ticket-- );
                }
            }
        }
    }
};
public class SyncSample1{
    public static void main(String args[]){
        MyThread6 mt = new MyThread6() ;  // 定义线程对象
        Thread t1 = new Thread(mt) ;    // 定义Thread对象
        Thread t2 = new Thread(mt) ;    // 定义Thread对象
        Thread t3 = new Thread(mt) ;    // 定义Thread对象
        t1.start() ;
        t2.start() ;
        t3.start() ;
    }
};

package com.fy.thread;

/*
线程的休眠
在程序中允许一个线程进行暂时的休眠，直接使用 Thread.sleep() 即可实现休眠。
*/
class MyThread1 implements Runnable { // 实现Runnable接口
    public void run() {  // 覆写run()方法
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(1000); // 线程休眠1秒
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);  // 取得当前线程的名字
        }
    }
};

public class ThreadSleepDemo {
    public static void main(String args[]) {
        MyThread1 mt = new MyThread1();  // 实例化Runnable子类对象
        Thread t = new Thread(mt, "线程");     // 实例化Thread对象
        t.start(); // 启动线程
    }
};

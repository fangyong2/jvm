package com.fy.thread;

/*
线程的强制运行
在线程操作中，可以使用 join() 方法让一个线程强制运行。
线程强制运行期间，其他线程无法运行，必须等待此线程完成之后才可以继续执行。
*/
class MyThread implements Runnable { // 实现Runnable接口
    public void run() {  // 覆写run()方法
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);  // 取得当前线程的名字
        }
    }
};

public class ThreadJoinDemo {
    public static void main(String args[]) {
        MyThread mt = new MyThread();  // 实例化Runnable子类对象
        Thread t = new Thread(mt, "线程");     // 实例化Thread对象
        t.start(); // 启动线程

        try {
            t.join();  // 线程强制运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main线程运行 --> ");

    }
};

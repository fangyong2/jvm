package com.fy.thread;

/*
线程的礼让
在线程操作中，也可以使用 yield() 方法将一个线程的操作暂时让给其他线程执行
*/

class MyThread5 implements Runnable { // 实现Runnable接口
    public void run() {  // 覆写run()方法
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);  // 取得当前线程的名字
            System.out.println("线程礼让：");
            Thread.currentThread().yield();    // 线程礼让
        }
    }
};

public class ThreadYieldDemo {
    public static void main(String args[]) {
        MyThread5 my = new MyThread5();  // 实例化MyThread对象
        Thread t1 = new Thread(my, "线程A");
        Thread t2 = new Thread(my, "线程B");
        t1.start();
        t2.start();
    }
};

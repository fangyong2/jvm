package com.fy.juc;
//用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。volatile很容易被误用，用来进行原子性操作

//伪代码来描述我们的程序
//
//首先创建 VolatileTest vt = new VolatileTest();
//然后启动线程 vt.start();
//暂停主线程2秒（Main） Thread.sleep(2000);
//这时的vt线程已经开始执行，进行i++;
//主线程暂停2秒结束以后将 vt.flag = true;
//打印语句 System.out.println("stope" + vt.i); 在此同时由于vt.flag被设置为true,所以vt线程在进行下一次while判断 while (!flag) 返回假 结束循环 vt线程方法结束退出！
//主线程结束
public class VolatileTest extends Thread {

//    boolean flag = false;
    volatile boolean flag = false;
    int i = 0;

    public void run() {
        while (!flag) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
        System.out.println("stope" + vt.i);
    }
}
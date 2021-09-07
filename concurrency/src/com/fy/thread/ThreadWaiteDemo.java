package com.fy.thread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
思路分析：

模拟库存，库存为空时消费线程等待，库存满了时生产线程等待；
执行消费操作后唤醒在库存对象上等待的生产线程，（如果有生产线程等待则可以唤醒继续生产）；
执行生产操作后唤醒在库存对象上等待的消费线程，（如果有消费线程等待则可以唤醒继续消费）；
*/

//生产者，将LinkedList比作库存，用一个循环体生产线程
class Producer implements Runnable {

    private final LinkedList<Integer> list;

    Producer(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() >= 3) {
                    System.out.println("库存已满，等待消费后继续生产");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("开始生产");
                list.add(new Random().nextInt());
                list.notifyAll();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者，假设一个消费线程减少一个库存：
final class Consumer implements Runnable {

    private final LinkedList<Integer> list;

    Consumer(LinkedList<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        synchronized(list){
            while (list.isEmpty()) {
                System.out.println("库存为空，等待生产");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费");
            list.remove();
            list.notifyAll();
        }
    }
}

//主程序，首先开启生产者线程，创建两个消费者线程：
//TimeUnit真的很好用，实现线程睡眠可替代Thread.sleep()。
public class ThreadWaiteDemo {
    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Producer(list)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Consumer(list)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Consumer(list)).start();
    }
}

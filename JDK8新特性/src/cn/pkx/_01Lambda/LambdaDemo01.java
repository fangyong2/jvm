package cn.pkx._01Lambda;

/**
     Lambda表达式初体验

     1. Lambda表达式概述
        JDK8的新特性
        作用：用来简化匿名内部类的语法

     2 . 示例：开启一个线程执行任务，任务是在控制台中输出：我是程序猿我骄傲
         * 不使用lambda语法实现
         * 使用lambda表达式实现

     3. Lambda表达式的核心思想：只专注于做什么，而不是怎么做。
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        // 不使用lambda语法实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1我是程序猿我骄傲" + Thread.currentThread().getName());
            }
        }).start();

        // 使用lambda表达式实现
        new Thread(()-> System.out.println("2我是程序猿我骄傲" + Thread.currentThread().getName())).start();
    }
}

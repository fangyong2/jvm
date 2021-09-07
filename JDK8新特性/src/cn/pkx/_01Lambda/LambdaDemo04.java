package cn.pkx._01Lambda;

/**
  Lambda表达式的实现原理
 */
public class LambdaDemo04 {
    public static void main(String[] args) {
        // 使用lambda表达式实现
        /**
            Runnable接口的抽象方法：
                public void run();
            lambda表达式内部实现原理：
                1. 创建一个类实现接口
                    class Xxx implements Runnable{
                        2. 重写接口的抽象方法
                         public void run(){
                            System.out.println("2我是程序猿我骄傲" + Thread.currentThread().getName());
                         }
                    }
                3. 创建接口实现类型对象
                    new Thread(new Xxx()).start();
         */
        new Thread(()->{
            System.out.println("2我是程序猿我骄傲" + Thread.currentThread().getName());
        }).start();
    }
}

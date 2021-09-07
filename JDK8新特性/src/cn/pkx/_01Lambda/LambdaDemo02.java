package cn.pkx._01Lambda;

/**
  Lambda表达式标准格式
    (参数列表) -> { 方法体 }
        * 小括号就是方法的参数列表
        * -> 新语法，代表动作指向
        * 大括号就是方法的方法体

 */
public class LambdaDemo02 {
    public static void main(String[] args) {
        // 使用匿名内部实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1我是程序猿我骄傲" + Thread.currentThread().getName());
            }
        }).start();

        // 使用lambda表达式实现
        new Thread(()->{
            System.out.println("2我是程序猿我骄傲" + Thread.currentThread().getName());
        }).start();
    }
}

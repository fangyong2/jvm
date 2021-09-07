package cn.pkx._01Lambda;

/**
  Lambda表达式使用前提条件
    * 必须是接口且接口中有且只有一个抽象方法
 */
interface A {
    int test(int a,int b);
    default void a(){

    }
}

public class LambdaDemo03 {
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

        // 调用testA方法
        testA(new A() {
            @Override
            public int test(int a,int b) {
                System.out.println("test...");
                return a + b;
            }
        });

        // 使用lambda表达式调用
        testA((int x,int y)->{
            System.out.println("test...");
            return x + y;
        });
    }

    public static void testA(A a){

    }
}

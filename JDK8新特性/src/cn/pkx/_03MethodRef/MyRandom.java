package cn.pkx._03MethodRef;

import java.util.Random;

/**
 * 随机数类
 */
public class MyRandom {
    // 方法：返回a到b之间的随机数，比如a=100,b=200 返回100到200之间的随机数
    public int nextIntAToB(int a,int b){
        System.out.println("xxx");
        // 创建随机数对象
        Random r = new Random();
        return r.nextInt(b - a + 1) + a;
    }
}

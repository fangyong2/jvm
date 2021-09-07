package cn.pkx._01Lambda;

/**
 * 目标：掌握函数式接口的概念

   什么是函数式接口：接口中有且只有一个抽象方法的接口

   Lambda使用要求：接口必须是函数式接口：比如 Runnable接口

   @FunctionalInterface：函数式接口
     用来修饰接口，表明该接口是一个函数式接口，如果接口不是函数式接口则编译报错。
     如果自定义的接口有且只有一个抽象方法，则建议在接口上使用@FunctionalInterface注解修饰
 */
// 函数式接口
@FunctionalInterface
interface C {
    void test();
    // void aaa();
}
public class LambdaDemo08 {
    public static void main(String[] args) {

    }
}

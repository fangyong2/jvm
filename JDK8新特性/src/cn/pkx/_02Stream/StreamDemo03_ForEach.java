package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的forEach方法的作用

    讲解：
        1. void	forEach(Consumer<T> action)
            * 对流中的元素进行遍历： 将遍历到的每一个元素传递给消费者对象

        2. Consumer接口概述
            * 是一个函数式接口，抽象方式：void accept(T t);

    小结：
        1. Stream的forEach方法的作用：对流中元素进行遍历,将每一个元素传递给消费者对象处理
 */
public class StreamDemo03_ForEach {
    public static void main(String[] args){
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        // 获得Stream流对象
        Stream<String> stream = list.stream();
        // 遍历流中元素
        // void accept(T t);
        stream.forEach(name->{
            System.out.println(name);
        });

    }
}

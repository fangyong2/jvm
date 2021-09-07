package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的map方法的作用

    讲解：
        1. map方法声明如下：
            Stream<R> map(Function<T,R> f)
            * map ==> 映射 ==> 一个对应一个
            * 将当前流的元素从一种类型转换为另一种类型并存储到新流中

        2. Function接口概述
            * 是一个函数式接口，抽象方法：R apply(T t)

    小结：
        1. Stream的map方法的作用
            将当前流中的元素从一种类型转换为另一种类型存储到新流中

 */
public class StreamDemo07_Map {
    public static void main(String[] args){
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "1", "2", "3", "4", "5", "6");
        // 需求：将集合中的元素从String类型转换为整形
        Stream<String> stream = list.stream();

        // 将流中的元素类型从String转换为Integer
        // R apply(T t)
        Stream<Integer> newStream = stream.map(str -> Integer.parseInt(str));

        newStream.forEach(num->System.out.println(num+1));
    }
}

package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的filter方法的作用

    讲解：
        1. filter方法声明如下：
            * Stream<T> filter(Predicate<T> predicate)
                * filter：过滤，筛选
                * 对流中元素进行过滤，将满足条件的元素保留下来存储到一个新流中
                * Predicate：用来封装过滤条件

        2. Predicate概述
            * 是一个函数式接口，抽象方法：boolean test(T t); 用来封装过滤条件

    小结：
        1. Stream的filter方法的作用：对流中的元素进行过滤

 */
public class StreamDemo04_Filter {
    public static void main(String[] args){
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        // 需求1：对集合元素过滤：将名字是三个字的保留下来
        Stream<String> stream = list.stream();
        // boolean test(T t)
        Stream<String> newStream = stream.filter(name->name.length() == 3);

        // 遍历新流的元素
        /*newStream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        newStream.forEach(s-> System.out.println(s));

    }
}

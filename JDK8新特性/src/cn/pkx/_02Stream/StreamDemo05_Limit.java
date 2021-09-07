package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的limit方法的作用

    讲解：
        1. limit方法声明如下：
            Stream<T> limit(long n)
                将当前流中前n个元素获取到另一流中
                n大于当前流元素个数时，则会将当前流所有元素获取到另一个流中
                n必须大于0，如果等于0，则产生一个空流。
    小结：
        1. Stream的limit方法的作用：将前n个元素获取到新流中

 */
public class StreamDemo05_Limit {
    public static void main(String[] args){
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        // 需求：将获得集合前2个元素到新流中
        Stream<String> stream = list.stream();
        Stream<String> newStream = stream.limit(2);
        newStream.forEach(name->System.out.println(name));
    }
}

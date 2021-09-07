package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的skip方法的作用

    讲解：
        1. skip方法声明如下：
            Stream<T> skip(long n);
                * skip ==> 跳过
                * 将当前流中前n个之后的元素存储到另一个流中
                * n大于等于当前流元素个数则会产生空流
                * n必须大于等于0，否则会抛出异常

    小结：
        1. Stream的skip方法的作用：跳过前n个元素

 */
public class StreamDemo06_Skip {
    public static void main(String[] args){
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        Stream<String> stream = list.stream();
        // 需求：跳过前2个元素
        Stream<String> newStream = stream.skip(-1);
        newStream.forEach(name->System.out.println(name));
    }
}

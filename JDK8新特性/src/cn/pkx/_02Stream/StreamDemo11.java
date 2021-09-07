package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
     目标：收集Stream流的结果

     讲解：
        1. 将Stream流结果收集到集合中
            * 收集Stream流中的元素到List集合中：流对象.collect(Collectors.toList())
            * 收集Stream流中的元素到Set集合中：流对象.collect(Collectors.toSet())

        2. 将Stream流结果收集到数组中
            * 流对象.toArray();
            * 流对象.toArray(数据类型[]::new)

     小结：
        1. 如何将Stream流结果收集到集合中：
            stream对象.collect(Collectors.toList())
            stream对象.collect(Collectors.toSet())

        2. 如何将Stream流结果收集到数组中
            Object[] stream对象.toArray();
            数据类型[] stream对象.toArray(数据类型[]::new)
 */
public class StreamDemo11 {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        // 获得Stream流
        Stream<String> stream = list.stream();
        // ..................

        // 收集流的结果到集合中：List
        // List<String> newList = stream.collect(Collectors.toList());

        // 收集流的结果到集合中：Set
       /* Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set.size());
        for (String s : set) {
            System.out.println(s);
        }*/

        // 收集流的结果到数组中
        /* Object[] objs = stream.toArray();
        for (Object obj : objs) {
            System.out.println(obj);
        }*/

        // 流对象.toArray(数据类型[]::new)
        // 收集流的结果到数组中：字符串数组
        String[] strs = stream.toArray(String[]::new);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}

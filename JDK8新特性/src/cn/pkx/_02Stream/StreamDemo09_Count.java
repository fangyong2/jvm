package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的count方法的作用

    讲解：
        1. count方法声明如下：
            long count(); 用来统计流中元素的个数

    小结：
        1. Stream的count方法的作用：用来获得流元素个数
    
 */
public class StreamDemo09_Count {
    public static void main(String[] args){
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥");

        Stream<String> stream = one.stream();
        System.out.println(stream.count());
    }
}

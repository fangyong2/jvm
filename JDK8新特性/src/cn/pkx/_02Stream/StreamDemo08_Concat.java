package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
    目标：掌握Stream流的concat方法的作用

    讲解：
        1. concat方法声明如下：
            static Stream concat(Stream<T> a,Stream<T> b)
                * 将流a和流b合并成一个流

    小结：
        1. Stream的concat方法的作用：合并流的元素
    
 */
public class StreamDemo08_Concat {
    public static void main(String[] args){
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥");

        List<String> two = new ArrayList<>();
        Collections.addAll(two,  "苏星河", "老子", "庄子", "孙子");

        Stream<String> aStream = one.stream();
        Stream<String> bStream = two.stream();
        Stream<String> cStream = Stream.concat(aStream, bStream);
        cStream.forEach(str->System.out.println(str));

    }
}

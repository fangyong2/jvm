package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
    Stream流的使用注意事项
     * 流一旦调用了终结方法就不能再使用了
     * 流一旦调用了非终结方法产生新流之后，就不能再使用旧流了

    Stream流中方法的分类
        * 终结方法：如果方法的返回值不再是Stream则该方法称为终结方法：forEach/count
        * 非终结方法：方法返回值还是Stream则称为非终结方法：filter/limit/skip/map/concat
 */
public class StreamDemo10 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 添加元素
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        Stream<String> stream = list.stream();
        // 流一旦调用了终结方法就不能再使用了
        // System.out.println(stream.count());

        // stream.forEach(name->System.out.println(name));

        //  流一旦调用了非终结方法产生新流之后，就不能再使用旧流了
        Stream<String> newStream = stream.limit(2);
        System.out.println(newStream.count());
    }
}

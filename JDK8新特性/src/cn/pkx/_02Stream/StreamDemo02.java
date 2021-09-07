package cn.pkx._02Stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流的获取方式
    1. 单列集合流的获取方式
        * Stream<T> 集合对象.stream();

    2. 双列集合流的获取方式
        * 没有方法直接获得Stream流对象
        * 需要将双列集合转换单列集合，然后调用单列集合的stream方法获取

    3. 数组流的获取方式
        * 使用Stream提供静态方法of获取

 */
public class StreamDemo02 {
    public static void main(String[] args) {
        // List集合
        List<String> list = new ArrayList<>();
        // 接口类型 变量名 = 接口实现类对象
        Stream<String> listStream = list.stream();

        // Set集合
        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        // Map集合
        Map<String,String> map = new HashMap<>();
        Set<String> keySet = map.keySet();
        // 获得键集合对应的流
        Stream<String> keySetStream = keySet.stream();
        Collection<String> values = map.values();
        // 获得值集合对应的流
        Stream<String> valueStream = values.stream();

        // 获得Entry对象集合
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Stream<Map.Entry<String, String>> entryStream = entrySet.stream();

        // 数组
        String[] strs = {"a","b"};
        Stream<String> strsStream = Stream.of(strs);

    }
}

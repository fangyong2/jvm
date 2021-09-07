package cn.pkx._02Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream流初体验
     讲解：
        一个ArrayList集合中存储有以下数据:张无忌,周芷若,赵敏,张强,张三丰,
        需求:1.拿到所有姓张的 2.拿到名字长度为3个字的 3.打印这些数据

     小结：
     1. 遍历操作集合的弊端：代码冗余：每次操作集合元素都需要对集合进行遍历
 */
public class StreamDemo01 {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

       /* // 创建集合：存储姓张的
        List<String> zList = new ArrayList<>();
        // 1.拿到所有姓张的
        for (String name : list) {
            // 判断是否以张开头
            if(name.startsWith("张")){
                zList.add(name);
            }
        }
        // 创建集合：存储名字是三个字
        List<String> threeList = new ArrayList<>();
        // 2.拿到名字长度为3个字的
        for (String name : zList) {
            if (name.length() == 3){
                threeList.add(name);
            }
        }

        // 3.打印这些数据
        for (String name : threeList) {
            System.out.println(name);
        }*/

        // 使用stream流实现
        // 1.拿到所有姓张的 2.拿到名字长度为3个字的 3.打印这些数据
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length() == 3)
                .forEach(name->System.out.println(name));
    }
}


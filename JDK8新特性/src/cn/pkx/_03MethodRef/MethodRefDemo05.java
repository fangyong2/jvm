package cn.pkx._03MethodRef;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 方法引用之特定类型实例方法引用

    特定类型实例方法引用概述：通过类名引用类中的非静态方法
    特定类型实例方法引用格式：类名::非静态方法名
    特定类型实例方法引用注意事项：
        1. 被引用的方法要比函数式接口的抽象方法少一个参数
        2. 一定是函数式接口中的抽象方法参数列表的第一个参数调用被引用的方法，
            其他参数作为被引用方法的参数传递
 */
public class MethodRefDemo05 {
    public static void main(String[] args) {
        String[] strs = {"AA","Aa","Bb","Jack","Rose","Mary"};
        // 使用匿名内部类创建比较器对象：对字符串数组元素排序：忽略大小写排序
        /*Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/

        // 使用lambda表达式简化匿名内部
        // Arrays.sort(strs,(o1,o2)-> o1.compareToIgnoreCase(o2));

        // 使用方法引用简化lambda表达式
        /**
         String::compareToIgnoreCase 等价下面代码
         new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        }
         */
        Arrays.sort(strs, String::compareToIgnoreCase);

        for (String str : strs) {
            System.out.println(str);
        }

    }
}

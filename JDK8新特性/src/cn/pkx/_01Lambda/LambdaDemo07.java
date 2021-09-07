package cn.pkx._01Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
  Lambda表达式省略格式
    (参数列表)->{ 方法体 }
        * 参数列表有且只有一个参数，则可以省略小括号
        * 参数数据类型可以省略，随时可以省略
        * 当方法体有且只有一条语句时可以省略大括号，如果省略了大括号则return语句和分号也必须要省略了
 */
interface B{
    void test(int a);
}

public class LambdaDemo07 {
    public static void main(String[] args) {
        // 创建集合存储Person对象
        List<Person> list = new ArrayList<>();
        // 添加Person对象到集合中
        list.add(new Person("jack", 20));
        list.add(new Person("rose", 18));
        list.add(new Person("lily", 25));

        // 标准格式：使用lambda表达式简化
        /*Collections.sort(list,(Person o1,Person o2)->{
            return o1.getAge() - o2.getAge();
        });*/

        // 省略格式
        Collections.sort(list,(o1,o2)-> o1.getAge() - o2.getAge());

        for (Person person : list) {
            System.out.println(person);
        }

        // 使用lambda作为方法参数：调用testB
        // void test(int a);
        testB(a ->System.out.println(a));
    }

    public static void testB(B b){

    }
}

package cn.pkx._01Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
  Lambda表达式作为方法参数

  当方法参数类型是一个接口且接口中有且只有一个抽象方法时就可以使用lambda表达式作为方法参数传递。
  需求：定义一个Person类：姓名和年龄，创建多个Person对象存储到集合中，对集合Person对象进行排序
    ：按照年龄升序排。
 */
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class LambdaDemo05 {
    public static void main(String[] args) {
        // 创建集合存储Person对象
        List<Person> list = new ArrayList<>();
        // 添加Person对象到集合中
        list.add(new Person("jack", 20));
        list.add(new Person("rose", 18));
        list.add(new Person("lily", 25));

        System.out.println("排序前");
        for (Person person : list) {
            System.out.println(person);
        }
        // 对集合Person对象进行排序：按照年龄升序排
        // 使用匿名内部类实现
       /* Collections.sort(list,new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        // 使用lambda表达式简化
        Collections.sort(list,(Person o1, Person o2)->{
            return o1.getAge() - o2.getAge();
        });

        System.out.println("排序后...");
        for (Person person : list) {
            System.out.println(person);
        }
    }
}

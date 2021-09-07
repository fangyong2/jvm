package cn.pkx._01Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
  Lambda表达式作为方法返回值

  当方法返回值类型是一个接口且接口有且只有一个抽象方法时就可以使用lambda作为方法的返回值
 */
public class LambdaDemo06 {

    public static Comparator<Person> newComparator(){
        // 使用匿名内部创建接口实现类对象
        /*return new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        };*/
        // 使用lambda表达式作为方法返回值
        return (Person o1, Person o2)->{
            return o1.getAge() - o2.getAge();
        };
    }

    public static void main(String[] args) {
        // 创建集合存储Person对象
        List<Person> list = new ArrayList<>();
        // 添加Person对象到集合中
        list.add(new Person("jack", 20));
        list.add(new Person("rose", 18));
        list.add(new Person("lily", 25));

        // 使用lambda表达式简化
        Collections.sort(list,newComparator());

        for (Person person : list) {
            System.out.println(person);
        }
    }
}

package cn.pkx._03MethodRef;

import java.util.Random;

/**
 * 方法引用之对象方法引用

    对象方法引用概述：通过对象名来引用已存在的方法来简化Lambda表达式，类似通过对象调用方法(非静态方法)
    对象方法引用格式：对象名::方法名
    对象方法引用注意事项：
     1. 被引用的方法和函数式接口的抽象方法必须有相同的参数列表
     2. 如果函数式接口的抽象方法有返回值类型，则被引用的方法必须有相同的返回值类型
     3. 如果函数式接口的抽象方法没有返回值类型，则被引用的方法可以有返回值，也可以没有返回值。

 */
public class MethodRefDemo03 {
    public static void main(String[] args) {
        // 需求：调⽤ NumHelper 接⼝中的⽅法⽣成100到200之间的随机数
        // 方式1：使用匿名内部创建NumHelper接口实现类对象
        NumHelper nh01 = new NumHelper() {
            // 返回a到b之间的随机数
            @Override
            public int nextAToB(int a, int b) {
                // 创建随机数对象
                Random r = new Random();
                return r.nextInt(b - a + 1) + a;
            }
        };
        System.out.println(nh01.nextAToB(100, 200));

        // 方式2：使用Lambda表达式简化
        NumHelper nh02 = (a,b)->{
            // 创建随机数对象
            Random r = new Random();
            return r.nextInt(b - a + 1) + a;
        };
        System.out.println(nh02.nextAToB(100, 200));

        // 方式3：在Lambda表达式中调用已经存在的方法
        // 创建自定义随机类对象
        MyRandom random = new MyRandom();
        NumHelper nh03 = (a,b)-> random.nextIntAToB(a, b);
        System.out.println(nh03.nextAToB(100, 200));

        // 方式4：使用方法引用简化Lambda表达式
        /**
         NumHelper nh04 = random::nextIntAToB;等价下面代码
         1. 创建类实现NumHelper接口
            class Yyy implements NumHelper{
                2. 重写接口的方法
                public int nextAToB(int a,int b) {
                    3. 在重写的方法中调用被引用对象的方法
                    return random.nextIntAToB(a,b);
                }
         }
         4. 创建接口实现类对象
         NumHelper nh04 = new Yyy();
         int num = nh04.nextAToB(100, 200);

         */
        NumHelper nh04 = random::nextIntAToB;
        System.out.println(nh04.nextAToB(100, 200));
    }
}

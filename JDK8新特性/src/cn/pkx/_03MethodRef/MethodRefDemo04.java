package cn.pkx._03MethodRef;

/**
 * 方法引用之构造方法引用

    构造方法引用的概念：通过类名引用类的构造方法来简化Lambda表达式
    构造方法引用的格式：类名::new
    构造方法引用注意事项：被引用的类中必须有一个构造方法的参数列表和函数式接口的抽象方法抽象列表一致
 */
public class MethodRefDemo04 {
    public static void main(String[] args) {
        // 需求：调用CarFactory接口中的方法生产一部汽车
        // 方式1：使用匿名内部类创建接口实现类对象
        CarFactory cf01 = new CarFactory(){
            @Override
            public Car makeCar(String brand) {
                return new Car(brand);
            }
        };
        System.out.println(cf01.makeCar("宝马"));

        // 方式2：使用lambda表达式简化匿名内部类
        CarFactory cf02 = brand -> new Car(brand);
        System.out.println(cf02.makeCar("奥迪"));


        // 方式3：使用构造方法引用简化lambda表达式
        /**
         CarFactory cf03 = Car::new 等价下面代码
            CarFactory cf03 = new CarFactory(){
                @Override
                public Car makeCar(String brand) {
                    return new Car(brand);
                }
            };
         */
        CarFactory cf03 = Car::new;
        System.out.println(cf03.makeCar("奔驰"));
    }
}

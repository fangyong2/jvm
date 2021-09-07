package cn.pkx._03MethodRef;

/**
 * 方法引用之静态方法引用

    静态方法引用的概念：通过类名引用静态方法来简化Lambda表达式

    静态方法引用的格式：类名::静态方法名

    静态方法引用注意事项：
        1. 被引用的方法和函数式接口的抽象方法必须有相同的参数列表
        2. 如果函数式接口的抽象方法有返回值类型，则被引用的方法必须有相同的返回值类型
        3. 如果函数式接口的抽象方法没有返回值类型，则被引用的方法可以有返回值，也可以没有返回值。
 */
public class MethodRefDemo02 {
    public static void main(String[] args) {
        // 需求：定义整形数组，然后调用ArrayHelper接口中的方法获得数组的最大值
        // 定义整形数组
        int[] arr = {1,3,4,5,45};

        // 使用匿名内部类创建ArrayHelper接口实现类对象
        ArrayHelper ah01 = new ArrayHelper() {
            @Override
            public int maxValue(int[] arr) {
                // 定义变量接收数组的最大值
                int max = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > max){
                        max = arr[i];
                    }
                }
                return max;
            }
        };
        // 调用ah01对象的方法获得数组的最大值
        int maxValue01 = ah01.maxValue(arr);
        System.out.println(maxValue01);

        // 使用lambda表达式简化匿名内部类
        ArrayHelper ah02 = newArr ->  {
            // 定义变量接收数组的最大值
            int max = newArr[0];
            for (int i = 1; i < newArr.length; i++) {
                if (newArr[i] > max){
                    max = newArr[i];
                }
            }
            return max;
        };
        // 调用ah02对象的方法获得数组的最大值
        int maxValue02 = ah02.maxValue(arr);
        System.out.println(maxValue02);

        // 在lambda表达式中调用工具类的方法求数组最大值
        ArrayHelper ah03 = newArray -> ArrayUtils.getMax(newArray);
        // 调用ah02对象的方法获得数组的最大值
        int maxValue03 = ah03.maxValue(arr);
        System.out.println(maxValue03);

        // 使用静态方法引用简化Lambda表达式
        /**
            ArrayHelper ah04 = ArrayUtils::getMax;

            ArrayUtils::getMax 等价下面代码
            1. 创建一个类实现ArrayHelper接口
                class Xxx implements ArrayHelper{
                    2. 重写接口的方法
                    public void maxValue(int[] arr){
                        5. 调用引用的静态方法
                        return ArrayUtils.getMax(arr);
                    }
                }

            2. 创建实现类对象
                ArrayHelper ah04 = new Xxx();

            4. 调用ah04对象的方法
                int maxValue04 = ah04.maxValue(arr);
         */
        ArrayHelper ah04 = ArrayUtils::getMax;
        // 调用ah04对象的方法获得数组的最大值
        int maxValue04 = ah04.maxValue(arr);
        System.out.println(maxValue04);
    }
}

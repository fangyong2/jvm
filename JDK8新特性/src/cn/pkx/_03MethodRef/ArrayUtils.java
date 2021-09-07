package cn.pkx._03MethodRef;

/**
 * 数组的工具类
 */
public class ArrayUtils {
    // 定义静态方法：返回数组的最大值
    public static int getMax(int[] arr){
        // 定义变量接收数组的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}

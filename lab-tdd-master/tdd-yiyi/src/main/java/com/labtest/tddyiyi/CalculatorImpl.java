package com.labtest.tddyiyi;

/**
 * @Author fy
 * @Date 2019/1/10 9:32
 **/
public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int begin, int end) {

        // 版本1：有个bug
        /*int result = 0;
        for( int i = begin; i <= end; i++){
            result += i;
        }
        return result;*/

        // 版本2：修改了版本1的bug，但存在效率差问题
        /*if (begin > end){
            return sum(end, begin);
        }
        if (begin == end){
            return begin + end;
        }
        int result = 0;
        for( int i = begin; i <= end; i++){
            result += i;
        }
        return result;*/

        // 版本3
        // 1.大于
        if (begin > end){
            return sum(end, begin);
        }
        // 2.等于
        if (begin == end){
            return begin + end;
        }
        // 3.小于
        // 算出总共多少个整数
        int count = end - begin + 1;

        // 3.1 奇数个
        if (count % 2 == 1){
            return sum(begin, end - 1) + end;
        }
        // 3.2 偶数个
        return (begin + end) * count / 2;
    }

    public static void main(String[] args){
        // 测试前准备数据
        CalculatorImpl calculator = new CalculatorImpl();
        int failCount = 0;
        int passCount = 0;

        // 写测试用例进行测试
        if (calculator.sum(1, 1) == 2) {
            System.out.println("测试成功!");
            passCount++;
        } else {
            System.out.println("测试失败!");
            failCount++;
        }

        if (calculator.sum(1, 10) == 55) {
            System.out.println("测试成功!");
            passCount++;
        } else {
            System.out.println("测试失败!");
            failCount++;
        }

        if (calculator.sum(10, 1) == 55) {
            System.out.println("测试成功!");
            passCount++;
        } else {
            System.out.println("测试失败!");
            failCount++;
        }

        if (calculator.sum(-10, 10) == 0) {
            System.out.println("测试成功!");
            passCount++;
        } else {
            System.out.println("测试失败!");
            failCount++;
        }

        // 输出测试报告
        System.out.println(String.format("总共测试%s次：成功%s次，失败%s次",
                passCount + failCount, passCount, failCount));


        // 存在问题：
        // 第一： 测试代码和产品代码混在一起  >> 将测试代码独立出来，要有可以运行，定时、周期、自动化运行
        // 第二： 测试代码比较繁琐，代码太累 >> 系统能有个框架能将测试代码规范化、结构化管理
        // 第三： 代码性能如何？需要自己写耗时计算等

        // 那么，我们来看使用测试类是如何解决这些问题的，选择要测试的类，按Alt+Enter快捷键，选中Create Test...
    }

}

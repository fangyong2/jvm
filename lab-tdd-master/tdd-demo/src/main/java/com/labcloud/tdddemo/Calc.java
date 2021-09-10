package com.labcloud.tdddemo;

import com.labcloud.tdddemo.intf.ICalc;

/**
 * @Author 方勇
 * @create 2019-01-09 22:34
 *
 * 估值一个亿计算器：有张三开发
 *
 */
public class Calc implements ICalc {

    public int add(int a, int b){
        return a + b;
    }

    // 0.假设【单元测试】还没有出生（发明），我们要怎么做代码测试？
    public static void main(String[] args){

        // 1、测试前：准备要测试内容
        beforeTest();

        // 2、测试内容：多个测试用例对功能的正确性、性能进行测试
        doTest();

        // 3、测试结束后：测试报告
        afterTest();

        // 思考下有什么问题？
        thinking();
    }

    static Calc calc;
    static int error;
    static int total;

    private static void beforeTest(){
        calc = new Calc();
        error = 0;
        total = 0;
    }

    private static void doTest(){
        // 测试用例一
        if (calc.add(1, 1) == 2){
            System.out.println("测试通过");
        }else{
            System.out.println("测试不通过!");
            error++;
        }
        total++;

        // 测试用例二
        if (calc.add(2, 2) == 4){
            System.out.println("测试通过");
        }else{
            System.out.println("测试不通过!");
            error++;
        }
        total++;

        // 测试用例三
        if (calc.add(2, 2) == 4){
            System.out.println("测试通过");
        }else{
            System.out.println("测试不通过!");
            error++;
        }
        total++;
    }

    private static void afterTest(){
        // 计算下通过率，将测试报告发送邮件给领导
        System.out.println(String.format("报告老板，总共测试了%s个，成功%s个，失败%s个，通过率是%s",
                total, total - error, error, 100 - error * 100 / total));
    }

    private static void thinking(){
        // 存在两个问题：
        // 第一： 测试代码和产品代码混在一起  >> 将测试代码独立出来，要有可以运行，定时、周期、自动化运行
        // 第二： 测试代码比较繁琐，代码太累 >> 系统能有个框架能将测试代码规范化、结构化管理

        // 那么，我们来看CalcTest这个测试类是解决这些问题的
    }


}

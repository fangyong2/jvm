package com.labtest.tddyiyi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class CalculatorImplTest {

    private CalculatorImpl calculator;

    /**
     * 测试前：准备测试环境+需要测试的对象
     */
    @BeforeClass
    private void beforeTest(){
        calculator = new CalculatorImpl();
    }

    /**
     * 测试中：执行测试内容
     * 1、测试用例传递参数
     * 2、批量次数时，使用线程池，
     */
    @Test(dataProvider = "testCase", invocationCount = 100, threadPoolSize = 10)
    public void testSum(int begin, int end, int result) {
        assertThat(String.format("%s ~ %s = %s >> 测试失败！", begin, end, result),
                calculator.sum(begin, end), equalTo(result));
    }

    /**
     * 准备测试用例
     * @return
     */
    @DataProvider(name = "testCase")
    private Object[][] testCase(){
        return new Object[][]{
                {-1, -1, -2},
                {0, 0, 0},
                {1, 1, 2},
                {1, 10000, 50005000},
                {10000, 1, 50005000},
                {-100, 100, 0}
        };
    }

    /**
     * 测试后：发送测试报告
     */
    @AfterClass
    private void afterTest(){
        System.out.println("导出测试报告，并通过邮件发送测试报告!");
        /**
         * 总结 >> 通过这个案例我们学会了单元测试 50% 的知识了，厉不厉害，牛不牛逼？ 哈哈
         * 1、单元测试重点：自动化、彻底的、可重复、独立性、专业性
         * 2、牛逼的测试框架testNg
         * 3、强大hamcrest断言器，单骑走天下（assertThat）
         */
    }
}
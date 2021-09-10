package com.labtest.tddyiyi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author fy
 * @Date 2019/1/10 11:03
 * 估值两个亿的Ai计算器：安排由李四开发，李四打算换个思路写代码：先写测试代码再写产品代码
 **/
public class AiCalculatorImplTest {

    private AiCalculator aiCalculator;
    private Calculator calculator;

    @BeforeClass
    private void beforeTest(){
        aiCalculator = new AiCalculatorImpl();
        calculator = mock(Calculator.class);
        // 模拟对象
        aiCalculator.setCalculator(calculator);
    }

    /**
     * 多测试用例测试
     * @param begin
     * @param end
     * @param mockSum
     * @param div
     * @param result
     */
    @Test(dataProvider = "testCase")
    public void testDivBySum(int begin, int end, int mockSum, int div, int result){
        // 模拟对象行为
        // 我们去模拟接口的返回，并不是去把其他模块的逻辑写一遍
        // 通常是将准备好的常量来替换--mockSum
        when(calculator.sum(begin, end)).thenReturn(mockSum);
        int testValue = aiCalculator.divBySum(begin, end, div);
        assertThat(String.format("%s ~ %s / div >> %s: 测试失败!", begin, end, div, result),
                testValue, equalTo(result));
    }

    /**
     * 除零异常
     */
    @Test(expectedExceptions = java.lang.ArithmeticException.class)
    public void testDivZero(){
        aiCalculator.divBySum(1, 1, 0);
    }

    @DataProvider(name = "testCase")
    public Object[][] testCase(){
        return new Object[][]{
                {1, 1, 2, 1, 2},
                {2, 2, 4, 2, 2}
        };
    }

    @AfterClass
    private void afterTest(){
        System.out.println("发送测试报告!");
    }
}

package com.labtest.tddzizi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author SuJianFeng
 * @Date 2019/1/10 15:42
 **/
public class AiCalculatorImpTest {


    @BeforeClass
    private void beforeTest(){

    }

    @Test(dataProvider = "testCase", invocationCount = 2, threadPoolSize = 2)
    public void testDivBySum(int begin, int end, int mockResult, int div, int result){
        AiCalculator aiCalculator = new AiCalculatorImp();
        Calculator calculator = mock(Calculator.class);
        aiCalculator.setCalculator(calculator);
        //模拟行为
        when(calculator.sum(begin, end)).thenReturn(mockResult);
        assertThat(String.format("%s ~ %s / %s = %s, 测试失败!", begin, end, div, result),
                aiCalculator.divBySum(begin, end, div), equalTo(result));
    }

    @DataProvider(name = "testCase")
    public Object[][] testCase(){
        return new Object[][]{
                {1, 1, 2, 2, 1},
                {1, 100, 5050, 2, 5050 / 2},
                {-100, 100, 0, 100, 0}
        };
    }

    @Test(expectedExceptions = java.lang.ArithmeticException.class)
    public void testDivZero(){
        AiCalculator aiCalculator = new AiCalculatorImp();
        Calculator calculator = mock(Calculator.class);
        aiCalculator.setCalculator(calculator);
        when(calculator.sum(1, 1)).thenReturn(1);
        aiCalculator.divBySum(1, 1, 0);
    }

    @AfterClass
    private void afterTest(){
        //
    }
}

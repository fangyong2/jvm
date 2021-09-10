package com.labtest.tddzizi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class CalculatorImplTest {

    private CalculatorImpl calculator;

    @BeforeClass
    private void beforeTest(){
        calculator = new CalculatorImpl();
    }

    @Test(dataProvider = "testCase")
    public void testSum(int begin, int end, int result) {
        assertThat("测试失败！", calculator.sum(begin, end), equalTo(result));
    }

    @DataProvider(name = "testCase")
    public Object[][] testCase(){
        return new Object[][]{
                {1, 1, 2},
                {1, 100, 5050},
                {100, 1, 5050},
                {-100, 100, 0},
                {-100, -99, -199},
                {1, 10000, 50005000}
        };
    }

    @AfterClass
    public void afterTest(){
        System.out.println("发送报告！");
    }
}
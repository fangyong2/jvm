package com.labcloud.tdddemo;

import com.labcloud.tdddemo.intf.ICalc;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author fy
 * @create 2019-01-09 23:53
 *
 * 估值两个亿的Ai计算器：安排由李四开发，李四打算换个思路写代码：先写测试代码再写产品代码
 *
 */
public class CalcAiTest {

    private CalcAi calcAi;
    private ICalc calc;

    @BeforeClass
    public void beforeTest(){
        calcAi = new CalcAi();
        calc = mock(ICalc.class);
        calcAi.setCalc(calc);
    }

    @Test(dataProvider = "testCase")
    public void doTest(int a, int b, int mockAddResult, int x, int r){
        // 这里特别说明下，我们去模拟接口的返回，并不是去把其他模块的逻辑写一边（比如这里写a + b作为模拟结果是不合理），
        // 通常是准备常量来替换--比如mockAddResult
        when(calc.add(a, b)).thenReturn(mockAddResult); //threnReturn不能写a + b，这个是小张干的活
        assertThat("算错了，老兄!", calcAi.divByAdd(a, b, x), equalTo(r));
    }

    @DataProvider(name = "testCase")
    public Object[][] testCase(){
        return new Object[][]{
                {1, 1, 2, 2, 1},
                {2, 2, 4, 2, 2},
                {3, 3, 6, -1, -6}
        };
    }


    @AfterClass
    public void afterTest(){

    }
}

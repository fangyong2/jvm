package com.labcloud.tdddemo;

import com.labcloud.tdddemo.intf.ICalc;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author fy
 * @create 2019-01-09 22:57
 */
public class CalcTest {

    private ICalc calc;

    /**
     * 1、测试前：准备要测试内容
     */
    @BeforeClass
    public void beforeTest(){
        calc = new Calc();
    }

    /**
     * 2、测试内容：多个测试用例对功能的正确性、性能进行测试
     */
    @Test(dataProvider = "testCase")
    public void addTest(int a, int b, int c){
        assertThat("他妈的！！！怎么简单都算错！！", calc.add(a, b), equalTo(c));
    }

    /**
     * 2.1 准备测试用例
     * @return
     */
    @DataProvider(name="testCase")
    public Object[][] testCase(){
        return new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {3, 3, 6},
                {-1, 1, 0}
        };
    }

    /**
     * 3、测试结束后：测试报告
     */
    @AfterClass
    public void afterTest(){
        System.out.println("将test-out目录下的发送报告发送给老板！");

        /**
         * 知识延伸出一下：
         *
         * （1）导出测试报告
         * （2）全面了解下testNg
         * （3）全面了解下hamcrest
         *
         */


        /**
         * 总结 >> 通过这个案例我们学会了单元测试 50% 的知识了，厉不厉害，牛不牛逼？ 哈哈
         * 1、单元测试重点：自动化、彻底的、可重复、独立性、专业性
         * 2、牛逼的测试框架testNg：优先级、分组、测试依赖、测试报告
         * 3、强大hamcrest断言器，单骑走天下（assertThat）
         */
    }

}

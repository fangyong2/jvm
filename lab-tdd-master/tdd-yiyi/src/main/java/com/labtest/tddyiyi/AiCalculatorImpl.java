package com.labtest.tddyiyi;

/**
 * @Author fy
 * @Date 2019/1/10 11:14
 **/
public class AiCalculatorImpl implements AiCalculator {

    // 要使用到 张三负责的模块
    private Calculator calculator;

    @Override
    public int divBySum(int begin, int end, int div) {
        // 这时张三还没开发完，测试报空指针的错误，这时怎么办呢？
        return calculator.sum(begin, end) / div;
    }

    @Override
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}

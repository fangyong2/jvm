package com.labtest.tddzizi;

import sun.util.calendar.CalendarUtils;

/**
 * @Author SuJianFeng
 * @Date 2019/1/10 15:49
 **/
public class AiCalculatorImp implements AiCalculator {

    private Calculator calculator;

    @Override
    public int divBySum(int begin, int end, int div) {
        return calculator.sum(begin, end) / div;
    }

    @Override
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}

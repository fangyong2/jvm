package com.labcloud.tdddemo;

import com.labcloud.tdddemo.intf.ICalc;
import com.labcloud.tdddemo.intf.ICalcAi;

/**
 * @Author 方勇
 * @create 2019-01-09 23:42
 *
 * 估值两个亿的Ai计算器：李四先写测试代码后，才到这里写产品代码
 *
 */
public class CalcAi implements ICalcAi {

    /**
     * 实现这样括号计算功能:
     * 前辈告诉我们，不要重复造轮子，所以呢，我们要把那个估值一个亿的计算器拿过来用
     * @param a
     * @param b
     * @param x
     * @return (a + b) / x
     */
    public int divByAdd(int a, int b, int x){
        return calc.add(a, b) / x;
    }

    private ICalc calc;
    public ICalc getCalc() {
        return calc;
    }
    public void setCalc(ICalc calc) {
        this.calc = calc;
    }

    /**
     * 我们已经学习过了单元测试，那么我绝不会傻到还在这里写测试代码，哼！
     * @param args
     */
    public static void main(String[] args){
        // main方法被无情的抛弃了....
    }
}

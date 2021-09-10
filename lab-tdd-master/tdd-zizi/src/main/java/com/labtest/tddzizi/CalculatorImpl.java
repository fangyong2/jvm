package com.labtest.tddzizi;

/**
 * @Author SuJianFeng
 * @Date 2019/1/10 15:13
 **/
public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int begin, int end) {
        int result = 0;
        if (begin == end){
            return begin + end;
        }
        if (begin > end){
            return sum(end, begin);
        }
        /*for (int i = begin; i <= end; i++){
            result += i;
        }*/

        int size = end - begin + 1;
        if (size % 2 == 0){
            return (begin + end) * size / 2;
        }
        return (begin + end - 1) * size / 2 + end;
    }

    public static void main(String[] args){
        //测试前的准备
        CalculatorImpl calculator = new CalculatorImpl();

        //测试过程
        int failSize = 0;
        int passSize = 0;

        if (calculator.sum(1, 1) == 1){
            passSize++;
        }else{
            failSize++;
        }
        if (calculator.sum(-1, 1) == 0){
            passSize++;
        }else{
            failSize++;
        }

        if (calculator.sum(100, 1) == 5050){
            passSize++;
        }else{
            failSize++;
        }

        if (calculator.sum(1, 100) == 5050){
            passSize++;
        }else{
            failSize++;
        }

        //测试后：汇报测试结果
        System.out.println(String.format("total: %s, pass: %s, fail: %s",
                passSize + failSize, passSize, failSize));


    }
}

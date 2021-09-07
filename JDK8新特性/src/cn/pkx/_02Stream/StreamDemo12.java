package cn.pkx._02Stream;

import java.util.stream.LongStream;

/**
 * 串行流和并行流
    串行流：所有数据操作在同一个线程中，通过stream()方法获得。
    并行流：将数据分成多块并在不同的线程分别处理每一块数据，通过parallelStream()方法获得

    小结：
        如果数据量不大，则推荐使用串行流，否则推荐使用并行流
 */
public class StreamDemo12 {

    public static void main(String[] args) {
        test01();
        test02();
    }
    /**
     * 测试⽤串⾏流计算0到2千万的和
     */
    public static void test01(){
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L, 2000000000L).sum();
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start)); //6610
    }
    /**
     * 测试⽤并⾏流计算0到2千万的和
     */
    public static void test02(){
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L, 2000000000L).parallel().sum();
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start)); //1813
    }
}

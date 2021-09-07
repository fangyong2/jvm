package cn.pkx._03MethodRef;

@FunctionalInterface
public interface CarFactory {
    // 生产对应品牌的汽车
    Car makeCar(String brand);
}

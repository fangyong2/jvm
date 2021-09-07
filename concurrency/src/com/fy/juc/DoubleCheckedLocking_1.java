package com.fy.juc;
//在实现单例模式时，如果未考虑多线程的情况，就容易写出下面的错误代码：
public class DoubleCheckedLocking_1 {

}

class Singleton {
    private static Singleton uniqueSingleton;

    private Singleton() {
    }

    public Singleton getInstance() {
        if (null == uniqueSingleton) {
            uniqueSingleton = new Singleton();
        }
        return uniqueSingleton;
    }
}

//这样虽然解决了问题，但是因为用到了synchronized，会导致很大的性能开销，
//并且加锁其实只需要在第一次初始化的时候用到，之后的调用都没必要再进行加锁。
//class Singleton {
//    private static Singleton uniqueSingleton;
//
//    private Singleton() {
//    }
//
//    public synchronized Singleton getInstance() {
//        if (null == uniqueSingleton) {
//            uniqueSingleton = new Singleton();
//        }
//        return uniqueSingleton;
//    }
//}

//双重检查锁（double checked locking）是对上述问题的一种优化。先判断对象是否已经被初始化，再决定要不要加锁。
//class Singleton {
//    private static Singleton uniqueSingleton;
//
//    private Singleton() {
//    }
//
//    public Singleton getInstance() {
//        if (null == uniqueSingleton) {
//            synchronized (Singleton.class) {
//                if (null == uniqueSingleton) {
//                    uniqueSingleton = new Singleton();   // error
//                }
//            }
//        }
//        return uniqueSingleton;
//    }
//}


/*隐患
        上述写法看似解决了问题，但是有个很大的隐患。实例化对象的那行代码（标记为error的那行），实际上可以分解成以下三个步骤：

        分配内存空间
        初始化对象
        将对象指向刚分配的内存空间
        但是有些编译器为了性能的原因，可能会将第二步和第三步进行重排序，顺序就成了：

        分配内存空间
        将对象指向刚分配的内存空间
        初始化对象
*/

//现在考虑重排序后，两个线程发生了以下调用：
//
//        Time	        Thread A	            Thread B
//        T1	    检查到uniqueSingleton为空
//        T2	    获取锁
//        T3	    再次检查到uniqueSingleton为空
//        T4	    为uniqueSingleton分配内存空间
//        T5	    将uniqueSingleton指向内存空间
//        T6		                                检查到uniqueSingleton不为空
//        T7		                                访问uniqueSingleton（此时对象还未完成初始化）
//        T8	初始化uniqueSingleton
//在这种情况下，T7时刻线程B对uniqueSingleton的访问，访问的是一个初始化未完成的对象。

//正确的双重检查锁,使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前。
//class Singleton {
//    private volatile static Singleton uniqueSingleton;
//
//    private Singleton() {
//    }
//
//    public Singleton getInstance() {
//        if (null == uniqueSingleton) {
//            synchronized (Singleton.class) {
//                if (null == uniqueSingleton) {
//                    uniqueSingleton = new Singleton();
//                }
//            }
//        }
//        return uniqueSingleton;
//    }
//}

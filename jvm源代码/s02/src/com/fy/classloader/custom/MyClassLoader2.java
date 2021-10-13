package com.fy.classloader.custom;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;


/**
 * 自定义ClassLoader三要素:
 * 1. 继承自ClassLoader,重写findClass()
 * 2. 获取字节码二进制流
 * 3. defineClass加载生成Class实例
 */
public class MyClassLoader2 extends ClassLoader {
    private final String CLASS_PATH = "/Users/fangyong/work/2021/1012-1015-爱立信-Java Advanced Programming/day2/jvm源代码/out/production/s01/com/fy/bytecode/ConstantPoolSample.class" ;
    protected Class<?> findClass(String name) {
        try {
            FileInputStream in = new FileInputStream(this.CLASS_PATH) ;
            ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
            byte[] buf = new byte[1024] ;
            int len = -1 ;
            while((len = in.read(buf)) != -1){
                baos.write(buf , 0 , len);
            }
            in.close();
            byte[] classBytes = baos.toByteArray();
            return defineClass(null, classBytes , 0 , classBytes.length) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }
}
package com.sangsang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 哑巴湖大水怪
 * @Date 2021/1/24 21:26
 * @Version 1.0
 * 测试反射调用的时间和直接调用的时间差距
 */
public class reflectTimeTest {
    public static void method1(){
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    public static void  method2(){
    try {
        Thread.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int count = 10000;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i <count ; i++) {
            Method method1 = reflectTimeTest.class.getMethod("method2");
            method1.invoke(null);
        }
        long t2 = System.currentTimeMillis();
        for (int i = 0; i <count ; i++) {
            method2();
        }
        long t3 = System.currentTimeMillis();
        System.out.println("反射执行时间"+ (t2-t1));
        System.out.println("直接调用执行时间"+ (t3-t2));
    }
}

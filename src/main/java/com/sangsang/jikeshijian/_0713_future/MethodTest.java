package com.sangsang.jikeshijian._0713_future;

import org.junit.Test;

import java.util.concurrent.*;


public class MethodTest {
    class Task1 implements Callable {
        @Override
        public Object call() throws Exception {
            Thread.sleep(500);
            System.out.println("取茶");
            Thread.sleep(1000);
            System.out.println("洗茶壶");
            return "茶壶 + 茶叶";
        }
    }

    class Task2 implements Callable {
        @Override
        public Object call() throws Exception {
            Thread.sleep(1500);
            System.out.println("烧水");
            return "开水";
        }
    }
    @Test
    public void test1() throws Exception {
        FutureTask f1 = new FutureTask(new Task1());
        FutureTask f2 = new FutureTask(new Task2());
        new Thread(f1).start();
        new Thread(f2).start();
        System.out.println("开始泡茶  " + f1.get() + f2.get());
    }
}

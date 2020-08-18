package com.sangsang.jikeshijian._0714_CompletionService;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 需求：
 * 先向三个电商系统查询价格，再将价格保存到数据库
 * <p>
 * 方式1：利用future的get()阻塞获取结果
 *
 * 问题：如果电商1的获取价格很慢的话就会阻塞在f1.get()上
 * 影响之后的保存操作
 */
public class Beijing1 {
    public void xunjia1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> f1 = executorService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("获取了1的价格");
            return "电商1的价格";
        });
        Future<String> f2 = executorService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("获取了2的价格");
            return "电商2的价格";
        });
        Future<String> f3 = executorService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("获取了3的价格");
            return "电商3的价格";
        });

        String s1 = f1.get();
        System.out.println("保存  " + s1);
        String s2 = f2.get();
        System.out.println("保存  " + s2);
        String s3 = f3.get();
        System.out.println("保存  " + s3);
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        xunjia1();
    }
}

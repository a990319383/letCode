package com.sangsang.jikeshijian._0714_CompletionService;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 还是执行同样的操作
 * 这里使用CompletionService
 */
public class Beijing3CompletionService {
    public void xunjia3() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(executor);
        executorCompletionService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("获取了1的价格");
            return "电商1的价格";
        });
        executorCompletionService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("获取了2的价格");
            return "电商2的价格";
        });
        executorCompletionService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("获取了3的价格");
            return "电商3的价格";
        });
        for (int i = 0; i <3 ; i++) {
            String s = executorCompletionService.take().get();
            System.out.println("保存  " + s);
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        xunjia3();
    }
}

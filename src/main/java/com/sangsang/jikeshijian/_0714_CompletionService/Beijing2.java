package com.sangsang.jikeshijian._0714_CompletionService;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 需求：
 * 先向三个电商系统查询价格，再将价格保存到数据库
 * <p>
 * 方式2：利用future的get()阻塞获取结果
 * 在1的基础上添加一个阻塞队列，消费获取到的接口再保存
 * <p>
 * 问题：如果电商1的获取价格很慢的话就会阻塞在f1.get()上
 * 影响之后的保存操作
 */
public class Beijing2 {
    //存放获取到的结果
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(6);

    public void xunjia2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
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
        //新创建3个线程将结果存放到阻塞队列中
        executorService.submit(() -> {
            try {
                queue.add(f1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                queue.add(f2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                queue.add(f3.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        while (true) {
            for (int i = 0; i < queue.size(); i++) {
                String s = queue.take();
                System.out.println("保存  " + s);

            }
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        xunjia2();
    }
}

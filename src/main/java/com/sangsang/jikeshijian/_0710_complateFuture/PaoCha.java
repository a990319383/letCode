package com.sangsang.jikeshijian._0710_complateFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 泡茶
 * 流程：
 * 任务 1 负责洗水壶、烧开水
 * 任务 2 负责洗茶壶、洗茶杯和拿茶叶
 * 任务 3 负责泡茶
 * 其中任务 3 要等待任务 1 和任务 2 都完成后才能开始
 */

public class PaoCha {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();//开始时间
        CompletableFuture f1 = CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("任务1  开始洗水壶");
                        Thread.sleep(1000);
                        System.out.println("任务1  开始烧开水");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        CompletableFuture f2 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("任务2  开始洗茶壶");
                Thread.sleep(2000);
                System.out.println("任务2  开始洗茶杯,拿茶叶");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture.allOf(f1, f2).join();
        CompletableFuture<String> f4 = CompletableFuture.supplyAsync(() -> {
            return "111";
        });
      /*  CompletableFuture completableFuture = f1.thenCombine(f2, (a,b) -> {
            try {
                System.out.println("任务3  开始泡茶");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });*/
        CompletableFuture f3 = f1.runAfterBoth(f2, () -> {
            try {
                System.out.println("任务3  开始泡茶");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        f3.join();
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("花费时间：---- "+ (endTime - startTime));
        CompletableFuture<Void> exceptionally = CompletableFuture.runAsync(() -> {
            System.out.println(1 / 0);
        }).exceptionally((e) -> {
            System.out.println(e);
            return null;
        });
    }
}

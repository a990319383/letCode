package com.sangsang.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;

public class CountDownLatchUtil {
    private CountDownLatch start;
    private CountDownLatch end;
    private int pollSize = 8;

    public CountDownLatchUtil() {
        this(8);
    }

    // pollSize是线程数，指定计数的次数，设置了就不能做修改，CyclicBarrier类才可以做出修改
    public CountDownLatchUtil(int pollSize) {
        this.pollSize = pollSize;
        start = new CountDownLatch(1);
        end = new CountDownLatch(pollSize);
    }

    /**
     * @param functionalInterface 进行测试的方法
     * @throws InterruptedException
     */
    public void latch(MyFunctionalInterface functionalInterface) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        for (int i = 0; i < pollSize; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();//当计数是0时才会执行
                        functionalInterface.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            forkJoinPool.submit(run);//利用线程池执行所有线程
        }
        start.countDown();//计数减1
        end.await();
        forkJoinPool.shutdown();
    }

    @FunctionalInterface
    public interface MyFunctionalInterface {
        void run();
    }
}

package com.sangsang.thread.threadPool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author 哑巴湖大水怪
 * @date 2020/11/24 17:11
 * 测试线程池最多接收到任务数
 */
public class ThreadPoolTest {
    /**
     * 这个线程池  最多能保证130个任务执行，否则就会走拒绝策略（最大线程数 + 队列长度）
     * @return
     */
    public static ThreadPoolExecutor createThreadPool() {
        return new ThreadPoolExecutor(10, 30, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
    }


    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = ThreadPoolTest.createThreadPool();
        //最大130  通过调节i的值，可以发现，当i是100的时候，线程池的队列的剩余容量是10，验证了线程池的执行流程
        for (int i = 0; i < 130; i++) {
            threadPool.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.out.println(Thread.currentThread().getId());
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        System.out.println("11111->"+threadPool.getCorePoolSize());
        System.out.println("22222->"+threadPool.getPoolSize());
        System.out.println("---->"+threadPool.getSubmittedCount());
        System.out.println("队列剩余容量remainingCapacity--->" + threadPool.getQueue().remainingCapacity());
    }
}

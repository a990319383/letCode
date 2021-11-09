package com.sangsang.jikeshijian._1109_Exchanger;

import java.io.IOException;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用于两个线程进行数据交换（注意：是两个线程，如果不是成对出现的话，那个线程会一直等待在阻塞点）
 * Exchanger 用于两个线程间的数据交换，它提供一个同步点，在这个同步点两个线程可以交换彼此的数据
 * 使用场景：两个线程相互等待处理结果并进行数据传递。
 * 如果第一个线程先执行exchange方法，它会一直等待第二个线程也执行exchange，当两个线程都到达同步点时，这两个线程就可以交换数据，
 *      将本线程生产出来的数据传递给对方。因此使用Exchanger的重点是成对的线程使用exchange()方法，当有一对线程达到了同步点，
 *      就会进行交换数据。因此该工具类的线程对象是成对的
 *  Exchanger类提供了两个方法，String exchange(V x):用于交换，启动交换并等待另一个线程调用exchange；
 *      String exchange(V x,long timeout,TimeUnit unit)：用于交换，启动交换并等待另一个线程调用exchange，并且设置最大等待时间，当等待时间超过timeout便停止等待
 * @Author: liutangqi
 * @Date: 2021/11/9 15:31
 */
public class ExchangerTest {

    public void latch() throws InterruptedException, IOException {
        int count = 5;
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for (int x = 0; x < count; x++) {
            executorService.execute(new Worker(x, exchanger));
        }
//        System.in.read();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new ExchangerTest().latch();
    }
}

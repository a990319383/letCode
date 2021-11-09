package com.sangsang.jikeshijian._1109_Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liutangqi
 * @Date: 2021/11/9 15:26
 */
public class Worker extends Thread {

    Integer start;
    Exchanger<String> exchanger;

    public Worker(Integer start, Exchanger<String> exchanger) {
        this.start = start;
        this.exchanger = exchanger;
    }

    @Override
    public void run() throws IllegalArgumentException {
        try {
            System.out.println(Thread.currentThread().getName() + " 准备执行");
            TimeUnit.SECONDS.sleep(start);
            System.out.println(Thread.currentThread().getName() + " 等待交换");
            String value = exchanger.exchange(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " 交换得到数据为：" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

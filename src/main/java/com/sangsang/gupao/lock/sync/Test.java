package com.sangsang.gupao.lock.sync;

/**
 * @Author 哑巴湖大水怪
 * @Date 2021/1/30 22:45
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        threadA.start();
        threadB.start();
    }
}

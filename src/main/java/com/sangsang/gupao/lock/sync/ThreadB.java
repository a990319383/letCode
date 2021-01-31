package com.sangsang.gupao.lock.sync;

/**
 * @Author 哑巴湖大水怪
 * @Date 2021/1/30 22:43
 * @Version 1.0
 */
public class ThreadB extends Thread{
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("threadB  start");
            try {
                lock.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("threadB  end");
        }
    }
}

package com.sangsang.gupao.lock.sync;

/**
 * @Author 哑巴湖大水怪
 * @Date 2021/1/30 22:43
 * @Version 1.0
 */
public class ThreadA  extends Thread{
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
    /*    try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synchronized (lock){
            System.out.println("threadA  start");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadA  end");
        }
    }
}

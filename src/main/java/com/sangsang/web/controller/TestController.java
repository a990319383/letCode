package com.sangsang.web.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 测试controller
 */
@RestController
public class TestController {
    @Resource(name = "redissonSingle")
    private RedissonClient redissonClient;

    /**
     * 查看redission看门狗机制是否生效
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/test")
    public Object test1() throws InterruptedException {
        RLock fairLock = redissonClient.getFairLock("fairLock");
        fairLock.tryLock(1, TimeUnit.SECONDS);//会触发看门狗
        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
//        boolean res = fairLock.tryLock(100, 20, TimeUnit.SECONDS);//这种情况发现redis中的缓存的过期时间并没有进行续时
//        fairLock.tryLock();//会触发看门狗
//        fairLock.lock();
//        fairLock.lock(20, T
//        imeUnit.SECONDS);//不会触发看门狗，锁会被释放掉 可以通过查看redis中的缓存信息
        System.out.println("进入睡眠");
        Thread.sleep(30000);
        if (fairLock.isHeldByCurrentThread()) {
            System.out.println("锁还在");
        } else {
            System.out.println("锁已经释放掉了");
        }
        return "成功";

    }

    /**
     * 这里资源锁住了只是自旋等待
     * https://mp.weixin.qq.com/s/95N8mKRreeOwaXLttYCbcQ  redisson介紹
     */
    @RequestMapping("/aaa")
    public void aaa() {
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    RLock fairLock = redissonClient.getFairLock("testCount");
                    try {
                        fairLock.tryLock(100, 10, TimeUnit.SECONDS);
                        Thread.sleep(1000);
                        System.out.println("获取了锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        fairLock.unlock();
                    }

                }
            }).start();
        }
    }
}

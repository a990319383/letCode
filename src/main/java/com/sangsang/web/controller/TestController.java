package com.sangsang.web.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/test")
    public Object test1() throws InterruptedException {
        RLock fairLock = redissonClient.getFairLock("fairLock");
//        fairLock.tryLock(1, TimeUnit.SECONDS);//会触发看门狗
        fairLock.lock(1,TimeUnit.SECONDS );//不会触发看门狗，锁会被释放掉
        Thread.sleep(3000);
        if(fairLock.isHeldByCurrentThread()){
            System.out.println("锁还在");
        }else {
            System.out.println("锁已经释放掉了");
        }
        return "成功";

    }
}

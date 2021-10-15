package com.sangsang.redisson.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * https://www.cnblogs.com/yangzhilong/p/7605807.html
 */
@Configuration
@ConditionalOnClass(Config.class)//ConditionalOnClass注解：判断当前classpath存在 Config.class这个类才装配
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {
    @Resource
    private RedissonProperties redssionProperties;
    /*    *//**
     * 哨兵模式自动装配
     *//*
    @Bean
//    @ConditionalOnProperty(name="redisson.master-name")
    RedissonClient redissonSentinel() {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(redssionProperties.getSentinelAddresses())
                .setMasterName(redssionProperties.getMasterName())
                .setTimeout(redssionProperties.getTimeout())
                .setMasterConnectionPoolSize(redssionProperties.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redssionProperties.getSlaveConnectionPoolSize());

        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }
        return Redisson.create(config);
    }*/

    /**
     * 单机模式自动装配
     *
     * @return
     */
    @Bean(name="redissonSingle")
    @ConditionalOnProperty(name = "redisson.address")
    RedissonClient redissonSingle() {
        Config config = new Config();
        config.setLockWatchdogTimeout(1000L);
        SingleServerConfig serverConfig = config.useSingleServer()
                .setDatabase(redssionProperties.getDatabase())
                .setAddress(redssionProperties.getAddress())
                .setTimeout(redssionProperties.getTimeout())
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());

        if (StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }

        return Redisson.create(config);
    }

    /**
     * 集群模式装配
     *
     * @return
     */
    @Bean(name = "redissonClustering")
    RedissonClient redissonClustering() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
                //可以用"rediss://"来启用SSL连接
                .addNodeAddress("redis://192.168.2.154:7000",
                        "redis://192.168.2.154:7001",
                        "redis://192.168.2.155:7002",
                        "redis://192.168.2.155:7003",
                        "redis://192.168.2.157:7004",
                        "redis://192.168.2.157:7005")
                .setPassword("zjxl2019#");
        return Redisson.create(config);
    }
}

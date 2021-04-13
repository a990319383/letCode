package com.sangsang.roketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.UUID;

/**
 * 消息消费者
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("fenzu111");
        producer.setNamesrvAddr("172.17.47.60:9876");
        producer.start();
        Message message = new Message("testTopic111", "tagA1", ("消息:"+ UUID.randomUUID()).getBytes());
        SendResult result = producer.send(message);
    }
}

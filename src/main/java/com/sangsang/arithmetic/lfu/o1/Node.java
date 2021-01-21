package com.sangsang.arithmetic.lfu.o1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 哑巴湖大水怪
 * @date 2021/1/12 10:00
 * 表示每一个节点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node {
    /**
     * 数据的key
     */
    private String key;
    /**
     * 数据存储的value
     */
    private Object value;
    /**
     * 改数据的访问频次
     */
    private int freq;
}

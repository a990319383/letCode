package com.sangsang.arithmetic.lfu.o1;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;

/**
 * @author 哑巴湖大水怪
 * @date 2021/1/12 10:29
 * Lfu算法实现 todo
 */
@NoArgsConstructor
public class LfuCache {
    //存储的具体的数据
    private Map<String, Node> datas = new HashMap<>();
    //记录访问频次和对应的节点
    private Map<Integer, LinkedHashSet<Node>> freqs = new HashMap<>();
    //缓存的容量
    private int capacity = 10;
    //最小的访问频次
    private int miniFreq = 1;

    //构造方法初始话容量
    public LfuCache(int capacity) {
        assert capacity > 0;
        this.capacity = capacity;
    }


    //往缓存中放数据
    public void putData(String key, Object obj) {
        //1.当前缓存容量是否已满
        if (datas.size() <= capacity) {
            //1.1判断缓存中有没有该数据
            Node cacheNode = datas.get(key);
            if (cacheNode == null) {
                Node newNode = Node.builder().key(key).value(obj).freq(1).build();
                //维护存储数据的map
                datas.put(key, newNode);
                LinkedHashSet<Node> freqNode = freqs.get(1);
                //维护记录频次的数据map
                if (freqNode == null) {
                    LinkedHashSet<Node> freq1Node = new LinkedHashSet<>();
                    freq1Node.add(newNode);
                    freqs.put(1, freq1Node);
                } else {
                    freqNode.add(newNode);
                }
            } else {

            }
        } else {

        }
        //2.判断是否需要淘汰数据
        checkWeedOutData();
    }

    //访问数据（增删改 该key时都算访问）
    private void visitData(String key) {

    }

    //判断是否需要淘汰数据
    private void checkWeedOutData() {
        if (datas.size() > capacity) {
            LinkedHashSet<Node> nodes = freqs.get(miniFreq);
            //该访问频次中最老的一条数据就是需要淘汰的旧数据
            Node weedOutNode = nodes.iterator().next();
            //清除记录频次的缓存
            nodes.remove(weedOutNode);
            //清除存储数据的缓存
            datas.remove(weedOutNode.getKey());
        }
    }

    /**
     * 删除数据
     *
     * @param key
     */
    public void removeData(String key) {
        Node removeNode = datas.get(key);
        Optional.ofNullable(removeNode).orElseThrow(() -> new IllegalArgumentException("该key 不存在，无法删除"));
        //删除存储map
        datas.remove(key);
        //删除记录次数的map
        int freq = removeNode.getFreq();
        freqs.get(freq).remove(removeNode);
        //如果该频次的缓存是最低的频次，则删除完毕后重新维护新的最小
        if (freqs.get(freq).isEmpty() && freq == miniFreq && datas.size() > 0) {
            while (freqs.get(miniFreq).isEmpty()) {
                miniFreq++;
            }
        }
    }


    public static void main(String[] args) {
        LfuCache lfuCache = new LfuCache(2);
        lfuCache.putData("aaa","aaaaaaa");
        lfuCache.putData("bbb","bbbbbbb");
        lfuCache.putData("ccc","cccccc");
//        lfuCache.removeData("aaa");
        System.out.println(lfuCache.datas);
        System.out.println(lfuCache.freqs);
    }
}

package com.sangsang.dataStructure.bitmap;

import java.util.BitSet;

/**
 * @author 哑巴湖大水怪
 * @date 2020/12/25 11:20
 * bitMap
 */
public class BitMapTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        //void set(int bitIndex, boolean value)
        bitSet.set(3);
        bitSet.set(5);
        bitSet.set(4);
        bitSet.set(7);
        bitSet.set(10);
        bitSet.set(10);
        bitSet.set(10);
        System.out.println(bitSet);
        for (int i = 0; i <2000000000 ; i++) {
            bitSet.set(i);
        }
        // 装20亿数据比较快
        System.out.println(bitSet.length());
      /*
      代码运行直接卡死
      ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <2000000000 ; i++) {
            list.add(i);
        }
        System.out.println(list.size());*/
    }
}

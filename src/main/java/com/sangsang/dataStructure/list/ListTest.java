package com.sangsang.dataStructure.list;

import com.sangsang.util.CountDownLatchUtil;
import com.sangsang.util.CustomTryCatch;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 哑巴湖大水怪
 * @date 2021/1/15 17:08
 * list线程不安全及扩容测试
 * 项目中有没有设置初始容量为8，存储8条数据，未扩容发现丢失数据的问题，用反射查看容量字段发现并未扩容
 * ，将容量修改为16后解决，具体原因未知，下面未能复现
 *
 */
public class ListTest {
    public static void main(String[] args) throws Exception {
      /*  List<Integer> ints=new ArrayList<>(100);
        Class<? extends List> intClass = ints.getClass();
        Field field = intClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(ints);
        System.out.println("这个ArrayList的容量为："+elementData.length+
                ",这个ArrayList中元素的个数为"+ints.size());
        AtomicInteger a = new AtomicInteger(1);
        new CountDownLatchUtil(100).latch(()->{
            ints.add(a.incrementAndGet());
        });
        System.out.println(ints);

        Class<? extends List> intClassNew = ints.getClass();
        Field fieldNew = intClassNew.getDeclaredField("elementData");
        fieldNew.setAccessible(true);
        Object o = fieldNew.get(ints);
        Object[] elementDataNew = (Object[]) fieldNew.get(ints);
        System.out.println("这个ArrayList的容量为："+elementDataNew.length+
                ",这个ArrayList中元素的个数为"+ints.size());*/
        CustomTryCatch.voidWrap(() -> {
            ArrayList<Integer> list = new ArrayList<>(8);
            CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
                list.add(1);
                CustomTryCatch.voidWrap(() -> Thread.sleep(100));
                list.add(2);
                CustomTryCatch.voidWrap(() -> Thread.sleep(1000));
            });
            CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
                list.add(3);
                list.add(4);
            });
            CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> {
                list.add(5);
                CustomTryCatch.voidWrap(() -> Thread.sleep(3000));
                list.add(6);
            });
            CompletableFuture<Void> f4 = CompletableFuture.runAsync(() -> {
                list.add(7);
                CustomTryCatch.voidWrap(() -> Thread.sleep(100));
                list.add(8);
            });
            CompletableFuture.allOf(f1, f2, f3, f4).join();
            Class<? extends List> intClass = list.getClass();
            Field field = intClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(list);
            System.out.println("这个ArrayList的容量为：" + elementData.length +
                    ",这个ArrayList中元素的个数为" + list.size());
            System.out.println(list);
        });
    }
}

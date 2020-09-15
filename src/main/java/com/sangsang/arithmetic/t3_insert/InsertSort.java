package com.sangsang.arithmetic.t3_insert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

//插入排序

/**
 * 插入排序就是维护一个有序区，将新的数据插入有序区中
 * 每次和前面的数据依次比较，知道不满足的时候停止
 * 交换数据版本
 */
public class InsertSort {
    public static int[] insert1(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }else {
                    continue;
                }
            }
        }
        return nums;
    }

    /**
     * 优化版：
     *  不必要每次插入的时候都进行交换，和斗地主扑克排序一样，抽出来找到合适的位置再插入
     * @param nums
     * @return
     */
    public static int[] insert2(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            int insertNum = nums[i];//需要插入的值
            int insertIndex = 0;//记录需要插入的值
            for (int j = i; j >0; j--) {
                if (insertNum < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                }else {
                    insertIndex = j;
                    break;
                }
            }
            nums[insertIndex] = insertNum;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 3, 1, 7, 8, 9, 2};
        System.out.println(Arrays.toString(insert2(nums)));
    }
}

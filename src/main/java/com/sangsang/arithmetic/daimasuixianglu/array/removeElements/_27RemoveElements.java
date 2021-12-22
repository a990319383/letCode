package com.sangsang.arithmetic.daimasuixianglu.array.removeElements;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并**原地**修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:0
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class _27RemoveElements {


    /**
     * 思路：
     * 1.暴力解法：
     * 两层循环，外层遍历数组，内层移动数组
     * 2.采用快慢双指针
     * 慢指针记录需要保留的数据的下标
     * 快指针记录检查到的数据下标
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElements(nums, val));
    }


    public static int removeElements(int[] nums, int val) {
        int slowPointer = 0;//慢指针，用于标记新数组有效保留值位置
        int quickPointer = 0;//快指针，用于标记检查数组位置
        for (; quickPointer < nums.length; quickPointer++) {
            if (nums[quickPointer] == val) {
                quickPointer++;
            } else {
                nums[slowPointer] = nums[quickPointer];
                slowPointer++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slowPointer;
    }


}

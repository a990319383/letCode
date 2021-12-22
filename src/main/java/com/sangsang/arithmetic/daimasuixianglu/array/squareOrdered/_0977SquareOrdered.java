package com.sangsang.arithmetic.daimasuixianglu.array.squareOrdered;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 */
public class _0977SquareOrdered {


    /**
     * 思路：
     *      原数组是一个非递减数组（递增）
     *      只有为负数的时候 平方的排序位置才会发现变化
     * 方案：
     *      这里采用双指针，两个指针分别指向原数组的两端，比较两个指针的平方的值，选出其中大的值进行存储，移动相应指针
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squareSort(nums)));
        int[] nums2 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(squareSort(nums2)));

    }


    /**
     *
     */
    public static int[] squareSort(int[] nums) {
        int startPointer = 0;
        int endPointer = nums.length - 1;
        //存储的新数组
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //选择平方较大的数，并移动到新的数组
            if (square(nums[startPointer]) >= square(nums[endPointer])) {
                newNums[nums.length - i - 1] = square(nums[startPointer]);
                startPointer++;
            } else {
                newNums[nums.length - i - 1] = square(nums[endPointer]);
                endPointer--;
            }
        }
        return newNums;
    }

    /**
     * 求平方
     *
     * @param num
     * @return
     */
    public static int square(int num) {
        return num * num;
    }

}

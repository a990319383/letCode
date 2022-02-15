package com.sangsang.arithmetic.daimasuixianglu.array.longestSubarray;

/**
 * 最长子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class _209LongestSubarray {

    /**
     * 思路：
     * 滑动窗口：不断调节子序列的起始终止位置，直到达到满足我们条件的子序列
     * 设置两个指针，分别指向每次排查的子串的开头和结尾
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(getLongestSubarray(s, nums));
    }


    public static int getLongestSubarray(int s, int[] nums) {
        int leftIndex = 0;//窗口左边指针
        int sum = 0;//窗口内数字的总和
        int result = Integer.MAX_VALUE;//满足条件的子序列的长度，默认是int类型的最大值，如果程序处理结果是int类型的最大值，则表示没有满足条件的连续子序列
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];//窗口内数字求和
            while (sum >= s) {
                result = Math.min(result, right - leftIndex + 1);//满足条件后维护最短长度
                //开始试着缩小窗口看能否满足
                sum -= nums[leftIndex];//求和的结果去除移动后的左边的那个点
                leftIndex++;//当窗口内数组大于s 时将左指针往后移，找到尽量短的长度
                System.out.println("移除了 " + nums[leftIndex]);
            }
        }
        return result;
    }

}

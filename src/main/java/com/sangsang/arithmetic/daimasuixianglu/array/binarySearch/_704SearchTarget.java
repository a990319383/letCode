package com.sangsang.arithmetic.daimasuixianglu.array.binarySearch;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * - 你可以假设 nums 中的所有元素是不重复的。
 * - n 将在 [1, 10000]之间。
 * - nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class _704SearchTarget {

    /***
     * 思路：
     * 二分查找使用前提：
     *      1.有序
     *      2.不重复
     * 边界问题注意点：
     *      1.区间定义为左闭右闭即[left, right]
     *          (1)while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
     *          (2)if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，
     *          那么接下来要查找的左区间结束下标位置就是 middle - 1
     *      2.区间定义为左闭右开即[left, right)
     *          (1)while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
     *          (2)if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，而寻找区间是左闭右开区间，
     *          所以right更新为middle，即：下一个查询区间不会去比较nums[middle]
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 7, 9, 12, 13};
        int target = 9;
        System.out.println(method1(nums, target));
        System.out.println(method2(nums, target));
    }

    // 区间定义为左闭右闭
    public static int method1(int[] nums, int target) {
        int left = 0;//左边下标
        int right = nums.length - 1;//右边下标 (这里right是有具体值的，闭区间)
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target > nums[middle]) {
                left = middle;
            } else if (target < nums[middle]) {
                right = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 区间定义为左闭右闭
    public static int method2(int[] nums, int target) {
        int left = 0;//左边下标
        int right = nums.length;//右边下标 (这里right是没有具体值的，开区间)
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (target > nums[middle]) {
                left = middle;
            } else if (target < nums[middle]) {
                right = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

}

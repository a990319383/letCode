package com.sangsang.letcode.arithmetic._04zhongweishu;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _04zhongweishu {
    public static void main(String[] args) {
        int[] nums1 =  new int[]{1, 2, 3};
        int[] nums2 =  new int[]{2};
        System.out.println(getMid(nums1,nums2));
    }

    /**
     * 思路：
     *  因为是两个有序的数组，所以先算出中间的位置，再按顺序取出这个位置的数据（类似于归并排序的归并的过程）
     * @param nums1
     * @param nums2
     * @return
     */
    public static double getMid(int[] nums1 ,int[] nums2){
        int leftIndex=0;//左边数组取值索引
        int rightIndex=0;//右边数组取值索引
        int result1 = 0;//最后取值的数据1
        int resultValue1 = 0;//存放最后的结果1
        int result2 = 0;//最后取值的数据2
        int resultValue2 = 0;//存放最后的结果2
        int len =  nums1.length + nums2.length;
        if(len%2==0){
            result1 = len / 2 - 1;
            result2 = len / 2;
        }else {
            result1 = len / 2;
            result2 = len / 2;
        }
        if(nums1.length>leftIndex+1){

        }
        return (Double.valueOf(resultValue1) +Double.valueOf(resultValue2))/2;
    }

}
